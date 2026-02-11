package com.bpi.module6.model;


import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
        name = "course_name",
        length = 50,
        columnDefinition = "VARCHAR(50)"
    )
    private String courseName;

    @Column(
        name = "grade",
        length = 2,
        columnDefinition = "VARCHAR(2)"
    )
    private String grade;

    //(Foreign Key here)
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Getters & Setters
    public Long getId() { return id; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}

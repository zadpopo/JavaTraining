package com.bpi.module6.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
        name = "name",
        nullable = false,
        length = 50,
        columnDefinition = "VARCHAR(50)"
    )
    private String name;

    @Column(
        name = "age",
        columnDefinition = "INT"
    )
    private int age;

    @Column(
        name = "email",
        unique = true,
        length = 100,
        columnDefinition = "VARCHAR(100)"
    )
    private String email;

    // ✅ getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
package com.bpi.moduleM6;

import com.bpi.module6.model.Course;
import com.bpi.module6.model.Student;
import com.bpi.module6.uti.EntityManagerUtil;
import jakarta.persistence.EntityManager;

public class App {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

        try {
            persistOneToMany(em);
        } finally {
            EntityManagerUtil.getInstance().closeEntityManager(em);
            EntityManagerUtil.getInstance().shutdownFactory();
        }
    }

    static void persistOneToMany(EntityManager em) {
        em.getTransaction().begin();

        // Fetch existing student
        Student student1 = em.find(Student.class, 1L);

        // Course 1
        Course math = new Course();
        math.setCourseName("Math");
        math.setGrade("75");
        math.setStudent(student1);
        em.persist(math);

        // Course 2
        Course english = new Course();
        english.setCourseName("English");
        english.setGrade("70");
        english.setStudent(student1);
        em.persist(english);

        em.getTransaction().commit();
    }
}
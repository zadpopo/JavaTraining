package com.bpi.moduleM6;

import java.util.List;

import com.bpi.module6.model.Student;
import com.bpi.module6.uti.EntityManagerUtil; // <-- now 'util' after the rename
import jakarta.persistence.EntityManager;

public class App {



public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
        try {
            // 1) print all student names (shows "Hibernate: select s1_0.name from students s1_0")
            findStudentNames1(em);

            // 2) count courses for student with id = 1 (shows a JOIN count SQL)
            countCoursesByStudentId1(em, 1L);

            // 3) count students age >= 23 (shows a WHERE age>=? count SQL)
            countStudentsByAgeAtLeast(em, 23);

        } finally {
            EntityManagerUtil.getInstance().closeEntityManager(em);
            EntityManagerUtil.getInstance().shutdownFactory();
        }
    }

    // Prints every student's name (field projection) — matches the first SQL line in your screenshot
    static void findStudentNames1(EntityManager em) {
        em.getTransaction().begin();

        String jpql = "SELECT s.name FROM Student s";
        List<String> names = em.createQuery(jpql, String.class).getResultList();

        // Print each name on its own line, like your screenshot
        names.forEach(System.out::println);

        em.getTransaction().commit();
    }

    // Prints: "Number of Courses by Student with ID X: N"
    // Uses JOIN so Hibernate emits a join in SQL (as in the screenshot)
    static void countCoursesByStudentId1(EntityManager em, Long studentId) {
        em.getTransaction().begin();

        String jpql = "SELECT COUNT(c.id) FROM Course c JOIN c.student s WHERE s.id = :id";
        Long count = em.createQuery(jpql, Long.class)
                       .setParameter("id", studentId)
                       .getSingleResult();

        System.out.println("Number of Courses by Student with ID " + studentId + ": " + count);

        em.getTransaction().commit();
    }

    // Prints: "Students that are age X and above: N"
    static void countStudentsByAgeAtLeast(EntityManager em, int age) {
        em.getTransaction().begin();

        String jpql = "SELECT COUNT(s.id) FROM Student s WHERE s.age >= :age";
        Long count = em.createQuery(jpql, Long.class)
                       .setParameter("age", age)
                       .getSingleResult();

        System.out.println("Students that are age " + age + " and above: " + count);

        em.getTransaction().commit();
    }



 
    static void m6Activity4Solution(EntityManager em) {

        em.getTransaction().begin();

        // (1) create Student object (TRANSIENT)
        Student newStudent = new Student();
        newStudent.setName("Maria Santos");
        newStudent.setAge(21);
        // Ensure uniqueness because email is UNIQUE in DB:
        newStudent.setEmail("maria_" + System.currentTimeMillis() + "@example.com");

        // (2) attach transient -> MANAGED
        em.persist(newStudent);

        // (3) flush -> forces INSERT now
        em.flush();

        // (4) detach -> becomes DETACHED (no longer tracked)
        em.detach(newStudent);

        // (5) check persistence context: should be false
        System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));

        // (6) merge detached -> returns a MANAGED instance (assign it back)
        newStudent = em.merge(newStudent);

        // (7) update values while MANAGED
        newStudent.setAge(25);
        newStudent.setEmail("maria_updated_" + System.currentTimeMillis() + "@example.com");

        // (8) flush -> forces UPDATE
        em.flush();

        // (9) check again: should be true (this is the managed instance)
        System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));

        // (10) remove -> mark for deletion
        em.remove(newStudent);

        // (11) flush -> forces DELETE
        em.flush();

        // (12) after delete, entity is no longer managed
        System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));

        em.getTransaction().commit();
    }
    
    
   
    static void findStudentNames(EntityManager em) {
        em.getTransaction().begin();

        String jpql = "SELECT s.name FROM Student s";
        var query = em.createQuery(jpql, String.class);

        var names = query.getResultList();

        System.out.println("=== Student Names ===");
        names.forEach(System.out::println);

        em.getTransaction().commit();
    }
    
    
    static void countCoursesByStudentId(EntityManager em, Long studentId) {
        em.getTransaction().begin();

        String jpql = "SELECT COUNT(c) FROM Course c WHERE c.student.id = :id";
        var query = em.createQuery(jpql, Long.class);
        query.setParameter("id", studentId);

        Long count = query.getSingleResult();

        System.out.println("Student " + studentId + " has " + count + " courses.");

        em.getTransaction().commit();
    }
    
    static void findStudentsByAgeGreaterThan(EntityManager em, int age) {
        em.getTransaction().begin();

        String jpql = "SELECT s FROM Student s WHERE s.age > :age";
        var query = em.createQuery(jpql, Student.class);
        query.setParameter("age", age);

        var students = query.getResultList();

        System.out.println("=== Students older than " + age + " ===");
        students.forEach(s -> System.out.println(s.getName() + " (" + s.getAge() + ")"));

        em.getTransaction().commit();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
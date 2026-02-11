package com.bpi.moduleM6;

import com.bpi.module6.model.Student;
import com.bpi.module6.uti.EntityManagerUtil; // <-- now 'util' after the rename
import jakarta.persistence.EntityManager;

public class App {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getInstance().createEntityManager();

        try {
            m6Activity4Solution(em);
        } finally {
            EntityManagerUtil.getInstance().closeEntityManager(em);
            EntityManagerUtil.getInstance().shutdownFactory();
        }
    }

    /**
     * M6_Activity4 - EntityManager lifecycle + CRUD demo
     * Steps per slide:
     * 1) create Student (transient)
     * 2) persist (managed)
     * 3) flush (INSERT)
     * 4) detach (detached)
     * 5) contains() -> false
     * 6) merge (managed again)
     * 7) update fields
     * 8) flush (UPDATE)
     * 9) contains() -> true
     * 10) remove (mark for deletion)
     * 11) flush (DELETE)
     * 12) contains() -> false
     */
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
}
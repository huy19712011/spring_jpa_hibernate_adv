package com.example.spring_jpa_hibernate_adv.repository;

import com.example.spring_jpa_hibernate_adv.entity.Passport;
import com.example.spring_jpa_hibernate_adv.entity.Student;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Student findById(Long id) {

        return em.find(Student.class, id);
    }

    public Student save(Student student) {
        if (student.getId() == null) {
            em.persist(student);
        } else {
            em.merge(student);
        }

        return student;
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z123456");
        em.persist(passport);

        Student student = new Student("Mike");
        student.setPassport(passport);

        em.persist(student);
    }

    public void deleteById(long id) {

        Student student = findById(id);
        em.remove(student);
    }

    public void someOperationsToUnderstandPersistenceContext() {
        // Retrieve student
        Student student = em.find(Student.class, 20001L);
        // Persistence context: student

        // Retrieve passport
        Passport passport = student.getPassport();
        // Persistence context: student, passport

        // Update passport
        passport.setNumber("E1234567");
        // Persistence context: student, passport+


        // Update name
        student.setName("AAA - Updated");
        // Persistence context: student+, passport+
    }
}

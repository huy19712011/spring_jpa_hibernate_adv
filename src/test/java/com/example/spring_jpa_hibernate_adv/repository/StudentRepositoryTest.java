package com.example.spring_jpa_hibernate_adv.repository;

import com.example.spring_jpa_hibernate_adv.entity.Course;
import com.example.spring_jpa_hibernate_adv.entity.Passport;
import com.example.spring_jpa_hibernate_adv.entity.Student;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class StudentRepositoryTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    @Test
//    @Transactional // Persistant context
    public void someTests() {
        repository.someOperationsToUnderstandPersistenceContext();

    }


    @Test
    @Transactional
    void retrieveStudentAndPassport() {

        Student student = this.em.find(Student.class, 20001L);

        logger.info("Student -> {}", student);
        logger.info("Passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    void retrievePassportAndAssociatedStudent() {

        Passport passport = this.em.find(Passport.class, 40001L);

        logger.info("Passport -> {}", passport);
        logger.info("Student -> {}", passport.getStudent());
    }

    @Test
    @Transactional
    void retrieveStudentAndCourse() {

        Student student = em.find(Student.class, 20001L);
        logger.info("student ---> {}", student);
        logger.info("courses --> {}", student.getCourses());
    }

    @Test
    @Transactional
    void retrieveCourseAndStudent() {

        Course course = em.find(Course.class, 10001L);
        logger.info("course ---> {}", course);
        logger.info("students --> {}", course.getStudents());
    }


}
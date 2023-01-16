package com.example.spring_jpa_hibernate_adv.repository;

import com.example.spring_jpa_hibernate_adv.entity.Course;
import com.example.spring_jpa_hibernate_adv.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class JpqlTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void jPQL_basic() {

//        Query query = em.createQuery("SELECT c from Course c");
        Query query = em.createNamedQuery("query_get_all_courses");
        List resultList =
                query.getResultList();

        logger.info("SELECT c from Course c -> {}", resultList);
    }

    @Test
    void jPQL_typed() {

//        TypedQuery<Course> query = em.createQuery("SELECT c from Course c", Course.class);
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("SELECT c from Course c -> {}", resultList);
    }

    @Test
    void jPQL_where() {

//        TypedQuery<Course> query = em.createQuery("SELECT c from Course c where name like '%Spring%'", Course.class);
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses_where", Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("SELECT c from Course c -> {}", resultList);
    }

    @Test
    void jPQL_courses_without_students() {

        TypedQuery<Course> query = em.createQuery("SELECT c from Course c where c.students is empty", Course.class);

        List<Course> resultList = query.getResultList();

        logger.info("Result -> {}", resultList);
    }

    @Test
    void jPQL_courses_with_atleast_2_students() {

        TypedQuery<Course> query = em.createQuery("SELECT c from Course c where size(c.students) >= 2", Course.class);

        List<Course> resultList = query.getResultList();

        logger.info("Result -> {}", resultList);
    }

    @Test
    void jPQL_courses_order_by_students() {

        TypedQuery<Course> query = em.createQuery("SELECT c from Course c order by size(c.students) desc", Course.class);

        List<Course> resultList = query.getResultList();

        logger.info("Result -> {}", resultList);
    }

    @Test
    void jPQL_students_with_passport_in_a_certain_pattern() {

        TypedQuery<Student> query = em.createQuery("SELECT s from Student s where s.passport.number like '%1234%'", Student.class);

        //like
        //between 100 and 200
        // is null
        // upper, lower, trim, length

        List<Student> resultList = query.getResultList();

        logger.info("Result -> {}", resultList);
    }

    //JOIN => select c, s from Course c JOIN c.students s
    //LEFT JOIN => select c, s from Course c LEFT JOIN c.students s
    //CROSS JOIN => select c, s from Course c, Student s

    @Test
    public void join(){

        Query query = em.createQuery("select c, s from Course c JOIN c.students s");
        List<Objects[]> resultList = query.getResultList();
        logger.info("result size -> {}", resultList.size());
        logger.info("result list  -> {}", resultList);
//        for (var result: resultList) {
//            logger.info("Course{} Student{}", result[0], result[1]);
//            logger.info("result -> {}", result);
//        }
    }

    @Test
    public void left_join(){

        Query query = em.createQuery("select c, s from Course c LEFT JOIN c.students s");
        List<Objects[]> resultList = query.getResultList();
        logger.info("result size -> {}", resultList.size());
        logger.info("result list  -> {}", resultList);
//        for (var result: resultList) {
//            logger.info("Course{} Student{}", result[0], result[1]);
//            logger.info("result -> {}", result);
//        }
    }

}
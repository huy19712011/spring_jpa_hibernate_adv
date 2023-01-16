package com.example.spring_jpa_hibernate_adv.repository;

import com.example.spring_jpa_hibernate_adv.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

}
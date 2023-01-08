package com.example.spring_jpa_hibernate_adv.repository;

import com.example.spring_jpa_hibernate_adv.entity.Course;
import jakarta.persistence.EntityManager;
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

        List resultList =
                em.createQuery("SELECT c from Course c").getResultList();

        logger.info("SELECT c from Course c -> {}", resultList);
    }

    @Test
    void jPQL_typed() {

        TypedQuery<Course> query = em.createQuery("SELECT c from Course c", Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("SELECT c from Course c -> {}", resultList);
    }

    @Test
    void jPQL_where() {

        TypedQuery<Course> query = em.createQuery("SELECT c from Course c where name like '%Spring%'", Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("SELECT c from Course c -> {}", resultList);
    }

}
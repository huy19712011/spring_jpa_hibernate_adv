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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class NativeQueriesTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void native_queries_basic() {

        Query query = em.createNativeQuery("select * from course", Course.class);
        List resultList =
                query.getResultList();

        logger.info("SELECT * from Course -> {}", resultList);
    }

    @Test
    void native_queries_with_parameters() {

        Query query = em.createNativeQuery("select * from course where id=?", Course.class);
        query.setParameter(1, 10001L);
        List resultList =
                query.getResultList();

        logger.info("SELECT * from Course where id = ? -> {}", resultList);
    }

    @Test
    void native_queries_with_named_parameters() {

        Query query = em.createNativeQuery("select * from course where id=:id", Course.class);
        query.setParameter("id", 10001L);
        List resultList =
                query.getResultList();

        logger.info("SELECT * from Course where id = :id -> {}", resultList);
    }

    @Test
    @Transactional
    void native_queries_to_update() {

        Query query = em.createNativeQuery("update course set last_updated_date=sysdate()", Course.class);
        int numberOfRowsUpdated =
                query.executeUpdate();

        logger.info("numberOfRowsUpdated -> {}", numberOfRowsUpdated);
    }

}
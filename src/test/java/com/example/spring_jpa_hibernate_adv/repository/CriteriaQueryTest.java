package com.example.spring_jpa_hibernate_adv.repository;

import com.example.spring_jpa_hibernate_adv.entity.Course;
import com.example.spring_jpa_hibernate_adv.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

@SpringBootTest
class CriteriaQueryTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void jPQL_basic() {

        // 1. Use Criteria Builder to create a Criteria Query returning the result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        //2. Define roots for tables which are involved in query
        Root<Course> courseRoot = cq.from(Course.class);

        //3. Define predicate etc. using Criteria Builder

        //4. Add predicate etc. to the Criteria query

        // 5. Build the TypedQuery using EntityManager and criteria query

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList =
                query.getResultList();

        logger.info("SELECT c from Course c -> {}", resultList);
    }

    @Test
    void all_courses_having_web() {
        // select c from Course c where name like %JPA

        // 1. Use Criteria Builder to create a Criteria Query returning the result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        //2. Define roots for tables which are involved in query
        Root<Course> courseRoot = cq.from(Course.class);

        //3. Define predicate etc. using Criteria Builder
        Predicate likeJPA = cb.like(courseRoot.get("name"), "%JPA");

        //4. Add predicate etc. to the Criteria query
        cq.where(likeJPA);

        // 5. Build the TypedQuery using EntityManager and criteria query

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList =
                query.getResultList();

        logger.info("select c from Course c where name like %JPA -> {}", resultList);
    }

    @Test
    void all_courses_without_students() {
        // select c from Course c where c.students is empty

        // 1. Use Criteria Builder to create a Criteria Query returning the result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        //2. Define roots for tables which are involved in query
        Root<Course> courseRoot = cq.from(Course.class);

        //3. Define predicate etc. using Criteria Builder
        Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));

        //4. Add predicate etc. to the Criteria query
        cq.where(studentsIsEmpty);

        // 5. Build the TypedQuery using EntityManager and criteria query

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList =
                query.getResultList();

        logger.info("select c from Course c where c.students is empty -> {}", resultList);
    }

    @Test
    void join() {
        // select c from Course c join c.students

        // 1. Use Criteria Builder to create a Criteria Query returning the result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        //2. Define roots for tables which are involved in query
        Root<Course> courseRoot = cq.from(Course.class);

        //3. Define predicate etc. using Criteria Builder
        Join<Object, Object> join = courseRoot.join("students");

        //4. Add predicate etc. to the Criteria query

        // 5. Build the TypedQuery using EntityManager and criteria query

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList =
                query.getResultList();

        logger.info("select c from Course c join c.students -> {}", resultList);
    }

    @Test
    void left_join() {
        // select c from Course c left join c.students

        // 1. Use Criteria Builder to create a Criteria Query returning the result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        //2. Define roots for tables which are involved in query
        Root<Course> courseRoot = cq.from(Course.class);

        //3. Define predicate etc. using Criteria Builder
        Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);

        //4. Add predicate etc. to the Criteria query

        // 5. Build the TypedQuery using EntityManager and criteria query

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList =
                query.getResultList();

        logger.info("select c from Course c left join c.students -> {}", resultList);
    }


}
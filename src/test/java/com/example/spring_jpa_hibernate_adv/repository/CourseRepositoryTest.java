package com.example.spring_jpa_hibernate_adv.repository;

import com.example.spring_jpa_hibernate_adv.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Test
    void findById() {

        logger.info("test running ...");

        Course course = repository.findById(10001L);
        assertEquals("Learn Spring", course.getName());

    }

    @Test
    @DirtiesContext //@DirtiesContext does not work when running SpringBootTest with JUnit5 parallel execution
    void deleteById() {

        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }
}
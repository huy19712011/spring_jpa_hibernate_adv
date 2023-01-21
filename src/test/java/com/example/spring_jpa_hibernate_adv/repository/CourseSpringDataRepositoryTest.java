package com.example.spring_jpa_hibernate_adv.repository;

import com.example.spring_jpa_hibernate_adv.entity.Course;
import com.example.spring_jpa_hibernate_adv.entity.Review;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseSpringDataRepositoryTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;

    @Autowired
    EntityManager em;

    @Test
    void findById_coursePresent() {

        Optional<Course> courseOptional = repository.findById(10001L);
        assertTrue(courseOptional.isPresent());
    }

    @Test
    void findById_courseNotPresent() {

        Optional<Course> courseOptional = repository.findById(20001L);
        assertFalse(courseOptional.isPresent());
    }

    @Test
    public void playingAroundWithSpringDataRepository() {

        Course course = new Course("Microservices");
        repository.save(course);

        course.setName("Microservices - updated");
        repository.save(course);

        logger.info("courses -> {}", repository.findAll());
        logger.info("count -> {}", repository.count());

    }

    @Test
    public void sort() {

        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        Sort sort2 = Sort.by(Sort.Direction.ASC, "name").and(Sort.by(Sort.Direction.ASC, "id")); // adding criteria to sort
        logger.info("Sorted courses -> {}", repository.findAll(sort));
        logger.info("Sorted courses -> {}", repository.findAll(sort2));


    }


}
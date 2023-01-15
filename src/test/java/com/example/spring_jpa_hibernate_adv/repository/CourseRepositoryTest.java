package com.example.spring_jpa_hibernate_adv.repository;

import com.example.spring_jpa_hibernate_adv.entity.Course;
import com.example.spring_jpa_hibernate_adv.entity.Review;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Autowired
    EntityManager em;

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

    @Test
    void save() {

        Course course = repository.findById(10001L);
        assertEquals("Learn Spring", course.getName());

        course.setName("Learn Spring - Updated");
        repository.save(course);

        Course courseUpdated = repository.findById(10001L);
        assertEquals("Learn Spring - Updated", courseUpdated.getName());

    }

    @Test
    void playWithEntityManager() {

        repository.playWithEntityManager();
    }

    @Test
    @Transactional
    public void retrieveReviewsForCourse() {
        Course course = repository.findById(10001L);
        logger.info("----> {}", course.getReviews());
    }

    @Test
    @Transactional
    public void retrieveCourseForReview() {
        Review review = em.find(Review.class, 50001L);
        logger.info("----> {}", review.getCourse());
    }
}
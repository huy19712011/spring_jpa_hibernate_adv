package com.example.spring_jpa_hibernate_adv.repository;

import com.example.spring_jpa_hibernate_adv.entity.Course;
import com.example.spring_jpa_hibernate_adv.entity.Review;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(Long id) {

        return em.find(Course.class, id);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }

        return course;
    }

    public void deleteById(long id) {

        Course course = findById(id);
        em.remove(course);
    }

    public void playWithEntityManager() {

        Course course = new Course("Web services");
        em.persist(course);

        Course course2 = findById(10001L);
        course2.setName(course2.getName() + " - Updated");
    }

    public void addHardCodeReviewsForCourse() {

        // get course 10003
        Course course = findById(10003L);
        logger.info("course.getReviews() -> {}",course.getReviews());

        // add 2 reviews
        Review review1 = new Review("5", "Review 1");
        Review review2 = new Review("5", "Review 2");

        // setting the relationships
        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        // save to the database
        em.persist(review1);
        em.persist(review2);
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews) {

        // get course 10003
        Course course = findById(courseId);
        logger.info("course.getReviews() -> {}",course.getReviews());

/*
        // add reviews
        reviews.forEach(course::addReview);

        // setting relationship
        reviews.forEach(review -> review.setCourse(course));

        // save to the database
        reviews.forEach(review -> em.persist(review));
*/

        reviews.forEach(review -> {
            // add review
            course.addReview(review);
            // setting relationship
            review.setCourse(course);
            // save to the database
            em.persist(review);
        });
    }
}

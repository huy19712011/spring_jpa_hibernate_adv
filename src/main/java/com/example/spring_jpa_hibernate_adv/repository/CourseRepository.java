package com.example.spring_jpa_hibernate_adv.repository;

import com.example.spring_jpa_hibernate_adv.entity.Course;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

        logger.info("playWithEntityManager - start");

        // Create a new thing
        Course course = new Course("Web services");
        em.persist(course);

        course.setName("Web services - Updated"); // also update on database because @Transactional!!!
    }
}

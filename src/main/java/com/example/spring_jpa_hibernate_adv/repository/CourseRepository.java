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
//        em.flush();

        course.setName("Web services - Updated"); // also update on database because @Transactional!!!
//        em.flush();

        Course course2 = new Course("Angular");
        em.persist(course2);

        em.flush();// Synchronize the persistence context to the underlying database, if not => do not work properly
        em.detach(course2); // now no auto update course2 on database
        em.detach(course); // now no auto update course2 on database
//        em.clear();// ~ detach all

        course2.setName("Angular - Updated");
        course.setName("Web services - One More Updated");

        em.flush();
    }
}

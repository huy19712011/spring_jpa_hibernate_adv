package com.example.spring_jpa_hibernate_adv.repository;

import com.example.spring_jpa_hibernate_adv.entity.Course;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id) {

        return em.find(Course.class, id);
    }
}

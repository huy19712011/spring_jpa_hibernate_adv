package com.example.spring_jpa_hibernate_adv.repository;

import com.example.spring_jpa_hibernate_adv.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);

    int countByName(String name);

    List<Course> queryByName(String name); // same as findByName()

    List<Course> findByNameOrderByIdDesc(String name); // default = ASC

    List<Course> deleteByName(String name);

    @Query("SELECT c from Course c where name like '%Spring%'")
    List<Course> coursesWithSpring();

    @Query(value = "select * from Course c where name like '%Spring%'", nativeQuery = true)
    List<Course> coursesWithSpringUsingNativeQuery();

    @Query(name = "query_get_all_courses_where")
    List<Course> coursesWithSpringUsingNamedQuery();


}

package com.example.spring_jpa_hibernate_adv.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Entity
@Table(name = "course")
@NamedQuery(name = "query_get_all_courses", query = "SELECT c FROM Course c")
@NamedQuery(name = "query_get_all_courses_where", query = "SELECT c from Course c where name like '%Spring%'")

//@NamedQueries(value = {
//        @NamedQuery(name = "query_get_all_courses", query = "SELECT c FROM Course c"),
//        @NamedQuery(name = "query_get_all_courses_where", query = "SELECT c from Course c where name like '%Spring%'")
//})
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false) // other properties on Column class!!! and we can set these values.
    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    public Course(String name) {
        this.name = name;
    }

    protected Course() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

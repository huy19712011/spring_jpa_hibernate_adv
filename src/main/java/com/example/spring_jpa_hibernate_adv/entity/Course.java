package com.example.spring_jpa_hibernate_adv.entity;

import jakarta.persistence.*;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false) // other properties on Column class!!! and we can set these values.
    private String name;

    public Course(String name) {
        this.name = name;
    }

    protected Course() {}

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

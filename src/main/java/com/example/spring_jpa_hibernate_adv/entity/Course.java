package com.example.spring_jpa_hibernate_adv.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@NamedQuery(name = "query_get_all_courses", query = "SELECT c FROM Course c")
@NamedQuery(name = "query_get_all_courses_where", query = "SELECT c from Course c where name like '%Spring%'")

//@NamedQueries(value = {
//        @NamedQuery(name = "query_get_all_courses", query = "SELECT c FROM Course c"),
//        @NamedQuery(name = "query_get_all_courses_where", query = "SELECT c from Course c where name like '%Spring%'")
//})
@Cacheable
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false) // other properties on Column class!!! and we can set these values.
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses") // => course is non-owning side
    @JsonIgnore
    private List<Student> students = new ArrayList<>();

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    public Course(String name) {
        this.name = name;
    }

    protected Course() {
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Review> getReviews() {
        return reviews;
    }

    // Note 2 custom methods here instead of setter!!!
    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
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

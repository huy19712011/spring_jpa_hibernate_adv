package com.example.spring_jpa_hibernate_adv.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private ReviewRating rating;

    private String description;

    @ManyToOne
    private Course course;

    public Review(ReviewRating rating, String description) {

        this.rating = rating;
        this.description = description;
    }

    protected Review() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String name) {
        this.description = name;
    }

    @Enumerated(EnumType.STRING) // default = EnumType.ORDINAL
    public ReviewRating getRating() {
        return rating;
    }

    public void setRating(ReviewRating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

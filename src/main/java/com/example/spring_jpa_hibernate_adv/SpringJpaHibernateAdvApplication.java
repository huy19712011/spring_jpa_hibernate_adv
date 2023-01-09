package com.example.spring_jpa_hibernate_adv;

import com.example.spring_jpa_hibernate_adv.entity.Course;
import com.example.spring_jpa_hibernate_adv.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaHibernateAdvApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaHibernateAdvApplication.class, args);
        System.out.println("Ok...");
    }

    @Override
    public void run(String... args) throws Exception {

//        Course course = repository.findById(10001L);
//        logger.info("Course 10001 -> {}", course);

//        repository.save(new Course("Unit testing"));

        // repository.deleteById(10001L); // only for testing

//        repository.playWithEntityManager();
    }
}

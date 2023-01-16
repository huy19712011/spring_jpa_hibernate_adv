package com.example.spring_jpa_hibernate_adv;

import com.example.spring_jpa_hibernate_adv.entity.Course;
import com.example.spring_jpa_hibernate_adv.entity.FullTimeEmployee;
import com.example.spring_jpa_hibernate_adv.entity.PartTimeEmployee;
import com.example.spring_jpa_hibernate_adv.entity.Student;
import com.example.spring_jpa_hibernate_adv.repository.CourseRepository;
import com.example.spring_jpa_hibernate_adv.repository.EmployeeRepository;
import com.example.spring_jpa_hibernate_adv.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringJpaHibernateAdvApplication implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

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

//        studentRepository.saveStudentWithPassport();

//        courseRepository.addHardCodeReviewsForCourse();

//        List<Review> reviews = new ArrayList<>();
//        reviews.add(new Review("5", "Review 1"));
//        reviews.add(new Review("5", "Review 2"));
//
//        courseRepository.addReviewsForCourse(10003L, reviews);

//        studentRepository.insertHardcodedStudentAndCourse();

//        studentRepository.insertStudentAndCourse(new Student("Jack"), new Course("NodeJS"));


        employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
        employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("5000")));

        logger.info("all employees ---> {}", employeeRepository.retrieveAllEmployees());

    }
}

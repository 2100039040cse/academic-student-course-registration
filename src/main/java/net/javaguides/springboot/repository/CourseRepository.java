package net.javaguides.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // Define any custom query methods if needed
}

package com.diegoandcontroll.dslearnbds.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.diegoandcontroll.dslearnbds.domain.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
}

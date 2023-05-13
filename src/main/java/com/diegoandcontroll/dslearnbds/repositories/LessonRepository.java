package com.diegoandcontroll.dslearnbds.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.diegoandcontroll.dslearnbds.domain.Lesson;

public interface LessonRepository extends JpaRepository<Lesson,Long> {
}

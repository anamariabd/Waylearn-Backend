package com.app.waylearn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.waylearn.Entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson,Long> {

}

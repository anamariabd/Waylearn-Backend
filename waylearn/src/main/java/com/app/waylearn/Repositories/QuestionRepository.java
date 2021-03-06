package com.app.waylearn.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.waylearn.Entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

}

package org.spring.microservice.quizapp.dao;

import org.spring.microservice.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM QUESTION Q WHERE Q.CATEGORY =:category ORDER BY RANDOM() LIMIT :number", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int number);
}

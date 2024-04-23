package org.spring.microservice.quizapp.service;

import org.spring.microservice.quizapp.model.Question;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
public interface QuestionService {
    ResponseEntity<List<Question>> getAllQuestions();

    ResponseEntity<List<Question>> getAllQuestionsByCategory(String category);

    ResponseEntity<String> addQuestion(Question question);
}

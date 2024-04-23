package org.spring.microservice.quizapp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface QuizService {
    ResponseEntity<String> createQuiz(String category, int numQ, String title);
}

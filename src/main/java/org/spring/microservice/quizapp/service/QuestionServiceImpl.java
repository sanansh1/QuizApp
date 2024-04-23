package org.spring.microservice.quizapp.service;

import org.spring.microservice.quizapp.dao.QuestionDao;
import org.spring.microservice.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuestionDao questionDao;
    /**
     * @return
     */
    @Override
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    /**
     * @param category
     * @return
     */
    @Override
    public ResponseEntity<List<Question>> getAllQuestionsByCategory(String category) {
       return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
    }

    /**
     * @param question
     * @return
     */
    @Override
    public ResponseEntity<String> addQuestion(Question question) {
         questionDao.save(question);
         return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

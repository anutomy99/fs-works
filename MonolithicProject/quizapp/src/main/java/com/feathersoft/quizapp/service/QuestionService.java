package com.feathersoft.quizapp.service;

import com.feathersoft.quizapp.entity.Question;
import com.feathersoft.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    public ResponseEntity<String> saveQuestion(Question question){
     questionRepository.save(question);
     return new ResponseEntity<>("Success",HttpStatus.CREATED);

    }

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionRepository.findQuestionByCategory(category),HttpStatus.FOUND);
        }catch (Exception e){
            e.printStackTrace();
        }
       return  new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }
}

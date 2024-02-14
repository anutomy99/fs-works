package com.feathersoft.quizapp.controller;

import com.feathersoft.quizapp.entity.Question;
import com.feathersoft.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @PostMapping("/save")
    public ResponseEntity<String> addQuestions(@RequestBody Question question){
        return questionService.saveQuestion(question);
    }
    @GetMapping("/get-all")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return  questionService.getAllQuestions();
    }
    @GetMapping("/by-category/{category}")
    public ResponseEntity<List<Question>> getByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }
}

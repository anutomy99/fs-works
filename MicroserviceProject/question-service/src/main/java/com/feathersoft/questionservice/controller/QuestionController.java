package com.feathersoft.questionservice.controller;

import com.feathersoft.questionservice.entity.Question;
import com.feathersoft.questionservice.entity.QuestionWrapper;
import com.feathersoft.questionservice.entity.Response;
import com.feathersoft.questionservice.service.QuestionService;

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

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName,@RequestParam Integer nOfQuestions){
        return  questionService.getQuestionsForQuiz(categoryName,nOfQuestions);
    }
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds){
        return  questionService.getQuestionFromId(questionIds);
    }
    @PostMapping("getscore")
    public ResponseEntity<String> getScore(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }
}

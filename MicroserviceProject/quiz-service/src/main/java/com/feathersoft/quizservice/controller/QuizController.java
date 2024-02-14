package com.feathersoft.quizservice.controller;


import com.feathersoft.quizservice.entity.QuestionWrapper;
import com.feathersoft.quizservice.entity.QuizDto;
import com.feathersoft.quizservice.entity.Response;
import com.feathersoft.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
      return  quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNOfQuestions(),quizDto.getTitle());

    }
    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getAllQuizsByQuestions(@PathVariable int id){
       return quizService.getQuizesQuestions(id);
    }
    @PostMapping("/submit/{id}")
    public ResponseEntity<String> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }

}

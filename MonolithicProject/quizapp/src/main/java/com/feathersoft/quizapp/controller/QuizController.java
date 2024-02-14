package com.feathersoft.quizapp.controller;

import com.feathersoft.quizapp.entity.QuestionWrapper;
import com.feathersoft.quizapp.entity.Response;
import com.feathersoft.quizapp.service.QuizService;
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
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int nOfQ,@RequestParam String title){
      return  quizService.createQuiz(category,nOfQ,title);

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

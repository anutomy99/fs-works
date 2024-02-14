package com.feathersoft.quizapp.service;

import com.feathersoft.quizapp.entity.QuestionWrapper;
import com.feathersoft.quizapp.entity.Question;
import com.feathersoft.quizapp.entity.Quiz;
import com.feathersoft.quizapp.entity.Response;
import com.feathersoft.quizapp.repository.QuestionRepository;
import com.feathersoft.quizapp.repository.QuizRepository;
import jakarta.transaction.Status;
import jdk.jshell.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, int nOfQ, String title) {
        List<Question> questions = questionRepository.findRandomQuestionByCategory(category,nOfQ);
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);
            quizRepository.save(quiz);

        return new ResponseEntity<>("Successfully creted", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizesQuestions(int id) {
        Optional<Quiz> quiz =quizRepository.findById(id);
        List<Question> questionFromDb = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for (Question q :questionFromDb){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);
        }
        return  new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<String> calculateResult(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questions =quiz.get().getQuestions();
        int right=0;
        int i=0;
        for (Response response:responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;
        }
       return new ResponseEntity<>("Your total score is : "+right,HttpStatus.ACCEPTED);
    }
}

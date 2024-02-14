package com.feathersoft.quizservice.entity;

import lombok.Data;

@Data
public class QuizDto {
    String categoryName;
    Integer nOfQuestions;
    String title;

}

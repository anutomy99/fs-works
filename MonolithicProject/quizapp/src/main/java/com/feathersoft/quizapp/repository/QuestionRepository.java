package com.feathersoft.quizapp.repository;

import com.feathersoft.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> findQuestionByCategory(String category);
    @Query(value = "SELECT * FROM question q where q.category=:category ORDER BY RAND() LIMIT :nOfQ",nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int nOfQ);
}

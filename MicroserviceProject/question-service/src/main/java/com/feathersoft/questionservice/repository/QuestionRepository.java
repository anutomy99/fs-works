package com.feathersoft.questionservice.repository;


import com.feathersoft.questionservice.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> findQuestionByCategory(String category);
    @Query(value = "SELECT * FROM question q where q.category=:category ORDER BY RAND() LIMIT :nOfQ",nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String category, int nOfQ);
}

package com.example.quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quiz.model.Quiz;
@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {

}

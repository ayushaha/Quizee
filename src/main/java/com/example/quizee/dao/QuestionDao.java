package com.example.quizee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quizee.question;

@Repository
public interface  QuestionDao extends JpaRepository<question, Integer> {
    
}

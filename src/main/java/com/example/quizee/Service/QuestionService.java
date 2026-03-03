package com.example.quizee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizee.Question;
import com.example.quizee.dao.QuestionDao;


@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions(){
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category){
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question q){
        questionDao.save(q);
        return "Question added successfully";
    }

} 

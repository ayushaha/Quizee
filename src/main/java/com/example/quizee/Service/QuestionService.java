package com.example.quizee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quizee.dao.QuestionDao;
import com.example.quizee.question;


@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public List<question> getAllQuestions(){
        return questionDao.findAll();
    }

}

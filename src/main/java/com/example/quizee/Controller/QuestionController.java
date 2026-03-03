package com.example.quizee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizee.Service.QuestionService;
import com.example.quizee.question;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allquestions")
    public List<question> getQuestion(){
        return questionService.getAllQuestions();
    }

    public List<question> getCategoryQuestions(String category){
        return null;
    }
}

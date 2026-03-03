package com.example.quizee.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/quiz")
public class QuizController {
    
    @PostMapping("/create")
    public String createQuiz(@RequestParam String category,
                             @RequestParam int noOfQuestions,
                             @RequestParam String title) {
        return quizService.createQuiz(category, noOfQuestions, title);
    }
}


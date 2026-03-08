package com.example.quizee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.quizee.model.Quiz;
import com.example.quizee.Service.QuizService;
import com.example.quizee.model.QuestionWrapper;
import java.util.List;
import com.example.quizee.model.Response;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    
    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public String createQuiz(@RequestParam String category,
                             @RequestParam int noOfQuestions,
                             @RequestParam String title) {

        return quizService.createQuiz(category, noOfQuestions, title);

    }
    
    @GetMapping("get/{id}")
    public List<QuestionWrapper> getQuizById(@PathVariable Integer id) {
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public String submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
        
        return quizService.calculateScore(id, responses);       
    }
}

 
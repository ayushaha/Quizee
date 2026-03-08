package com.example.quizee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import com.example.quizee.model.QuestionWrapper;
import com.example.quizee.dao.QuestionDao;
import com.example.quizee.dao.QuizDao;
import com.example.quizee.model.Question;
import com.example.quizee.model.Quiz;
import com.example.quizee.model.Response;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Random;
import java.util.Collections;
import java.util.Optional;


@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    
    @Autowired
    QuestionDao questionDao;

    @Transactional
    public String createQuiz(String category, int noOfQuestions, String title) {
        
        
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, noOfQuestions);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return "Quiz created successfully";
    }

    public List<QuestionWrapper> getQuizQuestions(Integer id) {

        Quiz quiz = quizDao.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));

        
        List<Question> questionsFromDB = quiz.getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for (Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper();
            qw.setId(q.getId());
            qw.setQuestionTitle(q.getQuestionTitle());
            qw.setOption1(q.getOption1());
            qw.setOption2(q.getOption2());
            qw.setOption3(q.getOption3());
            qw.setOption4(q.getOption4());

            questionsForUser.add(qw);
        }
        return questionsForUser;
    }

    public String calculateScore(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        List<Question> questions = quiz.getQuestions();

        int score = 0;
        int i = 0;
        for (Response r : responses) {
           
                if (r.getResponse().equals(questions.get(i).getRightAnswer())) {
                    score++;
                }
                i++;
            
        }
        return "Your score is: " + score + "/" + questions.size();
    }   
} 



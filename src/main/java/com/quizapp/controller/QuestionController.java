package com.quizapp.controller;

import com.quizapp.entity.Question;
import com.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
       return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("/addQuestions")
    public void addQuestions(@RequestBody List<Question> questions){
        questionService.addQuestions(questions);
        System.out.println("Added Successfully");
    }



    @PostMapping("/addQuestion")
    public Question addOneQuestion(@RequestBody Question question){
         return questionService.addOneQuestion(question);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuestionById(@PathVariable Integer id){
        questionService.deleteQuestionById(id);
    }
}

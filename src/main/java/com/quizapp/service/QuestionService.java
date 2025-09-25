package com.quizapp.service;

import com.quizapp.dao.QuestionDao;
import com.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
//    Get all questions
    public List<Question> getAllQuestions() {
        return questionDao.findAll();

    }
//Find By Category
    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }
//    Save ALL
    public void addQuestions(List<Question> questions){
         questionDao.saveAll(questions);

    }
// Save one Questions
    public Question addOneQuestion(Question question){
        return  questionDao.save(question);
    }
//    Delete a question
    public void deleteQuestionById(Integer id){
        questionDao.deleteById(id);
    }


}

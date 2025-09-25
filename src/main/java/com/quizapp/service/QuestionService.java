package com.quizapp.service;

import com.quizapp.dao.QuestionDao;
import com.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    //    Get all questions
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        If nothing is found return empty arraylist
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    //Find By Category
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    //    Save ALL
    public ResponseEntity<String> addQuestions(List<Question> questions) {
        try {
            questionDao.saveAll(questions);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Not saved", HttpStatus.NOT_MODIFIED);

    }

    // Save one Questions
    public ResponseEntity<String> addOneQuestion(Question question) {
        questionDao.save(question);
        try {
            questionDao.save(question);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Not saved", HttpStatus.NOT_MODIFIED);

    }

    public ResponseEntity<String> deleteById(Integer id) {
        try {
            questionDao.deleteById(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Not deleted",HttpStatus.BAD_REQUEST);
    }
}

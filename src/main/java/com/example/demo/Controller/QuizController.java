package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.QuestionWrapper;
import com.example.demo.Model.Response;
import com.example.demo.Service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;


    @PostMapping("create")
    public ResponseEntity <String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){

       return quizService.CreateQuiz(category, numQ, title);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>>getQuiz(@PathVariable Integer id){
        return quizService.getQuiz(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response>responses){
        return quizService.calculateResult(id, responses);
    }

    @DeleteMapping("deletequiz/{id}")
    public ResponseEntity<String>deleteQuiz(@PathVariable Integer id){
        return quizService.deleteQuiz(id);
    }



}

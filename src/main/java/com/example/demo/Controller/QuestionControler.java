package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

import com.example.demo.Model.Question;
import com.example.demo.Service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionControler {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allquestion")
    public ResponseEntity<List<Question>> getallquestion(){
            return questionService.get_allquestion();

    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.get_questionByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody  Question question){
        return questionService.addQuestion(question);
    }

    @PostMapping("addAll")
    public ResponseEntity<String> addAllQuestion(@RequestBody List< Question> question){
        return questionService.addAllQuestion(question);
    }


    @PutMapping("updatequestion/{Id}")
    public ResponseEntity<String> UpdateQuestion(@RequestBody Question question,@PathVariable Integer Id){
 
        return questionService.UpdateQuestion(question,Id);
    }
    
    @DeleteMapping("delete/{Id}")
    public ResponseEntity<String> DeleteQuestion(@PathVariable Integer Id){
        return questionService.DeleteQuestion(Id);
    }
    @DeleteMapping("deleteAll")
    public ResponseEntity<String> DeleteQuestion(@RequestBody List<Integer> Id){
        return questionService.DeleteAllQuestion(Id);
    }

}


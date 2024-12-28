package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.QuestionRepository;
import com.example.demo.Model.Question;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;


   

    public ResponseEntity<List<Question>> get_allquestion() {
       
       try{
        return new ResponseEntity<>(questionRepository.findAll(),HttpStatus.OK);
       }catch(Exception e){
        e.printStackTrace();
       }
       return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> get_questionByCategory(String category) {
      try{
      return new ResponseEntity<>(questionRepository.findByCategory(category),HttpStatus.OK);
      }catch(Exception e){
        e.printStackTrace();
      }
      return new ResponseEntity<>(new ArrayList<>(),HttpStatus.EXPECTATION_FAILED);
    }

    public ResponseEntity <String> addQuestion(Question question) { 
      try{
        questionRepository.save(question);
        return new ResponseEntity<>("Created",HttpStatus.CREATED);
      }catch(Exception e){
        e.printStackTrace();
      }
      return new ResponseEntity<>("Unnable to Created",HttpStatus.BAD_REQUEST);
        
    }

    public ResponseEntity<String> UpdateQuestion(Question question, Integer id) {
      try{
      question.setId(id);
      questionRepository.save(question);
      return new ResponseEntity<>("SuccessFully updated your Id"+id,HttpStatus.ACCEPTED);
    }catch(Exception e){
      e.printStackTrace();
    }
    return new ResponseEntity<>(" Not SuccessFully updated your Id"+id,HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> DeleteQuestion(Integer id){

      try{
      questionRepository.deleteById(id);
      return new ResponseEntity<>("Your Question was Deleted"+ id ,HttpStatus.ACCEPTED);
      }catch(Exception e){
        e.printStackTrace();
      }
      return new ResponseEntity<>("Your Question was unnable to Deleted"+ id ,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> DeleteAllQuestion(List<Integer> id) {
      try{
      for(Integer i:id){
        questionRepository.deleteById(i);
      }
      return new ResponseEntity<>("Your Question was Deleted"+ id ,HttpStatus.ACCEPTED);
      }catch(Exception e){
        e.printStackTrace();
      }
      return new ResponseEntity<>("Your Question was unnable to Deleted"+ id ,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addAllQuestion(List<Question> question) {
      try{
      questionRepository.saveAll(question);
      return new ResponseEntity<>("Created",HttpStatus.CREATED);
      }catch(Exception e){
        e.printStackTrace();
      }
      return new ResponseEntity<>("Unnable to Created",HttpStatus.BAD_REQUEST);
    }

}

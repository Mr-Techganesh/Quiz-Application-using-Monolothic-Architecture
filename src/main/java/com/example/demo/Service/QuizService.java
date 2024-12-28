package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.QuestionRepository;
import com.example.demo.DAO.QuizRepository;
import com.example.demo.Model.Question;
import com.example.demo.Model.QuestionWrapper;
import com.example.demo.Model.Quiz;
import com.example.demo.Model.Response;

@Service
public class QuizService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    QuizRepository quizRepository;

    public ResponseEntity<String> CreateQuiz(String category, int numQ, String title) {

        List<Question> questions=questionRepository.findRandomQuestionByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
     return new ResponseEntity<>("Created", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {

        Quiz quiz=quizRepository.findById(id).get();
        List<Question> questionFromDb=quiz.getQuestions();
        List<QuestionWrapper> QuestionForUser=new ArrayList<>();
       

        for(Question q:questionFromDb){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            QuestionForUser.add(qw);
        }

        return new ResponseEntity<>(QuestionForUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
       Quiz quiz=quizRepository.findById(id).get();
       List<Question> questions=quiz.getQuestions();
       int score=0;
       int i=0;
       for(Response response: responses){
            if (response.getResponse().equals(questions.get(i).getRightAnswer())){
                score++;
       }
       i++;

    }
    return new ResponseEntity<>(score,HttpStatus.OK);
}

 public ResponseEntity<String> deleteQuiz(Integer id) {
    quizRepository.deleteById(id);
    return new ResponseEntity<>("deleted",HttpStatus.OK);

}
}
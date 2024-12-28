package com.example.demo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Quiz;


public interface QuizRepository extends JpaRepository<Quiz,Integer> {

}

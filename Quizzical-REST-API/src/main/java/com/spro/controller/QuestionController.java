package com.spro.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spro.entity.Question;
import com.spro.repository.QuestionRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/")
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepo;

	@PostMapping("/questions")
	public List<Question> addListOfQuestions(@RequestBody List<Object> questions) {
		for (Object question : questions) {
			LinkedHashMap<> q = (Question)question;
			System.out.println(q);
		}
		
		return null;
	}
	
	@GetMapping("/questions")
	public List<Question> getQuestions(){
		return questionRepo.findAll();
	}
}

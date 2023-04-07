package com.spro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spro.entity.IncorrectAnswer;
import com.spro.entity.Question;
import com.spro.repository.IncorrectAnswersRepository;
import com.spro.repository.QuestionRepository;

public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private IncorrectAnswersRepository iaRepo;

	@Override
	public List<Question> saveListOfQuestions(List<Question> questions) {
		for (Question question : questions) {
			List<IncorrectAnswer> iaList = question.getIncorrectAnswers();
			iaRepo.saveAll(iaList);
		}
		
		
		return null;
	}

}

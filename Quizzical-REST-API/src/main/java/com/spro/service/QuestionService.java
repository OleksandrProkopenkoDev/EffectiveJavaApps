package com.spro.service;

import java.util.List;

import com.spro.entity.Question;

public interface QuestionService {

	List<Question> saveListOfQuestions(List<Question> questions);
	
}

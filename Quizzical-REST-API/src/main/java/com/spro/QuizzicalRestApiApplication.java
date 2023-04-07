package com.spro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spro.entity.IncorrectAnswer;
import com.spro.entity.Question;
import com.spro.repository.QuestionRepository;

@SpringBootApplication
public class QuizzicalRestApiApplication implements CommandLineRunner {

	@Autowired
	private QuestionRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(QuizzicalRestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		IncorrectAnswer ia = new IncorrectAnswer("M`ngke");
		IncorrectAnswer ia2 = new IncorrectAnswer("`gedei");
		IncorrectAnswer ia3 = new IncorrectAnswer("Tem`r");
		List<IncorrectAnswer> iaList = new ArrayList<>();
		iaList.addAll(Arrays.asList(ia,ia2,ia3));
		Question question = new Question(
				"History",
				"multiple",
				"medium",
				"What was Genghis Khan`s real name?",
				"Tem`jin",
				Arrays.asList(ia,ia2,ia3)
				);
		System.out.println(question);
		repo.save(question);
	}

}

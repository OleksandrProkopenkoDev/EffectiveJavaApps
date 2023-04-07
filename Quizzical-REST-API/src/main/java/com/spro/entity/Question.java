package com.spro.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "question_id")
	private Long id;

	private String category;
	private String type;
	private String difficulty;
	private String question;
	private String correct_answer;

	@OneToMany(
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER)
	@JoinColumn(name = "question_id")
	private List<IncorrectAnswer> incorrectAnswers;

	public Question() {
	}

	public Question(String category, String type, String difficulty, String question, String correctAnswer,
			List<IncorrectAnswer> incorrectAnswers) {
		this.category = category;
		this.type = type;
		this.difficulty = difficulty;
		this.question = question;
		this.correct_answer = correctAnswer;
		this.incorrectAnswers = incorrectAnswers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectAnswer() {
		return correct_answer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correct_answer = correctAnswer;
	}

	public List<IncorrectAnswer> getIncorrectAnswers() {
		return incorrectAnswers;
	}

	public void setIncorrectAnswers(List<IncorrectAnswer> incorrectAnswers) {
		this.incorrectAnswers = incorrectAnswers;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", category=" + category + ", type=" + type + ", difficulty=" + difficulty
				+ ", question=" + question + ", correct_answer=" + correct_answer + ", incorrectAnswers="
				+ incorrectAnswers + "]";
	}

}

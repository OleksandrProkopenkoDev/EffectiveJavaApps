package com.spro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "incorrect_answers")
public class IncorrectAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ia_id")
	private Long id;
	
	@Column
	private String text;
	
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	public IncorrectAnswer() {}
	
	
	
	public IncorrectAnswer(String text) {
		this.text = text;
	}

	public IncorrectAnswer(String text, Question question) {
		this.question = question;
		this.text = text;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "[text=" + text + "]";
	}
	
	
}

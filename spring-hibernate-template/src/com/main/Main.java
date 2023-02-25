package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.TraineeDAO;
import com.to.Trainee;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("beans.xml");
		TraineeDAO dao = ap.getBean("dao", TraineeDAO.class);
		Trainee t = new Trainee("Rik", 18, 1346575);
		System.out.println(dao.addTrainee(t));
		System.out.println("all the trainees are:");
		System.out.println(dao.getAllTrainees());
	}

}

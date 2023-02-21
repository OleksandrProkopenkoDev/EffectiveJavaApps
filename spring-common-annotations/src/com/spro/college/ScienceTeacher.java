package com.spro.college;

import org.springframework.stereotype.Component;

@Component
public class ScienceTeacher implements Teacher {

	@Override
	public void teach() {
		System.out.println("I am your science teacher");
	}

}

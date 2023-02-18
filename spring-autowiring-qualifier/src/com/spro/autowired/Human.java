package com.spro.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Human {
	
	@Autowired
	@Qualifier("humanHeart")
	private Heart heart;
	
	public Human() {}
	

	public Human(Heart heart) {
		this.heart = heart;
		System.out.println("used human constructot with heart arg");
	}
	

	public void setHeart(Heart heart) {
		this.heart = heart;
		System.out.println("used heart setter");
	}	
	
	public void startPumping() {
		if (heart != null)
		heart.pump();
		else System.out.println("human has no heart!");
	}
}

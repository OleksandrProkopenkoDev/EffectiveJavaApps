package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole {

	@Override
	public void up() {
		System.out.println("Mario jumps");
	}
	
	@Override
	public void down() {
		System.out.println("Mario goes into a hole");
	}
	@Override
	public void left() {
		System.out.println("Mario stops");
	}
	@Override
	public void right() {
		System.out.println("Mario goes faster");
	}
}

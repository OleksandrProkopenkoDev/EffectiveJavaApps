package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacmanGame implements GamingConsole{

	@Override
	public void up() {
		System.out.println("Pacman up");
	}
	
	@Override
	public void down() {
		System.out.println("Pacman down");
	}
	
	@Override
	public void left() {
		System.out.println("Pacman left");
	}
	
	@Override
	public void right() {
		System.out.println("Pacman right");
	}
}

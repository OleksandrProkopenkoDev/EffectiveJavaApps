package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	
	@Autowired
	private GamingConsole game;
	


	
	public GameRunner(GamingConsole game) {
		System.out.println("in GameRunner constructor");
		this.game = game;
	}
	
	public void run() {
		System.out.println("game running...");
		game.up();
		game.left();
		game.right();
		game.down();
	}
}

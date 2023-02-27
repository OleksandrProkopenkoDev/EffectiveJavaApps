package com.in28minutes.learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(SpringBootDemoApplication.class, args);
		GameRunner runner = context.getBean(GameRunner.class);
		
//		MarioGame game = new MarioGame(); 
//		SuperContraGame game = new SuperContraGame();
//		GameRunner runner = new GameRunner(game);
		runner.run();
		
	}

}

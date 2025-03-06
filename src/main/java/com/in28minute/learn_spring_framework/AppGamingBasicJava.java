package com.in28minute.learn_spring_framework;

import com.in28minute.learn_spring_framework.game.GameRunner;
import com.in28minute.learn_spring_framework.game.MarioGame;
import com.in28minute.learn_spring_framework.game.SuperContraGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		
		/* 1. 
		 * 
		 * var marioGame = new MarioGame();
		 * 
		 * var gameRunner = new GameRunner(marioGame); 
		 * gameRunner.run();
		 */
		
		
		var superContraGame = new SuperContraGame();
		
		var gameRunner = new GameRunner(superContraGame);
		gameRunner.run();

	}

}

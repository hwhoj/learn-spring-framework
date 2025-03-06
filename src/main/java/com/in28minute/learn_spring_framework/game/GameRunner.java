package com.in28minute.learn_spring_framework.game;

public class GameRunner {
	
	/* 1. 게임 러너는 마리오 게임과 강하게 결합되어있다. 다른게임을 하려면 게임을 바꿔줘야됨
	 * 결합이란 무언가를 변경하는 데 얼마나 많은 작업이 관련되어 있는지에 대한 측정이다.
	 * 
	 * private MarioGame game;
	 * 
	 * public GameRunner(MarioGame game) { this.game = game; }
	 */
	
	
	private SuperContraGame game;
	
	public GameRunner(SuperContraGame game) {
		this.game = game;
	}

	public void run() {
		System.out.println("Running game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
}

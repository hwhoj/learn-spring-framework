package com.in28minute.learn_spring_framework;

import com.in28minute.learn_spring_framework.game.GameRunner;
import com.in28minute.learn_spring_framework.game.MarioGame;
import com.in28minute.learn_spring_framework.game.PackmanGame;
import com.in28minute.learn_spring_framework.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		
		/* 1. 
		 * 
		 * var marioGame = new MarioGame();
		 * 
		 * var gameRunner = new GameRunner(marioGame); 
		 * gameRunner.run();
		 */
		
		
		/* 2.
		 * 
		 * var superContraGame = new SuperContraGame();
		 * 
		 * var gameRunner = new GameRunner(superContraGame); gameRunner.run();
		 */
		
		//각 게임들의 기능을 구현한 인터페이스로 만들 하나 만들어준다.
		//각 게임들이 인터페이스를 implements한다면 앱게이밍베이식 클래스에서 일일히 게임을 바꿔줄 필요가없다
		//implements 키워드는 자바에서 인터페이스(interface)를 구현(implement)할 때 사용됩니다. 
		//즉, 클래스가 특정 인터페이스를 구현하여 해당 인터페이스에 정의된 메서드를 반드시 오버라이딩(재정의)하도록 강제하는 역할을 합니다.
		
		//var game = new MarioGame();
		
		//var game = new SuperContraGame();
		
		//처리 흐름
		
		var game = new PackmanGame(); // 1. 객체 생성
		
		var gameRunner = new GameRunner(game); // 2. 객체 생성 + 의존성 연결
		// GameRunner클래스는 게임을 실행할수 있어야 한다, 실행하려면 게임이있어야한다. 그러므로 게임이 곧 의존성이라고 할 수 있다.
		// 게임을 통합해놓은 GamingConsole 인터페이스가 GameRunner클래스의 의존성이다
		
		gameRunner.run();
	}

}

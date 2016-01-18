package com.comteen;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTU {
	
	private GameImpl game = null;
	
	/*
	 * 
	 */
	@Test
	public void testHandleGame() {
		assertEquals(0l, 0l);
	}
	
	@Test
	public void testSetBoard() {
		game = new GameImpl();
		String states = "BBBBBBBBBWWWWWWWWW";
		game.setBoard(states);
		/*for(int i = 0; i < 5 ;i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(game.getBoard()[i][j]);
			}
			System.out.print("\n");
		}*/
		game.setPosition(24);
		System.out.println(game.getxPoint());
		System.out.println(game.getyPoint());
		game.move(9);
	}

}

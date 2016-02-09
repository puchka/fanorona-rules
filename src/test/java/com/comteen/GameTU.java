package com.comteen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comteen.common.Direction;
import com.comteen.common.Parameter;
import com.comteen.common.Result;

public class GameTU {

	private GameImpl game = null;

	private String states;

	@Before
	public void setUp() throws Exception {
		game = new GameImpl();
		states = "BBBBBBBBB" + "BBBBBBBBB" + "BWBWEBWBW" + "WWWWWWWWW" + "WWWWWWWWW";
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * Simulate the game
	 */
	@Test
	public void handleGameTU() throws Exception {

		// Test param one
/*		Parameter param = new Parameter();
		
		param.setDirection(Direction.TOP_RIGHT);
		param.setSourceStatePosition(31);
	    Result<String> res = game.handleGame(states, param);
	    
	    setUp();*/

		// Test param two
		Parameter param = new Parameter();
		param.setDirection(-1);
		param.setSourceStatePosition(31);
		param.setDestStatePosition(23);
		Result<String> res = game.handleGame(states, param);
		
		
		// Test param 3
		param = new Parameter();
		param.setSourceStatePosition(23);
		param.setDestStatePosition(31);
		states = res.getData();
		res = game.handleGame(states, param);
		
		// Test param 4
		param = new Parameter();
		param.setSourceStatePosition(21);
		param.setDestStatePosition(31);
		states = res.getData();
		res = game.handleGame(states, param);
		
		// Test param 5
		param = new Parameter();
		param.setSourceStatePosition(30);
		param.setDestStatePosition(21);
		states = res.getData();
		res = game.handleGame(states, param);
		
		// Test param 6
		param = new Parameter();
		param.setSourceStatePosition(31);
		param.setDestStatePosition(30);
		states = res.getData();
		res = game.handleGame(states, param);
		
		// Test param 7
		param = new Parameter();
		param.setSourceStatePosition(2);
		param.setDestStatePosition(12);
		states = res.getData();
		res = game.handleGame(states, param);
		
		printBoard(res);

	}

	@Test
	public void setBoardTU() {
		game.setBoard(states);
		assertEquals(1, game.getBoard()[0][0]);
		assertEquals(2, game.getBoard()[4][8]);
	}

	@Test
	public void getStringBoardTU() {
		game.setBoard(states);
		String states = game.getStringBoard();
		assertEquals("BBBBBBBBBBBBBBBBBBBWBWEBWBWWWWWWWWWWWWWWWWWWW", states);
	}

	@Test
	public void setCurrentPositionTU() {
		game.transformIndexTo2DPosition(1, 1);
		int x = game.getCurrentPosition().getX();
		int y = game.getCurrentPosition().getY();
		assertEquals(0, x);
		assertEquals(0, y);

		game.transformIndexTo2DPosition(2, 1);
		x = game.getCurrentPosition().getX();
		y = game.getCurrentPosition().getY();
		assertEquals(0, x);
		assertEquals(1, y);
	}

	private void printBoard(Result<String> res) {
		System.out.println(res.getData().substring(0, 9));
		System.out.println(res.getData().substring(9, 18));
		System.out.println(res.getData().substring(18, 27));
		System.out.println(res.getData().substring(27, 36));
		System.out.println(res.getData().substring(36, 45));
	}

}

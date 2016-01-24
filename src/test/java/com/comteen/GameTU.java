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
	 * 
	 */
	@Test
	public void handleGameTU() {
		Parameter param = new Parameter();
		param.setDirection(Direction.TOP_RIGHT);
		param.setPosition(31);
		Result<String> res = game.handleGame(states, param);
/*		System.out.println(res.getData().substring(0, 9));
		System.out.println(res.getData().substring(9, 18));
		System.out.println(res.getData().substring(18, 27));
		System.out.println(res.getData().substring(27, 36));
		System.out.println(res.getData().substring(36, 45));*/
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
		game.setCurrentPosition(1);
		int x = game.getCurrentPosition().getX();
		int y = game.getCurrentPosition().getY();
		assertEquals(0, x);
		assertEquals(0, y);
	}

}

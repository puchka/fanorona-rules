package com.comteen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTU {
	
	private GameImpl game = null;
	
	@Before
	public void setUp() throws Exception {
		game = new GameImpl();
	}

	@After
	public void tearDown() throws Exception {
	}
	
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
	}

}

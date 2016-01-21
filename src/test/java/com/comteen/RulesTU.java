package com.comteen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RulesTU {
	
	private RulesImpl rules = null;
	
	private int[][] board = {
			{0,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1},
			{1,2,1,1,0,1,2,1,2},
			{2,2,2,2,2,2,2,2,2},
			{2,2,2,2,2,2,2,2,2}
	};

	@Before
	public void setUp() throws Exception {
		rules = RulesImpl.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void checkIfNextPositionValidTU() {
		assertFalse(rules.checkIfNextPositionValid(board, 0, 2));
		assertTrue(rules.checkIfNextPositionValid(board, 0, 0));
		assertFalse(rules.checkIfNextPositionValid(board, -1, 2));
		assertFalse(rules.checkIfNextPositionValid(board, 0, 9));
		assertFalse(rules.checkIfNextPositionValid(board, -1, 9));
	}

}

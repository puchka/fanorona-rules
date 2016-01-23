package com.comteen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comteen.common.Direction;
import com.comteen.common.Position;
import com.comteen.rule.RulesImpl;

public class RulesTU {
	
	private RulesImpl rules = null;
	
	private int[][] board = {
			{0,1,1,1,2,1,1,1,1},
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
		assertFalse(rules.checkIfNextPositionValid(board, new Position(0, 2)));
		assertTrue(rules.checkIfNextPositionValid(board, new Position(0, 0)));
		assertFalse(rules.checkIfNextPositionValid(board, new Position(-1, 2)));
		assertFalse(rules.checkIfNextPositionValid(board, new Position(0, 9)));
		assertFalse(rules.checkIfNextPositionValid(board, new Position(-1, 9)));
	}
	
	@Test
	public void eliminateAdversaryTU() {
		//After move
		Position nextPosition = new Position(3,1);
		rules.eliminateAdversary(board, Direction.TOP_RIGHT, nextPosition);
		assertEquals(0, board[2][2]);
		assertEquals(0, board[1][3]);
		assertEquals(2, board[0][4]);
	}

}

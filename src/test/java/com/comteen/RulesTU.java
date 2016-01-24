package com.comteen;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comteen.common.Direction;
import com.comteen.common.Parameter;
import com.comteen.common.Player;
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
		
		Parameter param = new Parameter();
		Player player = new Player(1);
		player.setLastPosition(new Position(0,3));
		param.setCurrentPlayer(player);
		param.setNextPosition(new Position(0, 3));
		assertFalse(rules.checkIfNextPositionValid(board, param));
		
		param.setNextPosition(new Position(0, 2));
		assertFalse(rules.checkIfNextPositionValid(board, param));
		
		param.setNextPosition(new Position(0, 0));
		assertTrue(rules.checkIfNextPositionValid(board, param));
		
		param.setNextPosition(new Position(-1, 2));
		assertFalse(rules.checkIfNextPositionValid(board, param));
		
		param.setNextPosition(new Position(0, 9));
		assertFalse(rules.checkIfNextPositionValid(board, param));
		
		param.setNextPosition(new Position(-1, 9));
		assertFalse(rules.checkIfNextPositionValid(board, param));
	}
	
	@Test
	public void eliminateAdversaryTU() {
		//After move
		Position nextPosition = new Position(3,1);
		
		Parameter param = new Parameter();
		param.setDirection(Direction.TOP_RIGHT);
		param.setNextPosition(nextPosition);

		rules.eliminateAdversary(board, param);
		assertEquals(0, board[2][2]);
		assertEquals(0, board[1][3]);
		assertEquals(2, board[0][4]);
	}

}

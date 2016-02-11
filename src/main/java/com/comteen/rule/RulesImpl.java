package com.comteen.rule;

import com.comteen.common.Move;
import com.comteen.common.Parameter;
import com.comteen.common.Player;
import com.comteen.common.Position;

/**
 * Implementation of the rules Singleton
 * 
 * @author rama
 *
 */
public class RulesImpl extends Move implements Rules {

	private static RulesImpl rulesImpl = null;

	private RulesImpl() {
	}

	public static synchronized RulesImpl getInstance() {
		if (rulesImpl == null) {
			rulesImpl = new RulesImpl();
		}
		return rulesImpl;
	}

	/**
	 * Check if the next position is valid Next stone empty, axis (x, y) is not
	 * out of range
	 */
	public boolean checkIfNextPositionValid(int[][] board, Parameter param) {
		Position next = param.getNextPosition();
		Player player = param.getCurrentPlayer();
		int x = next.getX();
		int y = next.getY();
		boolean isValid = false;
		if ((x >= 0 && x <= 4) && (y >= 0 && y <= 8) && board[x][y] == 0) {
			if (!player.isEqualToLastPosition(next)) {
				isValid = true;
			}
		}
		return isValid;
	}

	/**
	 * Processing move, change and return boolean value Consider the two moves,
	 * either percussion or
	 * 
	 */
	public boolean processChange(int[][] board, Parameter param) {
		boolean res = false;
		int oldX = param.getCurrentPosition().getX();
		int oldY = param.getCurrentPosition().getY();
		int x = param.getNextPosition().getX();
		int y = param.getNextPosition().getY();
		if (checkIfNextPositionValid(board, param)) {
			board[x][y] = board[oldX][oldY];
			board[oldX][oldY] = 0;
			eliminateAdversary(board, param);
			// Set last new position valid for current player
			param.getCurrentPlayer().setLastPosition(param.getCurrentPosition());
			res = true;
		}
		return res;
	}

	/**
	 * The elimination is based on direction of the stone and we replace the
	 * opposite stone by 0 i.e empty
	 */
	public void eliminateAdversary(int[][] board, Parameter param) {
		setTypeMove(param.getTypeMove());
		int x = param.getNextPosition().getX(), y = param.getNextPosition().getY();
		int player = board[x][y];// Get player Id
		
		// Init the starting position
		initMoveHandler(param);
		int direction = param.getDirection();
		Position position = getNext(direction, param.getStartProcessPosition());
		
		while (isMoveValid(direction, position)) {
			int item = board[position.getX()][position.getY()];
			if (item == player) {
				break;
			} else if (item != 0) {
				// Eliminate adversary
				board[position.getX()][position.getY()] = 0;
			}
			position = getNext(direction, position);
		}
	}

}

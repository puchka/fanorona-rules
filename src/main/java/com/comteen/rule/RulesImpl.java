package com.comteen.rule;

import com.comteen.common.Direction;
import com.comteen.common.Position;

/**
 * Implementation of the rules Singleton
 * 
 * @author rama
 *
 */
public class RulesImpl implements Rules {

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
	 * Check if the position cible is valid Next stone empty, axis (x, y) is not
	 * out of range
	 */
	public boolean checkIfNextPositionValid(int[][] board, Position next) {
		int x = next.getX();
		int y = next.getY();
		boolean isValid = false;
		if ((x >= 0 && x <= 4) && (y >= 0 && y <= 8) && board[x][y] == 0) {
			isValid = true;
		}
		return isValid;
	}

	/**
	 * Processing move, change and return boolean value Consider the two moves,
	 * either percussion or
	 * 
	 */
	public boolean processChange(int[][] board, Position current, Position next) {
		boolean res = false;
		int oldX = current.getX();
		int oldY = current.getY();
		int x = next.getX();
		int y = next.getY();
		if (checkIfNextPositionValid(board, next)) {
			board[x][y] = board[oldX][oldY];
			board[oldX][oldY] = 0;
			eliminateAdversary(board, 0, next);
			res = true;
		}
		return res;
	}

	/**
	 * The elimination is based on direction of the stone and we replace the
	 * stone opposite by 0 i.e empty
	 */
	public void eliminateAdversary(int[][] board, int direction, Position nextPosition) {
		int x = nextPosition.getX(), y = nextPosition.getY();
		int player = board[x][y];
		if (direction == Direction.TOP_RIGHT || direction == Direction.BOTTOM_LEFT) {
			x = x - 1;
			y = y + 1;
			while (x >= 0 && y <= 8) {
				if (board[x][y] == player) {
					break;
				} else if (board[x][y] == 0) {
					continue;
				} else {
					// Eliminate adversary
					board[x][y] = 0;
				}
				x = x - 1;
				y = y + 1;
			}
		}
	}

}

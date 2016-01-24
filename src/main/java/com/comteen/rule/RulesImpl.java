package com.comteen.rule;

import com.comteen.common.Direction;
import com.comteen.common.Parameter;
import com.comteen.common.Player;
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
			res = true;
		}
		return res;
	}

	/**
	 * The elimination is based on direction of the stone and we replace the
	 * stone opposite by 0 i.e empty
	 */
	public void eliminateAdversary(int[][] board, Parameter param) {
		int x = param.getNextPosition().getX(), y = param.getNextPosition().getY();
		int player = board[x][y];// Get player Id
		int direction = param.getDirection();
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

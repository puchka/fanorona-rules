package com.comteen;

/**
 * Implementation of the rules Singleton
 * 
 * @author rama
 *
 */
public class RulesImpl implements Rules {

	private Position currentPosition, nextPosition;

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
	public boolean checkIfNextPositionValid(int[][] board, int x, int y) {
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
	public boolean processChange(int[][] board, int oldX, int oldY, int x, int y) {
		boolean res = false;
		if (checkIfNextPositionValid(board, x, y)) {
			board[x][y] = board[oldX][oldY];
			board[oldX][oldY] = 0;
			eliminateAdversary(board, 0);
			res = true;
		}
		return res;
	}

	/**
	 * The elimination is based on direction of the stone and we replace the
	 * stone opposite by 0 i.e empty
	 */
	public void eliminateAdversary(int[][] board, int direction) {
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

	/**
	 * This method allows to find xPoint and yPoint
	 * 
	 * @param index
	 */
	public void setPosition(int index) {
		currentPosition.setY((index % 9) - 1);
		if (index <= 9) {
			currentPosition.setX(0);
		} else if (index <= 18) {
			currentPosition.setX(1);
		} else if (index <= 27) {
			currentPosition.setX(2);
		} else if (index <= 36) {
			currentPosition.setX(3);
		} else if (index <= 45) {
			currentPosition.setX(4);
		}
	}

	/**
	 * Set the new position by using the direction
	 * 
	 * @param direction
	 */
	public void move(int direction) {
		int yNextPoint = 0, xNextPoint = 0;
		int yPoint = currentPosition.getY();
		int xPoint = currentPosition.getX();
		switch (direction) {
		case Direction.TOP_LEFT:
			yNextPoint = yPoint - 1;
			xNextPoint = xPoint - 1;
			break;
		case Direction.TOP_MIDDLE:
			yNextPoint = yPoint;
			xNextPoint = xPoint - 1;
			break;
		case Direction.TOP_RIGHT:
			yNextPoint = yPoint + 1;
			xNextPoint = xPoint - 1;
			break;
		case Direction.MIDDLE_LEFT:
			yNextPoint = yPoint - 1;
			xNextPoint = xPoint;
			break;
		case Direction.MIDDLE_RIGHT:
			yNextPoint = yPoint + 1;
			xNextPoint = xPoint;
			break;
		case Direction.BOTTOM_LEFT:
			yNextPoint = yPoint - 1;
			xNextPoint = xPoint + 1;
			break;
		case Direction.BOTTOM_MIDDLE:
			yNextPoint = yPoint;
			xNextPoint = xPoint + 1;
			break;
		case Direction.BOTTOM_RIGHT:
			yNextPoint = yPoint + 1;
			xNextPoint = xPoint + 1;
			break;
		}
		nextPosition.setX(xNextPoint);
		nextPosition.setY(yNextPoint);
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Position getNextPosition() {
		return nextPosition;
	}

	public void setNextPosition(Position nextPosition) {
		this.nextPosition = nextPosition;
	}

}

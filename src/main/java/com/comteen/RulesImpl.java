package com.comteen;

/**
 * Implementation of the rules Singleton
 * 
 * @author rama
 *
 */
public class RulesImpl implements Rules {

	private int xPoint, yPoint;

	private int xNextPoint, yNextPoint;

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
	 * Check if the position cible is valid
	 */
	public boolean checkIfNextPositionValid(int[][] board, int x, int y) {
		return (board[x][y] == 0);
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
			res = true;
		}
		return res;
	}

	/**
	 * 
	 */
	public void eliminateAdversary(int[][] board, int direction) {
		
	}

	/**
	 * This method allows to find xPoint and yPoint
	 * 
	 * @param index
	 */
	public void setPosition(int index) {
		this.yPoint = (index % 9) - 1;
		if (index <= 9) {
			xPoint = 0;
		} else if (index <= 18) {
			xPoint = 1;
		} else if (index <= 27) {
			xPoint = 2;
		} else if (index <= 36) {
			xPoint = 3;
		} else if (index <= 45) {
			xPoint = 4;
		}
	}

	/**
	 * Set the new position by using the direction
	 * 
	 * @param direction
	 */
	public void move(int direction) {
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
		case Direction.BOTOM_LEFT:
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
		System.out.println("yNext : " + yNextPoint + " , xNext : " + xNextPoint);
	}

	public int getxPoint() {
		return xPoint;
	}

	public void setxPoint(int xPoint) {
		this.xPoint = xPoint;
	}

	public int getyPoint() {
		return yPoint;
	}

	public void setyPoint(int yPoint) {
		this.yPoint = yPoint;
	}

	public int getxNextPoint() {
		return xNextPoint;
	}

	public void setxNextPoint(int xNextPoint) {
		this.xNextPoint = xNextPoint;
	}

	public int getyNextPoint() {
		return yNextPoint;
	}

	public void setyNextPoint(int yNextPoint) {
		this.yNextPoint = yNextPoint;
	}

}

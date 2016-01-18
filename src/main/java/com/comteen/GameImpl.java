/**
 * 
 */
package com.comteen;

/**
 * @author rama
 *
 */
public class GameImpl implements Game {

	private int[][] board = new int[5][9];

	private int xPoint, yPoint, direction;

	private int xNextPoint, yNextPoint;

	/**
	 * Handle request for processing
	 */
	public void handleGame(String states, int position, int direction) {

	}

	/**
	 * B = black pion W = white pion
	 * 
	 * @param states
	 */
	public void setBoard(String states) {
		int row = 0;
		int column = 0;
		if (states != null && !states.isEmpty()) {
			for (int i = 0; i < states.length(); i++) {
				char c = states.charAt(i);
				int value = 0;
				switch (c) {
				case 'B':
					value = 1;
					break;
				case 'W':
					value = 2;
					break;
				case 'E':
					value = 0;
					break;
				default:
				}
				board[row][column] = value;
				if ((++column % 9) == 0) {
					column = 0;
					row++;
				}
			}
		}
	}

	/**
	 * This method allow to find xPoint and yPoint
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

	public void move(int direction) {
		switch (direction) {
		case 1:
			yNextPoint = yPoint - 1;
			xNextPoint = xPoint - 1;
			break;
		case 2:
			yNextPoint = yPoint;
			xNextPoint = xPoint - 1;
			break;
		case 3:
			yNextPoint = yPoint + 1;
			xNextPoint = xPoint - 1;
			break;
		case 4:
			yNextPoint = yPoint - 1;
			xNextPoint = xPoint;
			break;
		case 5:
			yNextPoint = yPoint + 1;
			xNextPoint = xPoint;
			break;
		case 6:
			yNextPoint = yPoint - 1;
			xNextPoint = xPoint + 1;
			break;
		case 7:
			yNextPoint = yPoint;
			xNextPoint = xPoint + 1;
			break;
		case 8:
			yNextPoint = yPoint + 1;
			xNextPoint = xPoint + 1;
			break;
		}
		System.out.println("yNext : " + yNextPoint + " , xNext : " + xNextPoint);
	}

	private String getStringBoard() {
		StringBuilder str = new StringBuilder("");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					str.append("E");
				} else if (board[i][j] == 1) {
					str.append("B");
				} else if (board[i][j] == 2) {
					str.append("W");
				}
			}
		}
		return str.toString();
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
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

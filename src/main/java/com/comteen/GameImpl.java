/**
 * 
 */
package com.comteen;

import com.comteen.common.Direction;
import com.comteen.common.Position;
import com.comteen.exception.FanoronaException;

/**
 * @author rama Singleton
 */
public class GameImpl implements Game {

	private int[][] board = new int[5][9];

	private Position currentPosition, nextPosition;

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

	/**
	 * This method allows to find xPoint and yPoint
	 * 
	 * @param index
	 */
	public void setCurrentPosition(int index) {
		currentPosition = new Position();
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
		if (currentPosition != null) {
			currentPosition = new Position();
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
		} else {
			throw new FanoronaException("Invalid move. Current Position undefined");
		}
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
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

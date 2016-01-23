/**
 * 
 */
package com.comteen;

import com.comteen.common.Direction;
import com.comteen.common.Player;
import com.comteen.common.Position;
import com.comteen.common.Result;
import com.comteen.common.Stone;
import com.comteen.exception.FanoronaException;
import com.comteen.rule.Rules;
import com.comteen.rule.RulesImpl;

/**
 * @author rama Singleton
 */
public class GameImpl implements Game {

	private int[][] board = new int[5][9];

	private Position currentPosition, nextPosition;

	private static Player[] player = new Player[2];

	private static Rules rules = RulesImpl.getInstance();

	private static GameImpl gameImpl = null;

	private GameImpl() {
	}

	public static synchronized GameImpl getInstance() {
		if (gameImpl == null) {
			gameImpl = new GameImpl();
			// Initialization player
			player[0] = new Player(1);
			player[1] = new Player(2);
		}
		return gameImpl;
	}

	/**
	 * Handle request for processing
	 */
	public Result<String> handleGame(String states, int position, int direction) {
		Result<String> res = new Result<String>();
		// Validate parameters
		if (states != null && !states.isEmpty()) {
			// Refresh model board
			setBoard(states);
			setCurrentPosition(position);
			nextMove(direction);

			// Processing
			rules.processChange(board, currentPosition, nextPosition, getCurrentPlayer(), direction);

			// Format result
			res.setResult(true);
			res.setData(getStringBoard());
		} else {
			res.setMessage("States null or empty");
		}
		return res;
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
				case Stone.BLACK:
					value = player[0].getId();
					break;
				case Stone.WHITE:
					value = player[1].getId();
					break;
				case Stone.NONE:
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
	 * Convert board matrix model to string message
	 * 
	 * @return
	 */
	public String getStringBoard() {
		StringBuilder str = new StringBuilder("");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					str.append("E");
				} else if (board[i][j] == player[0].getId()) {
					str.append("B");
				} else if (board[i][j] == player[1].getId()) {
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
	 * Set the new position by using the direction Get next Position of the
	 * Stone
	 * 
	 * @param direction
	 */
	public void nextMove(int direction) {
		if (currentPosition != null) {
			nextPosition = new Position();
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

	private Player getCurrentPlayer() {
		Player p = null;
		if (currentPosition != null) {
			int index = board[currentPosition.getX()][currentPosition.getY()] - 1;
			p = player[index];
		}
		return p;
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

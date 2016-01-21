/**
 * 
 */
package com.comteen;

/**
 * @author rama Singleton
 */
public class GameImpl implements Game {

	private int[][] board = new int[5][9];

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

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

}

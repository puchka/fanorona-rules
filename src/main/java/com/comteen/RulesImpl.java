package com.comteen;

public class RulesImpl implements Rules {

	/**
	 * Check if the position cible is valid
	 */
	public boolean checkIfNextPositionValid(int [][] board, int x, int y) {
		return (board[x][y] == 0);
	}
	
	/**
	 * Processing move, change and return boolean value
	 * 
	 */
	public boolean processChange(int[][] board,
                                 int oldX,
                                 int oldY,
								 int x, 
								 int y) {
		boolean res = true;
		if(checkIfNextPositionValid(board, x, y)) {
			board[x][y] = board[oldX][oldY];
			board[oldX][oldY] = 0;
		}
		return res;
	}
	
	/**
	 * 
	 */
	public void eliminateAdversary() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}

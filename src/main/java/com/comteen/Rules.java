package com.comteen;

public interface Rules {

	boolean checkIfNextPositionValid(int[][] board, int x, int y);

	boolean processChange(int[][] board, int oldX, int oldY, int x, int y);

	void eliminateAdversary();

}

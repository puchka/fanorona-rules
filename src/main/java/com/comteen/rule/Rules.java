package com.comteen.rule;

import com.comteen.common.Position;

public interface Rules {

	boolean checkIfNextPositionValid(int[][] board, int x, int y);

	boolean processChange(int[][] board, Position current, Position next);

	void eliminateAdversary(int[][] board, int direction, Position nextPosition);

}

package com.comteen.rule;

import com.comteen.common.Player;
import com.comteen.common.Position;

public interface Rules {

	boolean checkIfNextPositionValid(int[][] board, Position next, Player player);

	boolean processChange(int[][] board, Position current, Position next, Player player, int direction);

	void eliminateAdversary(int[][] board, int direction, Position nextPosition);

}

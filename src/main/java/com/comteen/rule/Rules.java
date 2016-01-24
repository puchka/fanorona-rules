package com.comteen.rule;

import com.comteen.common.Parameter;

public interface Rules {

	boolean checkIfNextPositionValid(int[][] board, Parameter param);

	boolean processChange(int[][] board, Parameter param);

	void eliminateAdversary(int[][] board, Parameter param);

}

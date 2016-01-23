package com.comteen;

import com.comteen.common.Result;

/**
 * 
 * @author ramampiandra
 *
 */
public interface Game {
	
	Result<String> handleGame(String states, int position, int direction);
	
	default void handleIAGame(String states) {
		//TODO MinMax Implementation
	}
}

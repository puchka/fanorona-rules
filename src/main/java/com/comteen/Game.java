package com.comteen;

/**
 * 
 * @author ramampiandra
 *
 */
public interface Game {
	
	void handleGame(String states, int position, int direction);
	
	default void handleIAGame(String states) {
		//TODO MinMax Implementation
	}
}

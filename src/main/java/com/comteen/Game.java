package com.comteen;

import com.comteen.common.Parameter;
import com.comteen.common.Result;

/**
 * 
 * @author ramampiandra
 *
 */
public interface Game {
	
	Result<String> handleGame(String states, Parameter param);
	
	default void handleIAGame(String states) {
		//TODO MinMax Implementation
	}
}

package com.comteen;

import com.comteen.common.Parameter;
import com.comteen.common.Result;
import com.comteen.exception.FanoronaException;

/**
 * 
 * @author ramampiandra
 *
 */
public interface Game {

	Result<String> handleGame(String states, Parameter param) throws FanoronaException;

	/*
	 * default void handleIAGame(String states) { //TODO MinMax Implementation }
	 */
}

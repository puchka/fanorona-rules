package com.comteen.common;

public class Parameter {

	// Direction of the Stone
	private int direction = -1;

	// Source position in the string state
	private int position;

	// Type move
	private int typeMove;

	// Current player
	private Player currentPlayer;

	// Current Position (Class)
	private Position currentPosition;

	// Next Position (Class)
	private Position nextPosition;

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getTypeMove() {
		return typeMove;
	}

	public void setTypeMove(int typeMove) {
		this.typeMove = typeMove;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	public Position getNextPosition() {
		return nextPosition;
	}

	public void setNextPosition(Position nextPosition) {
		this.nextPosition = nextPosition;
	}

}

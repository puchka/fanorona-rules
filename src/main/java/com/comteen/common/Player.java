package com.comteen.common;

public class Player {

	private int id;

	private Position lastPosition;

	public Player() {
	}

	public Player(int id) {
		this.id = id;
		this.lastPosition = new Position();
	}
	
	public boolean isEqualToLastPosition(Position current) {
		boolean isEqual = false;
		if(lastPosition.getX() == current.getX() && lastPosition.getY() == current.getY()) {
			isEqual = true;
			lastPosition = new Position(current.getX(), current.getY());
		}
		return isEqual;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Position getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(Position lastPosition) {
		this.lastPosition = lastPosition;
	}

}

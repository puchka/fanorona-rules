package com.comteen.common;

public abstract class Move {
	
	public static enum Type { ADVANCE, WITHDRAW, PAIKA, SACRIFICE }

	/**5
	 * Get the next Position
	 * 
	 * @param direction
	 * @param p
	 * @return
	 */
	protected Position getNext(int direction, Position p) {
		int yPoint = p.getY();
		int xPoint = p.getX();
		int yNextPoint = 0;
		int xNextPoint = 0;
		switch (direction) {
		case Direction.TOP_LEFT:
			yNextPoint = yPoint - 1;
			xNextPoint = xPoint - 1;
			break;
		case Direction.TOP_MIDDLE:
			yNextPoint = yPoint;
			xNextPoint = xPoint - 1;
			break;
		case Direction.TOP_RIGHT:
			yNextPoint = yPoint + 1;
			xNextPoint = xPoint - 1;
			break;
		case Direction.MIDDLE_LEFT:
			yNextPoint = yPoint - 1;
			xNextPoint = xPoint;
			break;
		case Direction.MIDDLE_RIGHT:
			yNextPoint = yPoint + 1;
			xNextPoint = xPoint;
			break;
		case Direction.BOTTOM_LEFT:
			yNextPoint = yPoint - 1;
			xNextPoint = xPoint + 1;
			break;
		case Direction.BOTTOM_MIDDLE:
			yNextPoint = yPoint;
			xNextPoint = xPoint + 1;
			break;
		case Direction.BOTTOM_RIGHT:
			yNextPoint = yPoint + 1;
			xNextPoint = xPoint + 1;
			break;
		}
		return new Position(xNextPoint, yNextPoint);
	}
	
	/**
	 * Get the next Position
	 * 
	 * @param direction
	 * @param p
	 * @return
	 */
	protected boolean isMoveValid(int direction, Position p) {
		int yPoint = p.getY();
		int xPoint = p.getX();
		boolean result = false;
		switch (direction) {
		case Direction.TOP_LEFT:
			result = (xPoint >= 0 && yPoint >= 0);
			break;
		case Direction.TOP_MIDDLE:
			result = xPoint >= 0;
			break;
		case Direction.TOP_RIGHT:
			result = (xPoint >= 0 && yPoint <= 8);
			break;
		case Direction.MIDDLE_LEFT:
			result = yPoint >= 0;
			break;
		case Direction.MIDDLE_RIGHT:
			result = yPoint <= 8;
			break;
		case Direction.BOTTOM_LEFT:
			result = (xPoint <= 4 && yPoint >= 0);
			break;
		case Direction.BOTTOM_MIDDLE:
			result = xPoint <= 4;
			break;
		case Direction.BOTTOM_RIGHT:
			result = (xPoint <= 4 && yPoint <= 8);
			break;
		}
		return result;
	}

}

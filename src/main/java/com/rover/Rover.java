package com.rover;

import com.grid.Grid;

public class Rover {

	private static final Direction START_DIRECTION = Direction.NORTH;
	private static final int STARTING_Y = 0;
	private static final int STARTING_X = 0;

	private int xPosition = STARTING_X;
	private int yPosition = STARTING_Y;
	private Direction direction = START_DIRECTION;
	private Grid grid;

	public Rover() {
		this.grid = new Grid();
	}

	public Rover(Grid grid) {
		this.grid = grid;
	}

	public int getX() {
		return grid.getX(xPosition);
	}

	public int getY() {
		return grid.getY(yPosition);
	}

	public Direction getDirection() {
		return this.direction;
	}

	public String runCommand(String command) {
		for (char commandChar : command.toCharArray()) {
			if (commandChar == 'L') {
				turnLeft();
			}
			if (commandChar == 'R') {
				turnRight();
			}
			if (commandChar == 'M') {
				Point nextPosition = move();
				if (grid.hasObstacleOn(nextPosition.getX(), nextPosition.getY())) {
					return "O:" + toString();
				}
				assignNewPosition(nextPosition);
			}
		}
		return toString();
	}

	private void assignNewPosition(Point position) {
		this.xPosition = position.getX();
		this.yPosition = position.getY();
	}

	private Point move() {
		int nextYPosition = yPosition;
		int nextXPosition = xPosition;

		switch (direction) {
			case NORTH:
				nextYPosition++;
				break;
			case SOUTH:
				nextYPosition += grid.getHeight() - 1;
				break;
			case EAST:
				nextXPosition++;
				break;
			case WEST:
				nextXPosition += grid.getWidth() - 1;
				break;
		}

		return new Point(nextYPosition, nextXPosition);
	}

	@Override
	public String toString() {
		return String.format("%d:%d:%s", getX(), getY(), this.direction);
	}

	private void turnRight() {
		this.direction = direction.turnRight();
	}

	private void turnLeft() {
		this.direction = direction.turnLeft();
	}

}

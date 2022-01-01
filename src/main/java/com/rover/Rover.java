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
				move();
			}
		}
		return toString();
	}

	private void move() {
		if (direction == START_DIRECTION) {
			yPosition++;
		}
		if (direction == Direction.EAST) {
			xPosition++;
		}
		if (direction == Direction.WEST) {
			xPosition += grid.getWidth() - 1;
		}
		if (direction == Direction.SOUTH) {
			yPosition += grid.getHeight() - 1;
		}
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

package com.rover;

public class Rover {

	private static final int STARTING_Y = 0;
	private static final int STARTING_X = 0;

	private int x;
	private int y;
	private Direction direction;

	public Rover() {
		this.x = STARTING_X;
		this.y = STARTING_Y;
		this.direction = Direction.NORTH;
	}

	public int getX() {
		return STARTING_X;
	}

	public int getY() {
		return STARTING_Y;
	}

	public Direction getDirection() {
		return this.direction;
	}

	public void runCommand(String command) {
		for (char commandChar : command.toCharArray()) {
			if (commandChar == 'L') {
				turnLeft();
			}
			if (commandChar == 'R') {
				turnRight();
			}
		}
	}

	private void turnRight() {
		this.direction = direction.turnRight();
	}

	private void turnLeft() {
		this.direction = direction.turnLeft();
	}
}

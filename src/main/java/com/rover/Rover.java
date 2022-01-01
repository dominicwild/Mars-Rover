package com.rover;

public class Rover {

	private static final int BOUNDARY_Y = 10;
	private static final int BOUNDARY_X = 10;
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
		return this.x % BOUNDARY_X;
	}

	public int getY() {
		return this.y % BOUNDARY_Y;
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
		if (direction == Direction.NORTH) {
			y++;
		}
		if (direction == Direction.EAST) {
			x++;
		}
		if (direction == Direction.WEST) {
			x += BOUNDARY_X - 1;
		}
		if (direction == Direction.SOUTH) {
			y += BOUNDARY_Y - 1;
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

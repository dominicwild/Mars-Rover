package com.rover;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public enum Direction {
	NORTH, WEST, SOUTH, EAST;

	private static Map<Direction, Direction> leftDirections = new EnumMap<>(Direction.class);
	private static Map<Direction, Direction> rightDirections = new EnumMap<>(Direction.class);

	static {
		leftDirections.put(NORTH, WEST);
		leftDirections.put(WEST, SOUTH);
		leftDirections.put(SOUTH, EAST);
		leftDirections.put(EAST, NORTH);
		rightDirections.put(NORTH, leftDirections.get(SOUTH));
		rightDirections.put(SOUTH, leftDirections.get(NORTH));
		rightDirections.put(WEST, leftDirections.get(EAST));
		rightDirections.put(EAST, leftDirections.get(WEST));
	}

	public Direction turnLeft() {
		return leftDirections.get(this);
	}

	public Direction turnRight() {
		return rightDirections.get(this);
	}

	@Override
	public String toString() {
		return "" + this.name().charAt(0);
	}

}

package com.grid;

import java.util.HashMap;
import java.util.Map;

public class Grid {

	private static final int GRID_HEIGHT = 10;
	private static final int GRID_WIDTH = 10;

	Map<String, Boolean> obstacles = new HashMap<>();

	public int getWidth() {
		return GRID_WIDTH;
	}

	public int getHeight() {
		return GRID_HEIGHT;
	}

	public void placeObstacle(int i, int j) {
		boolean obstaclePlaced = true;
		obstacles.put(coordinateKey(i, j), obstaclePlaced);
	}

	private String coordinateKey(int i, int j) {
		return i + "," + j;
	}

	public boolean isObstacle(int i, int j) {
		return obstacles.getOrDefault(coordinateKey(i, j), false);
	}

	public int getX(int xPosition) {
		return xPosition % GRID_WIDTH;
	}

	public int getY(int yPosition) {
		return yPosition % GRID_HEIGHT;
	}

}

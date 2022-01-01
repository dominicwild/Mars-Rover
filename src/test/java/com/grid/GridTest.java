package com.grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GridTest {

	@Test
	void grid_is_created_with_default_size_10_10() {
		Grid grid = new Grid();
		assertEquals(10, grid.getWidth());
		assertEquals(10, grid.getHeight());
	}

	@Test
	void obstacle_can_be_placed_in_the_grid() {
		Grid grid = new Grid();
		grid.placeObstacle(1, 1);
		assertTrue(grid.hasObstacleOn(1, 1));
	}

	@Test
	void space_in_grid_has_no_obstacles_when_created(){
		Grid grid = new Grid();
		for (int i = 0; i < grid.getWidth(); i++) {
			for (int j = 0; j < grid.getHeight(); j++) {
				assertFalse(grid.hasObstacleOn(i, j));
			}
		}
	}

}

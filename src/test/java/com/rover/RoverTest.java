package com.rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.grid.Grid;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RoverTest {

	@Test
	void rover_begins_at_position_0_0_facing_north() {
		Rover rover = new Rover();
		assertEquals(0, rover.getX());
		assertEquals(0, rover.getY());
		assertEquals(Direction.NORTH, rover.getDirection());
	}

	@Test
	void rover_run_commands_returns_state_string() {
		Rover rover = new Rover();

		String state = rover.runCommand("");

		assertEquals("0:0:N", state);
	}

	@Test
	void rover_moving_north_increments_y_by_one(){
		Rover rover = new Rover();
		
		String state = rover.runCommand("M");

		assertEquals("0:1:N", state);
	}

	@Test
	void rover_turning_right_then_moving_increments_x_by_one(){
		Rover rover = new Rover();
		
		String state = rover.runCommand("RM");

		assertEquals("1:0:E", state);
	}

	@Test
	void rover_moving_right_then_north_increments_x_and_y_by_one(){
		Rover rover = new Rover();
		
		String state = rover.runCommand("RMLM");

		assertEquals("1:1:N", state);
	}

	@Test
	void rover_moving_west_wraps_around_on_x(){
		Rover rover = new Rover();
		
		String state = rover.runCommand("LM");

		assertEquals("9:0:W", state);
	}

	@Test
	void rover_moving_west_twice_wraps_on_x(){
		Rover rover = new Rover();
		
		String state = rover.runCommand("LMM");

		assertEquals("8:0:W", state);
	}

	@Test
	void rover_moving_south_wraps_around_on_y(){
		Rover rover = new Rover();
		
		String state = rover.runCommand("LLM");

		assertEquals("0:9:S", state);
	}

	@Test
	void rover_moving_south_twice_wraps_around_on_y(){
		Rover rover = new Rover();
		
		String state = rover.runCommand("LLMM");

		assertEquals("0:8:S", state);
	}

	@Test
	void rover_moving_onto_obstacle_stops_at_obstacle(){
		Grid grid = new Grid();
		grid.placeObstacle(0, 3);

		Rover rover = new Rover(grid);
		String state = rover.runCommand("MMMMM");

		assertEquals("O:0:2:N", state);
	}

	@Nested
	class DirectionTests {

		@Test
		void rover_turning_left_from_north_turns_to_west() {
			Rover rover = new Rover();

			rover.runCommand("L");

			assertEquals(Direction.WEST, rover.getDirection());
		}

		@Test
		void rover_turning_left_twice_faces_south() {
			Rover rover = new Rover();

			rover.runCommand("LL");

			assertEquals(Direction.SOUTH, rover.getDirection());
		}

		@Test
		void rover_turning_left_three_times_faces_east() {
			Rover rover = new Rover();

			rover.runCommand("LLL");

			assertEquals(Direction.EAST, rover.getDirection());
		}

		@Test
		void rover_turning_left_four_times_faces_north() {
			Rover rover = new Rover();

			rover.runCommand("LLLL");

			assertEquals(Direction.NORTH, rover.getDirection());
		}

		@Test
		void rover_turning_right_from_north_turns_to_east() {
			Rover rover = new Rover();

			rover.runCommand("R");

			assertEquals(Direction.EAST, rover.getDirection());
		}

		@Test
		void rover_turning_right_twice_faces_south() {
			Rover rover = new Rover();

			rover.runCommand("RR");

			assertEquals(Direction.SOUTH, rover.getDirection());
		}

		@Test
		void rover_turning_right_three_times_faces_west() {
			Rover rover = new Rover();

			rover.runCommand("RRR");

			assertEquals(Direction.WEST, rover.getDirection());
		}

		@Test
		void rover_turning_right_four_times_faces_north() {
			Rover rover = new Rover();

			rover.runCommand("RRRR");

			assertEquals(Direction.NORTH, rover.getDirection());
		}
	}

}

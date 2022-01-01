package com.rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RoverTest {
	
	@Test
	void rover_begins_at_position_0_0_facing_north(){
		Rover rover = new Rover();
		assertEquals(0, rover.getX());
		assertEquals(0, rover.getY());
		assertEquals(Direction.NORTH, rover.getDirection());
	}

}

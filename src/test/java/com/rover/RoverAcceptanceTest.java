package com.rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RoverAcceptanceTest {
    
    @Test
    void rover_moving_to_2_3_facing_north(){
        Rover rover = new Rover();
        
        String state = rover.runCommand("MMRMMLM");
        
        assertEquals("2:3:N", state);
    }

    @Test
	void rover_moving_10_times_in_any_direction_wraps_around_to_its_initial_position(){
		Rover rover = new Rover();
		
		String state = rover.runCommand("MMMMMMMMMM");
		assertEquals("0:0:N", state);

		rover = new Rover();
		state = rover.runCommand("LMMMMMMMMMM");
		assertEquals("0:0:W", state);

		rover = new Rover();
		state = rover.runCommand("LLMMMMMMMMMM");
		assertEquals("0:0:S", state);

		rover = new Rover();
		state = rover.runCommand("LLLMMMMMMMMMM");
		assertEquals("0:0:E", state);
	}

	@Test
	void rover_can_move_across_all_four_boundaries(){
		Rover rover = new Rover();
		
		String state = rover.runCommand("LMLMLMLMMRM");
		assertEquals("1:1:E", state);
	}

}

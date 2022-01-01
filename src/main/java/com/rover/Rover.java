package com.rover;

public class Rover {

    private static final int STARTING_Y = 0;
    private static final int STARTING_X = 0;

    public int getX() {
        return STARTING_X;
    }

    public int getY() {
        return STARTING_Y;
    }

    public Direction getDirection() {
        return Direction.NORTH;
    }
}

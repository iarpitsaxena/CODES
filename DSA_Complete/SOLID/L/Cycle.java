package SOLID.L;

public class Cycle implements Vehicle {

    /*@Override
    public boolean startEngine() {
        throw new UnsupportedOperationException("Cycles do not have engines.");
        // Cycles do not have engines, so we return false
    }*/

    @Override
    public int speed() {
        // Return a default speed for a cycle
        return 15; // Example speed in km/h
    }

}

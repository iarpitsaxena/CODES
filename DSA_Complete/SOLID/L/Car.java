package SOLID.L;

public class Car implements
Vehicle {

    public boolean startEngine() {
        // Logic to start the car engine
        System.out.println("Car engine started.");
        return true; // Assuming the engine starts successfully
    }

    @Override
    public int speed() {
        // Return a default speed for a car
        return 100; // Example speed in km/h
    }
}

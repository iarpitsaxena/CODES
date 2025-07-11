package SOLID.L;

public class Client {
    public static void main(String[] args) {
        Vehicle v = new Car();
        Vehicle v1 = new Cycle();
        CarDekho carDekho = new CarDekho(v);
        CarDekho carDekho1 = new CarDekho(v1);


    }
}

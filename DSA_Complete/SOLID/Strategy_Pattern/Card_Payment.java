package SOLID.Strategy_Pattern;

public class Card_Payment implements Payment_Strategy {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Credit/Debit Card.");
    }
}

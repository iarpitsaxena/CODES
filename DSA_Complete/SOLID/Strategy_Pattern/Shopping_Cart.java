package SOLID.Strategy_Pattern;

public class Shopping_Cart {
    private Payment_Strategy paymentStrategy;

    public void setPaymentStrategy(Payment_Strategy paymentStrategy) {
        if(paymentStrategy==null){
            System.out.println("Payment strategy cannot be null");
        }
        else{
            this.paymentStrategy = paymentStrategy;
        }
    }
    public void checkout(int amount) {
        if(paymentStrategy == null) {
            System.out.println("Payment strategy not set");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}

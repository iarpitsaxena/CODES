package SOLID.Strategy_Pattern;

public class ShoppingCartClient {
    public static void main(String[] args) {
        Payment_Strategy p = new Card_Payment();
        Shopping_Cart cart = new Shopping_Cart();
        cart.setPaymentStrategy(p);
        cart.checkout(1000);
        Shopping_Cart cart1 = new Shopping_Cart();
        cart1.setPaymentStrategy(new paypal_payment());
        cart1.checkout(2000);
        cart.setPaymentStrategy(null);
        cart.checkout(3000);
    }
}

/*
package SOLID.S_O;

public class Invoice {
    Pen pen;
    public Invoice(Pen pen){
        this.pen = pen;

    }
    public int createInvoice(){
        return (int) (pen.price * 1.18) + 2;
    }
//    public void sendMail(){
//        System.out.println("sending gmail");
//    }
//    public void print(){
//        System.out.println("Printing Invoice");
//    }
}
*/

package SOLID.S_O;

public class Invoice {
    Pen pen;

    public Invoice(Pen pen) {
        this.pen = pen;
    }

    public int createInvoice() {
        return (int) (pen.price * 1.18) + 2;  // price + 18% GST + delivery fee
    }
}

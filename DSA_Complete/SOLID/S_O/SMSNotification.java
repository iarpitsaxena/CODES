/*
package SOLID.S_O;

public abstract class SMSNotification extends SendNotification {

    @Override
    public void SendNotification(Invoice i){

    }
}
*/
package SOLID.S_O;

public class SMSNotification extends SendNotification {  // Not abstract anymore
    @Override
    public void send(Invoice i) {
        System.out.println("Sending SMS for Invoice: " + i.createInvoice());
    }
}

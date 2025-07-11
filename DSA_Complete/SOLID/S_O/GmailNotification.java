/*
package SOLID.S_O;

public abstract class GmailNotification extends SendNotification {
    @Override
    public void SendNotification(Invoice i){
        System.out.println("Sending Gmail");
    }


}*/


package SOLID.S_O;

public class GmailNotification extends SendNotification {  // Not abstract anymore
    @Override
    public void send(Invoice i) {
        System.out.println("Sending Gmail for Invoice: " + i.createInvoice());
    }
}

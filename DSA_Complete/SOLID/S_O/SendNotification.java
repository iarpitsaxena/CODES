/*
package SOLID.S_O;

public abstract class SendNotification {
//   Invoice i;
//
//    public SendNotification(Invoice i) {
//        this.i = i;
//    }
//    public void sendMail(){
//        System.out.println("Sending mail");
//    }

    public abstract void Send_Notification(Invoice i);
}
*/

package SOLID.S_O;

public abstract class SendNotification {
    public abstract void send(Invoice i);  // Method renamed to `send`
}

/*
package SOLID.S_O;

*/
/*public class Invoice_Client {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Invoice i = new Invoice(pen);
        System.out.println(i.createInvoice());
//        i.sendMail();
//        i.print();
//        SendNotification sn = new SendNotification(i);
//        sn.sendMail();
        SendNotification sn = new GmailNotification();
        SendNotification sn1 = new SMSNotification();
        sn.send(i);


    }

}*//*



public class Invoice_Client {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Invoice i = new Invoice(pen);
        System.out.println(i.createInvoice());

        SendNotification sn = new GmailNotification();
        SendNotification sn1 = new SMSNotification();

        sn.send(i);
        sn1.send(i);
    }
}

*/


package SOLID.S_O;

public class Invoice_Client {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Invoice i = new Invoice(pen);
        System.out.println("Invoice total: " + i.createInvoice());

        SendNotification sn = new GmailNotification();
        SendNotification sn1 = new SMSNotification();

        sn.send(i);
        sn1.send(i);
    }
}

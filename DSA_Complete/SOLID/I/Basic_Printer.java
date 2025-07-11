package SOLID.I;

public abstract class Basic_Printer  implements print,scan,fax {
    @Override
    public void print(String document) {
        System.out.println("Printing: " + document);
    }

    @Override
    public void fax() {

    }

    @Override
    public void scan(String document) {

    }

}

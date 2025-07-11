package SOLID.D;

public class DBA {
    private database d;
    public DBA(database d) {
        this.d = d;
    }
    public void print() {
        System.out.println(d);
    }
}

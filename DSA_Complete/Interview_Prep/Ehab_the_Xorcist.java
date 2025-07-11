package Interview_Prep;
import java.util.Scanner;

public class Ehab_the_Xorcist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long u = sc.nextLong(); // Take input
        long v = sc.nextLong();

        if (u > v || (u % 2 != v % 2)) {
            System.out.println(-1);
            return;
        }

        if (u == 0 && v == 0) {
            System.out.println(0);
        } else if (u == v) {
            System.out.println(1);
            System.out.println(u);
        } else {
            long x = (v - u) / 2;
            if ((u & x) == 0) {
                System.out.println(2);
                System.out.println((u + x) + " " + x);
            } else {
                System.out.println(3);
                System.out.println(u + " " + x + " " + x);
            }
        }
    }
}


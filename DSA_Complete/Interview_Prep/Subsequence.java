package Immersion;

public class Subsequence {
    public static void main(String[] args) {
        String str = "abc";
    }

    public static void print(String s) {
        int n = s.length();
        for (int i = 0; i < (1 << n); i++) {
            Print(s, i);

        }
    }

    private static void Print(String s, int i) {
        int pos = 0;
        while (i > 0) {
            if ((i & 1) != 0) {
                System.out.print(s.charAt(pos));
            }
            pos++;
            i >>= 1;
        }
        System.out.println();
    }
}
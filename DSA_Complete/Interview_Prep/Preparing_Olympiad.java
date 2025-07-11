package Interview_Prep;

import java.util.Scanner;


public class Preparing_Olympiad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int x = sc.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        int result = preparing(c, l, r, x);
        System.out.println(result);
    }

    public static int preparing(int[] c, int l, int r, int x) {
        int n = c.length;
        int ans = 0;
        for (int i = 3; i < (1 << n); i++) {
            if (fastCountBit(i) >= 2 && isValid(c, i, l, r, x)) {
                ans++;
            }
        }
        return ans;
    }

    public static boolean isValid(int[] c, int i, int l, int r, int x) {
        int pos = 0;
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (i > 0) {
            if ((i & 1) != 0) {
                sum += c[pos];
                min = Math.min(min, c[pos]);
                max = Math.max(max, c[pos]);
            }
            pos++;
            i >>= 1;
        }
        return sum >= l && sum <= r && (max - min) >= x;
    }


    public static int fastCountBit(int n) {
        int c = 0;
        while (n > 0) {
            c++;
            n &= (n - 1);
        }
        return c;
    }
}

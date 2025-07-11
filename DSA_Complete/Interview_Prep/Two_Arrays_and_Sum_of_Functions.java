package Interview_Prep;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Two_Arrays_and_Sum_of_Functions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [] a = new long[n];
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            a[i] = x * (i+1)*(n-i);

        }
        for (int i = 0; i < b.length; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        int mod = 998244353;
        long ans = 0;
        for (int i = 0; i < b.length; i++) {
            ans += ((a[i]%mod) * b[i]) % mod;
            ans %= mod;
        }
    }
}

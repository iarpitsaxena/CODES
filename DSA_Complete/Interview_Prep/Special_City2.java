package Interview_Prep;

import java.util.Scanner;

public class Special_City2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] dis = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (i > x) {
                int mn = 1;
                int mx = n - i;
                dis[mn]++;
                dis[mx]--;
            }

        }
    }
}

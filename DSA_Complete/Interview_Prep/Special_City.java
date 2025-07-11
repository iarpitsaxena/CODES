package Interview_Prep;

import java.util.Scanner;

public class Special_City {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] dis = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int j =i + 1; j <= n; j++){
                int a = j - i;
                int b = Integer.MAX_VALUE;
                if(i<=x && j<=y) {
                    b = x - i + 1 + j - y;
                }
            }

        }
    }
}

import java.util.*;

import java.util.Arrays;

public class Knapsack {
    static int knapsack(int W, int[] weight, int[] value, int n) {
        int[][] K = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

    public static void main(String[] args) {
        int[] value = {12, 8, 20, 5};
        int[] weight = {3, 2, 5, 1};
        int W = 8;
        int n = val.length;
        System.out.println("Maximum value: " + knapsack(W, weight, value, n));
    }
}
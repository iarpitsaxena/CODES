package Examples;

import java.util.Scanner;

public class SmartCity {
    public static String isSmartCity(int[] heights, int N){
        for (int i = 0; i < N/2; i++) {
            if(heights[i] != heights[N/2 + i]) return "NO";

        }
        return "Yes";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[] heights = new int[N];
            for (int i = 0; i < N; i++) {
                heights[i] = sc.nextInt();
            }
            System.out.println(isSmartCity(heights,N));
        }
        sc.close();
    }
}


/*
Convert Kashmir into Smart City

In new Kashmir, Modi wants to convert the existing cities into SMART Cities. Each city has N number of towers arranged in a row with different heights h
        i
​
        , where N is even.

A city will be called SMART if it is possible to arrange the towers such that, the height of left half is equals to the height of right half, i.e., if M=
        2
N
​
then, h
1
        ​
        =h
M+1
        ​
        ,h
2
        ​
        =h
M+2
        ​
        ,…,h
        M
​
        =h
        N
​

Modi appoints you to decide whether a city can be converted to SMART city or not.
Input format

First line of input contains T, denoting the number of test cases.
The first line of each test case contains an integer N, denoting the number of integers in the height array.
The second line of each test lase contains N space-separated integers, denoting heights of towers of the height array.
        Output format
Output YES if it is possible to convert the city into smart else print NO
Constraints
1≤T≤3
        2≤N≤10
        5

        1≤h
        i
​
        ≤10
        6

        ​

N is even*/

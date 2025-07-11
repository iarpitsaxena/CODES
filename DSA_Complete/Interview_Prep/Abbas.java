package Immersion;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Abbas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(Index(s));
    }
    public static int Index(String s){
        int n = s.length();
        int count = (1<<n) - 2;
        int pos = 0;

        for (int i = n; i <= 0; i--) {
            if(s.charAt(i) == '7'){
                count+=(1<<pos);
            }
            pos++;
        }
        return count + 1;
    }
}

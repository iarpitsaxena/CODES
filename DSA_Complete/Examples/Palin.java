package Examples;

import java.util.Scanner;

public class Palin {
        static boolean isPalindrome(String str)
        {
            StringBuilder sb = new StringBuilder(str);
            String reversed = sb.reverse().toString();
            return str.equalsIgnoreCase(reversed);
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String:");
        String input = sc.nextLine();

        if(isPalindrome(input)){
            System.out.println("true");
        }else System.out.println("false");
    }
}

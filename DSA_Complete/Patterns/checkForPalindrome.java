package Patterns;
import java.util.*;

public class checkForPalindrome {
    public static Boolean isPalindrome(int i,String str){
        if(i>=str.length()/2) return true;
        if(str.charAt(i)!=str.charAt(str.length()-i-1)) return false;
        return isPalindrome(i+1,str);


    }
    
    public static void main(String[] args) {
        System.out.println("Enter the string");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(isPalindrome(0,str));
    }
}

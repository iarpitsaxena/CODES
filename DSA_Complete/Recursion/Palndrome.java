package Recursion;

public class Palndrome {
    public static void main(String[] args) {
        int num = 123432;
//        isPalin(num);
        System.out.println(ispalin(num));
    }
    static boolean ispalin(int num){
        int digits = (int) Math.log10(num) + 1;
        return helper(num, digits);
    }
    static boolean helper(int num, int digits){
        if(num < 10)
            return true;

        int firstDigit = num / (int) Math.pow(10, digits - 1);
        int lastDigit = num % 10;

        if(firstDigit != lastDigit)
            return false;
        int newNum = (num % (int) Math.pow(10, digits - 1)) / 10;

        return helper(newNum,digits - 2);
    }
}

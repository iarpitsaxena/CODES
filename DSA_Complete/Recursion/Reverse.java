package Recursion;
// Way 1
/*public class Reverse {
    public static void main(String[] args) {
        int num = 32;
        reverse(num);
        System.out.println(reversed);
    }
    static void reverse(int num){
        if(num == 0)
            return;
        reversed = reversed * 10 + (num%10);
        reverse(num/10);
    }
    static int reversed = 0;
}*/

// Way 2

/*
public class Reverse{
    public static void main(String[] args) {
        int num = 456;
//        reverse(num);
        System.out.println(reverse(num));
    }
    public static int reverse(int num){
        return helper(num, 0);
    }
    private static int helper(int num, int reversed){
        if (num == 0) {
            return reversed;
        }
        return helper((num/10),(reversed * 10 + (num%10)));
    }
}

*/


public class Reverse{
    public static void main(String[] args) {
        int num = 5426;
        System.out.println(reverseNumber(num));
    }
    static long reverseNumber(long num){
        int digits = (int) Math.log10(num)+ 1;
        return helper(num, digits);
    }
    private static long helper(long num, int digits){
        if(num == 0){
            return 0;
        }
        return (num%10) * (long) Math.pow(10,digits-1) + helper(num/10, digits - 1);
    }
}
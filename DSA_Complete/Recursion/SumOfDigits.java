package Recursion;

public class SumOfDigits {
    public static void main(String[] args) {
        int num = sum(554);
        System.out.println(num);

    }
    static int sum(int num){
        if(num == 0)
            return 0;
        return num%10 + sum(num/10);
    }
}

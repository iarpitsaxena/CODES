package Recursion;

public class Fibo {
    public static void main(String[] args) {
//        int n =6;
        System.out.println(fibo(6));
    }
    public static int fibo(int n){
        if(n < 2){
            return n;
        }
        return(fibo(n-1) + fibo(n-2));
    }
}

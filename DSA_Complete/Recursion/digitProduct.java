package Recursion;

public class digitProduct {
    public static void main(String[] args) {
        int num = prod(1);
        System.out.println(num);
    }
        static int prod(int n){
        if(n%10 == n){
            return n;
        }
        return (n%10) * prod(n/10);
    }

}

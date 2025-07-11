package Recursion;
//TO PRINT THE PRODUCT OF TWO NUMBERS
public class Ques3 {
    public static void main(String[] args) {
        int n = fun(5);
        System.out.println(n);
    }
    static int fun(int n){
        if(n<= 1)
            return 1;
        return n * fun(n-1);
    }
}

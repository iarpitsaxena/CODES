package Recursion;

public class Concept {
    public static void main(String[] args) {
        int num  = 5;
        fun(num);
    }
    static void fun(int num){
        if(num == 0)
            return;
        System.out.println(num);
        fun(--num);
    }
}

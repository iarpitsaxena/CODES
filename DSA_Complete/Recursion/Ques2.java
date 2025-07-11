package Recursion;

import javax.crypto.spec.PSource;
// PRINT 1 TO N
public class Ques2 {
    public static void main(String[] args) {
        fun(5);
    }
    static void fun(int i){
        if(i==0){
            return;
        }
        fun(i-1);
        System.out.println(i);
    }
}

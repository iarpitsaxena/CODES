package Recursion;
// Print n to 1
public class Ques1 {
    public static void main(String[] args) {
//        int num = 5;/
        fun(4);
    }

    private static void fun(int i) {
        if(i == 0){
            return;
        }
        System.out.println(i);

        fun(i-1);

        return;
    }

}

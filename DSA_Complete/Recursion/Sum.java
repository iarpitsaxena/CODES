package Recursion;
//TO PRINT THE SUM OF N NUMBERS
public class Sum {
    public static void main(String[] args) {
        int num = sum(5);
        System.out.println(num);
    }
    static int sum(int num){
        if(num == 0){
            return num;
        }
        return num + sum(num-1);
    }
}

package LeetCode;

public class _1780 {
    public static void main(String[] args) {

    }

    public static boolean checkPowerThree(int n){
        return checkPowerOfThree(0,n);
    }

    public static boolean checkPowerOfThree(int power,int n){
        if(n == 0) return true;
        if(Math.pow(3,power) > n) return false;

        boolean addPower = checkPowerOfThree(
                power+1, n - (int)Math.pow(3,power)
        );

        boolean skipPower = checkPowerOfThree(power + 1, n);

        return addPower || skipPower;
    }
}

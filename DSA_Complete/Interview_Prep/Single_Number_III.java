package Immersion;

public class Single_Number_III {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,2,5};
    }
    public static int[] singleNumber(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        int mask = xor & -xor;// xor & (
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] & mask) != 0){
                a^= arr[i];
            }
        }
        int b = xor ^ a;
        int[] ans = {a, b};
        return ans;
    }
}

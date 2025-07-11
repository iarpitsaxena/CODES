package Interview_Prep;

public class CountSetBits {
    public static void main(String[] args) {
        int n = 84;
        System.out.println(countBit(n));
    }
    public static int countBit(int n){
        int c = 0;
        while(n > 0){
            if((n & 1) != 0){
                c++;
            }
            n >>= 1;
        }
        return c;
    }
    public static int fastCountBit(int n){
        int c = 0;
        while(n > 0){
            c++;
            n &= (n - 1);
        }
        return c;
    }
}

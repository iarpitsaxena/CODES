package Interview_Prep;

public class Set_Theory {
    public static void main(String[] args) {
        int n = 1000;
        int[] prime  ={2,3,5};
    }
    public static int Count_factor(int n, int[] prime){
        int sum = 0;
        for (int i = 1; i < (1 << prime.length); i++) {
            int count = powerSet(n, prime,i);
            if((fastCountBit(n)&1)!=0){
                sum += count;
            }
            else{
                sum -= count;
            }
        }
        return sum;
    }
    private static int powerSet(int n, int[] prime, int i) {
        int pos = 0, p = 1;
        while(i > 0){
            if((i & 1) != 0){
                p *= prime[pos];
            }
            pos++;
            i >>= 1;
        }
        return n/p;
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



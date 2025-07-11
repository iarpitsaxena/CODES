package CodeForces;
import java.util.*;

public class CGDcomposition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        GCD_Composition(arr,"","",0);

    }
    public static void GCD_Composition(int[] arr, String ans1, String ans2, int i) {
        if (i == arr.length) {
            System.out.println(ans1 + "and" + ans2);
            return;
        }

        GCD_Composition(arr, ans1 + arr[i] + " ", ans2, i + 1);
        GCD_Composition(arr,ans1,ans2 + arr[i] + " ", i + 1);
    }
}

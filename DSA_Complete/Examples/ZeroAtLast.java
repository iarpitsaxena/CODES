package Examples;

import java.util.Arrays;

public class ZeroAtLast {
    public static void main(String[] args) {
        int[] arr = {0, 3, 0, 4, 1};
        zeroAtLast(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void zeroAtLast(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[k] = arr[i];
                k++;
            }
        }
        while (k < arr.length) {
            arr[k] = 0;
            k++;
        }
    }
}

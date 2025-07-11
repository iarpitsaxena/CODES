package Examples;

import java.util.Arrays;
import java.util.Scanner;

public class LeftRotateOne {
    public static void leftRotate(int[] arr) {
        if (arr.length == 0) return;

        int first = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = first;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        leftRotate(arr);
        System.out.println("Array after left rotation by one:");
        System.out.println(Arrays.toString(arr));
    }
}

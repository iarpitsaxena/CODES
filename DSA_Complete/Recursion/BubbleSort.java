/*
package Recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 7, 1, 2};
        bubble(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble(int[] arr, int r, int c) {
        if (r == 0)
            return;

        if (c < r) {
            if (arr[c] > arr[c + 1]) {
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }
            bubble(arr, r, c + 1);
        } else {
            bubble(arr, r - 1, 0);
        }
    }
}
*/


package Recursion;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4,3,67,43,21};
        bubble(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
    public static void bubble(int[] arr, int l, int r){
        if(r == 0)
            return;
        if(l < r){
            if(arr[l] > arr[l+1]){
                swap(arr,l,l+1);
            }
            bubble(arr,l+1,r);
        }
        else{
            bubble(arr,0,r-1);
        }
    }
    public static void swap(int[] arr,int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
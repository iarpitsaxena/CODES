package Examples;

import java.util.Arrays;
public class demo {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 5, 8, 3, 5, 7};
        int num = 5;
        rearrange(arr,num);
        System.out.println(Arrays.toString(arr));
    }
    static void rearrange(int[] arr,int num){
        int low = 0,mid = 0, high = arr.length - 1;
        while(mid <= high){
            if(arr[mid] == num){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                mid++;
                low++;
            }
            else if(arr[mid] < num){
                mid++;
            }
            else{
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }


        }
    }
}

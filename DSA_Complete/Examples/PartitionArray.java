package Examples;
import java.util.Arrays;
import java.util.Scanner;

public class PartitionArray {
    public static int[] partitionArray(int[] arr, int num){
        int n = arr.length;
        int index = 0;

        // moving all == nums
        for(int i =0;i < n; i++){
            if(arr[i] == num){
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                index++;
            }
        }

        // move all < nums
        for(int i =index;i < n; i++){
            if(arr[i] < num){
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                index++;
            }
        }

        return arr;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = sc.nextInt();
        int[] arr = new int [n];
        System.out.println("Enter" + n + "Elements : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the pivot : ");
        int num = sc.nextInt();
        System.out.println("The Partitioned Array is :" );
        System.out.println(Arrays.toString(partitionArray(arr,num)));
    }
}

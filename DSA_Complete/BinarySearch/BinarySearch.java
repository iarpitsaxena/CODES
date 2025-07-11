package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-56,-45,-35,0,1,4,5,7,8,45,334,678};
        int target = 45;
        System.out.println(binarysearch(arr, target));
    }
    static int binarysearch(int[] arr, int target){
        int start =0;
        int end =arr.length - 1;
        while(start <= end){
            //int mid = (start + end) /2 it can cause integer overflow as the maximum value is 2^31 -1
            int mid = start + (end - start) /2;
            if(target < arr[mid]){
                end = mid -1;
            }
            else if(target > arr[mid]){
                start =  mid + 1;
            }
            else return mid;
        }
        return -1;
    }



}
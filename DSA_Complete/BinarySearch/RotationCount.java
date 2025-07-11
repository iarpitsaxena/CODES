package BinarySearch;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(binarysearch(arr));
    }

    static int binarysearch(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        if(arr[start] <= arr[end])
            return 0;
        while (start <= end) {
            //int mid = (start + end) /2 it can cause integer overflow as the maximum value is 2^31 -1
            int mid = start + (end - start) / 2;


//            if (arr[mid] < arr[end])
//                start = mid + 1;
//            else
//                end = mid;
//            if(mid < end && arr[mid] >arr[mid + 1])
//                return mid + 1;
//            if(mid > start && arr[mid] < arr[mid - 1])
//                return mid;
//            if(arr[start]<= arr[end]){
//                start = mid + 1;
//            }else{
//                end = mid -1;
//            }
            if(mid < end && arr[mid] >arr[mid + 1])
                return mid + 1;
            if(mid > start && arr[mid] < arr[mid - 1])
                return mid;
            if(arr[start]<= arr[end]){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return start +1;
    }
}
package BinarySearch;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr = {-56,-45,-35,0,1,4,5,7,8,45,334,678};
        int target = 45;
        System.out.println(OrderAgnosticBS(arr, target));
    }

    static int OrderAgnosticBS(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        boolean isAsc = arr[start] < arr[end];

        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target)
                return mid;

            if(isAsc){
                if(target < arr[mid]){
                    end = mid -1;
                }
                else start = mid + 1;
            }
            else{
                if(target < arr[mid]){
                    start  = mid + 1;
                }
                else end = mid -1;
            }
        }
        return -1;



    }
}

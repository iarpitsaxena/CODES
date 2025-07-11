package LeetCode;

public class SplitArray_2270 {
    public static int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[0] = nums[0];
        for(int i = 1; i < n; ++i){
            arr[i] = nums[i] + nums[i-1];
        }
        int count = 0;
        for(int i = 0; i < n; ++i){
            int leftSum = arr[i];
            int rightSum = arr[n - 1] - arr[i];
            if(leftSum>= rightSum)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {10,4,-8,7};
        System.out.println(waysToSplitArray(nums));
    }
}

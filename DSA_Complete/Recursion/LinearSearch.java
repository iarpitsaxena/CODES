package Recursion;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2,4,6,3,7,99,53,45};
        int target = 46;
        System.out.println(isMatched(arr, 0, target));
    }

    static boolean isMatched(int[] arr, int index, int target){
        if(index == arr.length)
            return false;
        if(arr[index] == target)
            return true;
        else
            return isMatched(arr,index + 1, target);
    }
}

package Examples;
public class RotateArrayReverseAlgorithm {
//  For rotating the array right by k places using reverse algorithm.
    /*public static void rotateRight(int[] arr, int k){
        int n = arr.length;
        //reverse n - k elements
        reverse(arr,0,n-k-1);
        // reverse last k elements
        reverse(arr,n-k,n-1);
        //reverse whole array
        reverse(arr,0,n-1);
    }*/

// for rotating the array left by k places using reverse algorithm.
    public static void rotateLeft(int[] arr, int k){
        int n = arr.length;
        // for reversing first k elements
        reverse(arr,0,k - 1);
        reverse(arr,k,n - 1);
        reverse(arr,0,n - 1);

    }
    // for reversing the array
    private static void reverse(int[] arr, int start, int end){
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 2;
//        rotateRight(arr, k);
        rotateLeft(arr, k);
        System.out.println("Rotated array right by " + k + " places : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

package Examples;

public class RotateArrayRightByNPlaces {
    public static void rotateRight(int[] arr, int pivot){
        int n = arr.length;
        if(n == 0) return;
         pivot = pivot% n;
         int[] temp = new int[pivot];
         for(int i = n - pivot; i < n; i++){
             temp[i - n + pivot] = arr[i];
         }
         for(int i = n - pivot - 1; i >= 0;i--){
             arr[i + pivot] = arr[i];
         }

         for(int i = 0;i < pivot;i++){
             arr[i] = temp[i];
         }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 2;
        rotateRight(arr, k);
        System.out.println("Rotated array right by" + k + "places : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");

        }
    }
}

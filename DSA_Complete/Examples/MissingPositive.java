package Examples;

public class MissingPositive {
    public static void main(String[] args) {
        int[] arr = {1,-1,3,4};
        System.out.println(firstMissingPositive(arr));

    }

    static int firstMissingPositive(int[] arr){
        int num = arr.length;
        for(int i = 0; i < num;i++){
            while(arr[i]  > 0 && arr[i] <= num && arr[arr[i]-1] != arr[i]){
                int temp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = temp;
            }
        }
        for(int i  = 0; i < num; i++){
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        return num + 1;
    }
}

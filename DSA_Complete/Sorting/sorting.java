package Sorting;

import java.util.*;
public class sorting {
    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 1, 2};
//        bubble(arr);
//        insertion(arr);
//        selection(arr);
//        cyclicSort(arr);
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void selection(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            int last = arr.length - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr,maxIndex,last);
        }
    }

    static int getMaxIndex(int[] arr, int start, int end){
        int max = 0;
        for(int i = start;i < end; i++){
            if(arr[max] < arr[i]){
                max = i;
            }
        }
        return max;

    }

    static void bubble(int[] arr){
        boolean swapped;
        for(int i = 0; i < arr.length; i++){
            swapped = false;
            for(int j = 1; j < arr.length - i; j++){
                if(arr[j] < arr[j - 1]){
                    swap(arr, j, j -1);
                    swapped = true;
                }
            }
            if(!swapped)
                break;
        }
    }

    static void insertion(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j > 0; j--){
                if(arr[j] < arr[j-1]) {
                    swap(arr, j, j - 1);
                }
                else break;
            }
        }
    }

    static void cyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                swap(arr,i,correct);
            }
            else i++;
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static void mergeSort(int[] arr, int[] temp, int left, int  right){
        int mid;
        if(right > left){
//            mid = left + (right - left) / 2;
            mid = (left + right) /2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
//            merge(arr, temp, left, mid + 1, right);
            merge(arr, temp, left, mid + 1, right);
        }

    }
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int left_end, temp_pos, size;
        left_end = mid - 1;
        temp_pos =left;
        size = right - left + 1;
        while((left <= left_end) && (mid <= right)){
            if(arr[left] <= arr[mid]){
                temp[temp_pos] = arr[left];
                temp_pos+=1;
                left+=1;
            }
            else{
                temp[temp_pos] = arr[mid];
                temp_pos += 1;
                mid += 1;
            }
//            temp_pos += 1;
        }

        while(left <= left_end){
            temp[temp_pos] = arr[left];
            temp_pos += 1;
            left += 1;
        }
        while(mid <= right){
            temp[temp_pos] = arr[mid];
            temp_pos += 1;
            mid += 1;
        }
        for(int i = 0;i < size ;i++){
            arr[right] = temp[right];
            right = right - 1;
        }
    }

    public static void sort(int[] arr){
        int[] temp = new int[arr.length];
        mergeSort(arr,temp,0,arr.length - 1);
    }

}



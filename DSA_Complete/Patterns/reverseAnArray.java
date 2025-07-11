package Patterns;

public class reverseAnArray {
    
}




/*
using reverse library function

import java.util.*;
public class Main {
   //Function to print array
   static void printArray(Integer arr[], int n) {
      System.out.print("Reversed array is:- \n");
      for (int i = 0; i < n; i++) {
         System.out.print(arr[i] + " ");
      }
   }
   //Reverse array using library function
   static void reverseArray(Integer arr[]) {
      //fetching array as list object
      //reversing the fetched object
      Collections.reverse(Arrays.asList(arr));
   }
   public static void main(String[] args) {
      int n = 5;
      Integer arr[] = {5,4,3,2,1};
      reverseArray(arr);
      printArray(arr, n);
   }
}
 */



 /*
using recursion

 public class Main {
   //Function to print array
   static void printArray(int arr[], int n) {
      System.out.print("Reversed array is:- \n");
      for (int i = 0; i < n; i++) {
         System.out.print(arr[i] + " ");
      }
   }
   //Function to reverse array using recursion
   static void reverseArray(int arr[], int start, int end) {
      if (start < end) {
         int tmp = arr[start];
         arr[start] = arr[end];
         arr[end] = tmp;
         reverseArray(arr, start + 1, end - 1);
      }
   }
   public static void main(String[] args) {
      int n = 5;
      int arr[] = { 5, 4, 3, 2, 1};
      reverseArray(arr, 0, n - 1);
      printArray(arr, n);
   }
}
 
  */
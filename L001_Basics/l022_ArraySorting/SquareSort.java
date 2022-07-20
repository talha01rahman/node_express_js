import java.io.*;
import java.util.*;

public class SquareSort {
    
public static Scanner scn = new Scanner(System.in);
   
     public static void input(int[] arr){
        for(int i=0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
     }
    
    public static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }
    
    public static void square(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i] = arr[i] * arr[i];
        }
    }
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void bubbleSort_opti(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean isArraySorted = true;
            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    isArraySorted = false;
                }
            }

            if (isArraySorted)
                break;
        }
    }
    
    public static void main(String[] args) {
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        input(arr);
        System.out.print("Before Sorting: ");
        print(arr);
         
        square(arr);
        System.out.println();
        System.out.print(" After Square: ");
        print(arr);
        bubbleSort_opti(arr);
        System.out.println();
        System.out.print("After Sorting: ");
        print(arr);
        
    }
    
        
    
}

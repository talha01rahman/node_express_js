import java.io.*;
import java.util.*;

public class SortbyEven {
public static Scanner scn = new Scanner(System.in);
    
    public static void input(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
    }
    
    public static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void sortByEven(int[] arr){
        for(int i=0; i<arr.length; i++){
            boolean NoSwap = true;
            for(int j=1; j<arr.length-i; j++){
                if(arr[j-1]%2 != 0){
                    swap(arr, j-1, j);
                    NoSwap = false;
                }
             //   if(NoSwap)
             //       break;
            }
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        input(arr);
        sortByEven(arr);
        print(arr);
        
    }
}
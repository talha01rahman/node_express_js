import java.util.Scanner;

public class sort {

    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        printArray(arr);
        inputArray(arr);
        printArray(arr);
        bubblesort(arr,n);
    }

    public static void inputArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
    }

    public static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubblesort(int[] arr, int n){   
       
       for(int i=0; i<n; i++){
        for(int j=n-i; j<n; j++){

            if(arr[j-1]>arr[j]){
                swap(arr, j-1, j);
            }
        }
       }    
       printArray(arr);
    }

}

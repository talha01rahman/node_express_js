import java.util.Scanner;

public class binarySearch {
    public static Scanner scn = new Scanner(System.in);    
    public static void main(String[] args) {
        int n = scn.nextInt();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int k = binarySearch1(arr,n);
        System.out.println(k);
    }

    public static int binarySearch1(int[] arr, int n){
        int si = 0, ei = arr.length-1;
        
         int data = n;
        while(si<=ei){
            int mid = (si+ei)/2;
            
            if(arr[mid]==data){
                return mid;
            }
            else if(arr[mid]<data){
                si = mid+1;
            }
            else if(arr[mid]>data){
                ei = mid+1;
            }
            
        }
        return -1;
    }
}

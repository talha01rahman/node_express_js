import java.util.Scanner;

public class FindMissingNumber {
    public static void main(String[] args) {
        //Scanner scn = new Scanner(System.in);
        
        int[] arr = {-11,-10,-9,-8,-6};
        int n = arr.length;
       
        for(int i=0; i<n; i++){
            if(arr[i]!=(i+arr[0])){
                System.out.print(i+arr[0]);
               // break;
            }
        }
        
    }
}

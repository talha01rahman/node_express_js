import java.util.*;

public class ArrayTraversal {
    
    public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    System.out.println("Enter length of array : ");
    int n = scn.nextInt();
    
    int[] arr = new int[n];

    System.out.println("Enter the element of array : ");

    for(int i=0; i<n; i++){
        arr[i] = scn.nextInt();
    }

    for(int i=0; i<n; i++){
        for(int j=i+1; j<n; j++){
             if(arr[i]==arr[j]){
                System.out.print(arr[i]+" ");
             }
        }
    }
}
}

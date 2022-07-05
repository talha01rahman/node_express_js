import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SearchElement {

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int e = scn.nextInt();

        for(int i=0; i<n; i++){
            if(arr[i]==e){
                System.out.print(i);
                break;
            } 
            
            else if(arr[i]!=e && arr[i] == arr[n-1]){
                System.out.print(-1);
                break;
            }
            
        }
    
    }
}

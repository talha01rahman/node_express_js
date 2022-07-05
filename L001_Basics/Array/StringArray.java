import java.util.*;

public class StringArray {
    
    public static void main(String[] args) {
       Scanner scn = new Scanner(System.in);
       int N = scn.nextInt();
       String[] word1 = new String[N];
       String[] word2 = new String[N];
       int n = word1.length;

    //    String[] word1 = {"Talha", " Rahman "};
    //    String[] word2 = {"Talha", " Rahman "};

       System.out.println("Enter array for word1");

       for(int i=0; i<n; i++){
        word1[i] = scn.nextLine();
       }
       
       System.out.println("Enter array for word2");

       for(int i=0; i<n; i++){
       word2[i] = scn.nextLine();
       }
   

       for(int i=0; i<n; i++){
        System.out.print(word1[i]);
       }

       System.out.println();

       for(int i=0; i<n; i++){
        System.out.print(word1[i]);
       }
        
       for(int i=0; i<n; i++){
        if(word1[i]!=word2[i]){
        System.out.println("Different");
        }
        else
        System.out.println("same");
       }

       
    }
}

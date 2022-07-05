import java.util.*;

public class string {
    public static Scanner scn = new Scanner(System.in);
  //  int n = scn.nextInt();
    
    public static void main(String args[]){

        String str = "hey this is Talha Rahman";

        char ch = 'a';

        for(int i=0; i<str.length(); i++){
            
            if(str.charAt(i) == ch){
                System.out.println("yes "+str.charAt(i)  );
                break;
            }
                System.out.println("no");
                break;
         
        }
    }
}

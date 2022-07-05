import java.util.*;

public class daimond {
    public static Scanner scn = new Scanner(System.in);
    
     public static void daimondPattern(int n) {
        
        int nst = 1, nsp =n/2;

        for(int r=1; r<=n; r++){

            for(int csp=1; csp<=nsp; csp++){
                System.out.print("  ");
            }

            for(int cst=1; cst<=nst; cst++){
                System.out.print("* ");
            }
            
            
            System.out.println();
            if(r<=n/2){
                nst +=2;
                nsp--;
            }
            else{
                nst-=2;
                nsp++;
            }
            
        
        }
    }
    
    // public static void daimondPattern(int n) {
    //     if (n % 2 == 0) // if n is even make it odd
    //         n++;

    //     int nst = 1, nsp = n / 2;
    //     for (int r = 1; r <= n; r++) {
    //         for (int csp = 1; csp <= nsp; csp++)
    //             System.out.print("  ");

    //         for (int cst = 1; cst <= nst; cst++)
    //             System.out.print("* ");

    //         if (r <= n / 2) {
    //             nst += 2;
    //             nsp--;
    //         } else {
    //             nst -= 2;
    //             nsp++;
    //         }
    //         System.out.println();
    //     }
    // }

    public static void main(String[] args) {
        int n = scn.nextInt();
       // diamond2(n);
       daimondPattern(n);
    }
}

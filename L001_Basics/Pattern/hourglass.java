import java.util.*;

public class hourglass {

    public static Scanner scn = new Scanner(System.in);

    public static void pyramid(int n){

        int nst = 2*n-1, nsp = 0;

        for(int r=1; r<=n; r++){

            for(int csp=1; csp<=nsp; csp++){
                System.out.print("  "); 
            }

            for(int cst=1; cst<=nst; cst++){
                System.out.print("* "); 
            }

            System.out.println();
            nst -= 2;
            nsp++;
        }
    }

    public static void inversePyramid(int n){
        
        int nsp = n-1, nst=1;
        
        for(int r=1; r<=n; r++){

            for(int csp=1; csp<=nsp; csp++){
                System.out.print("  ");
            }

            for(int cst=1; cst<=nst; cst++){
                System.out.print("* ");
            }

            System.out.println();
            nst +=2;
            nsp--;
        }
    }

    public static void main(String[] args) {
         int n = scn.nextInt();
         
         pyramid(n);
         inversePyramid(n);
    }
}

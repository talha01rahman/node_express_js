import java.util.*;

public class l001_questions {

    public static Scanner scn = new Scanner(System.in);

    public static void input1D(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt(); // write
        }
    }

    public static void print1D(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " "); // read
        }
        System.out.println();
    }

    // A and B are the arrays of digit.
    public static int[] sumOftwoArrays(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int len = Math.max(n, m) + 1;

        int[] ans = new int[len];
        int i = n - 1, j = m - 1, k = len - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = (i >= 0 ? A[i] : 0) + (j >= 0 ? B[j] : 0) + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ans[k--] = digit;
            i--;
            j--;
        }

        return ans;
    }

    public static void main(String[] args) {
        
      int n = scn.nextInt();
      int m = scn.nextInt();
       //input1D(int[] arr)
       int A[] = new int[n];
       int B[] = new int[m];

        input1D(A);
        input1D(B);
        
       // sumOftwoArrays(int[] A, int[] B);
        sumOftwoArrays(A,B);
        

    }

}
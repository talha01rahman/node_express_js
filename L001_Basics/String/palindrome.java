public class palindrome {

    public static void main(String args[]){
     
        String str1 = "Talha";
        String str2 = "Talha";

        if(str1==str2){
            System.out.println("same thing");
        }
        
        long startTime =  System.currentTimeMillis();
        int i =0;
        while(i<1000000000){
            String str3 = "Talha Rahman";
            i++;
        }
        long endTime =  System.currentTimeMillis();

        System.out.println("time taken using string literal "+ (endTime-startTime) );

        long startTime1 =  System.currentTimeMillis(); 
        int j =0;
        while(j<1000000000){
            String str4 = new String("Talha Rahman");
            j++;
        }
        long endTime1 =  System.currentTimeMillis();

        System.out.println("time taken using new keyword "+ (endTime1-startTime1) );
        
    }
    
}

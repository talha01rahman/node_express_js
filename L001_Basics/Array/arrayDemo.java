import java.util.*;

public class arrayDemo {
    public static void main(String[] args) {
        
        // collection of int
         int[] rollNumbers = new int[10];
        
        // collection of String
         String[] name = new String[10];

        // rollNumbers = {1,2,3,4,5,6,7,8,9,10};

        //int[] rollNumbers = {1,2,3,4,5,6,7,8,9,10};

        // method have () <== parantesis
        for(int i=0; i<rollNumbers.length; i++){
               System.out.println("Roll number :"+rollNumbers[i]); 
               System.out.println("Name :"+name[i]);
        }
        
        rollNumbers[0] = 1;

        int roll=1;
        int index=0;
        while(index<10){
            rollNumbers[index] = roll;
            index++;
            roll++;
        }

        for(int i=0; i<10; i++){
            System.out.println("roll number : "+rollNumbers[i]);
        }
    
        // Take user input as name and insert to array;
        Scanner scn = new Scanner(System.in);
        for(int n=0; n<name.length; n++){
            System.out.println("Enter student name : "+ (n+1));
            name[n] = scn.nextLine();
        }

        for(int i=0; i<10; i++){
            System.out.println("name of student : "+(i+1)+" "+name[i]);
        }

        
}

}

import java.util.*;

public class ArraySearchElement {
    
    public static void main(String[] args) {

        int [] roll = {1,2,3,4,5,6,7,8,9,10};

        int searchRoll = 56;
        boolean ifPresent = searchElement(roll,searchRoll);
        System.out.println("Rollnumber1 "+searchRoll+" is present : "+ifPresent);

        int searchRoll2 = 8;
        boolean ifPresent2 = searchElement(roll,searchRoll2);
        System.out.println("Rollnumber2 "+searchRoll2+" is present : "+ifPresent2);

        // calling delete method
        String delete = deleteRollNumbers(roll, 5);
        System.out.println(delete);

        System.out.println(roll[4]);
        
    }

    public static boolean searchElement(int[] rollNumbers, int SearchRollNumner){
         
        boolean isPresent = false;

        for(int index=0; index<rollNumbers.length; index++){
            
            if(rollNumbers[index] == SearchRollNumner){
                isPresent = true;
                break;
            }
            
        }
        return isPresent;
    }         

    //  delete an element from an array
    private static String deleteRollNumbers(int[] rollNumbers, int deleteRollnumber){

        String deleteMessage = "";
        for(int index=0; index<rollNumbers.length; index++){
            if(rollNumbers[index] == deleteRollnumber){
                rollNumbers[index] = Integer.MIN_VALUE; //0
                deleteMessage= "Roll number deleted successfully";
            }
        }
        return deleteMessage;
    }
}

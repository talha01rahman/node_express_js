import java.util.*;

public class string {
    //0. Program to find the most repeated word in a line
    //"No where to run, no where to hide Lets take our time untill we drop No where to run, no where to hide Lets take our time untill we drop"
   //heap //map
    public static void main(String[] args) {
    //Scanner scn = new Scanner(System.in);
    
    String para = "No where to run, no where to hide Lets take our time untill we drop No where to run, no where to hide Lets take our time untill we drop";
    String[] words = para.split("\\s+");
        int finalCount = 0;
        int tempCount = 0;
        String mostlyUsedWord = null;
        for (String word: words) {
            tempCount = 0;
            for (String w: words) {
                if (word.equalsIgnoreCase(w)) {
                    tempCount++;
                }
            }
            if (tempCount >= finalCount) {
                finalCount = tempCount;
                mostlyUsedWord = word;
            }
        }
        System.out.println("mostlyUsedWord:: = " + mostlyUsedWord + " ,count:: = " + finalCount);
    }
}

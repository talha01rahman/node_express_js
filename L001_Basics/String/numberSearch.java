import java.util.*;
public class numberSearch {
    String str = "H3ello9-9";
    int sum = 0;
        int letters = 0;
        
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c))
                letters++;
            else if (Character.isDigit(c))
                sum += c - '0';
        }
        
        return Math.round((float)sum / letters);
    }


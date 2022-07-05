
public class contains {
    
    public static void main(String[] args) {

        String msg = "Hi Talha Rahman, How are you doing?";
        String email = "talha01rahman@gmail.com";

        boolean isCorrect = email.contains("@");
        boolean isAvi = msg.contains("Talha");
        
        msg = msg.replace("Hi", "Hey");
        System.out.println(msg); 

        System.out.println(isCorrect);
        System.out.println(isAvi);




    }
}

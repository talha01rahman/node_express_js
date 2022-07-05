public class substring {

    public static void main(String arg[]){

        // print all the substring of abc

        String str = "abcde";

        for(int i=0; i<str.length(); i++){
            for(int j=i; j<str.length(); j++){
                
                System.out.println(str.substring(i,j+1));
            }
        }
    }
    
}

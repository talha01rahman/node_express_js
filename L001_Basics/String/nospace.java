public class nospace {

    public static void main(String args[]){
   
        String ans = "";
        String str = "abc efg hij lmn";

        for(int i=0; i<str.length(); i++){

            if(str.charAt(i) == ' '){
                continue;
            }
            else{
                ans += str.charAt(i);
            }

        }
        System.out.println(ans);
        System.out.println("ans : "+ str.replaceAll(" ", ""));
    }


    
}

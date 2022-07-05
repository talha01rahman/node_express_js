public class StringIntern {
    
    public static void main(String[] args){

        String name = "Talha Rahman";
        String name1 = new String("Talha Rahman");

        boolean isTrue = name==name1;
        System.out.println(isTrue);
       // name1.intern();
      //boolean isTrue1 = name==name1.intern();
       
     
       
      System.out.println(name==name1.intern());



    }
}

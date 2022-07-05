public class SrringBuilder {
    public static void main(String[] args) {
        
        String str1 = "Talha";
        str1 += " Rahman";
        StringBuilder sb = new StringBuilder();
        // append;
        
        sb.append("Talha ");
        sb.append("Rahman");
        sb.append(" hey how are you");

        System.out.println(sb);
        System.out.println(str1);

        sb.reverse();
        System.out.println(sb);

        sb.replace(0, 15,"Talha Rahman opp --->");
        System.out.println(sb);
    }
}

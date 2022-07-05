public class practice {

    public static void main(String[] args) {
        int[] num1 = {6,7,8};
        int[] num2 = {6,7,8};
        boolean alpha = compareArray(num1,num2);
        System.out.println(alpha);
    }


    public static boolean compareArray(int[] arr1, int[] arr2){
      
        if(arr1.length != arr2.length){
            return false;
        }
        
        else{
            int n = arr1.length;
  
            for(int i=0; i<n; i++){

                if(arr1[i] != arr2[i]){
                return false;
                }
            
            }
        }
        return true;
    }    
    
}
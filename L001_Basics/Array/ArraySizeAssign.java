public class ArraySizeAssign {

    public static void main(String[] args) {
     
        int[] arr1 = new int[50];
        int[] arr2 = new int[30];
        // it will resize the array : arr2 will get the size of arr1;
        
        arr2=arr1;
        int val1 = arr2[29];
        int val2 = arr2[49];
        
        
        System.out.println(val1);
        System.out.println(val2);
    }
    

}

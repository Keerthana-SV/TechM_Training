import java.util.Arrays;
import java.util.Objects;

public class EqualsVsDeepEquals {
    public static void main(String[] args) {
       
        int[][] array1 = {{1, 2}, {3, 4}};
        int[][] array2 = {{1, 2}, {3, 4}};
        
       
        System.out.println("Using equals(): " + Arrays.equals(array1, array2)); // false
        
     
        System.out.println("Using deepEquals(): " + Arrays.deepEquals(array1, array2)); // true

      
        String str1 = new String("Hello");
        String str2 = new String("Hello");

        System.out.println("Using equals() on Strings: " + Objects.equals(str1, str2)); 
        System.out.println("Using deepEquals() on Strings: " + Objects.deepEquals(str1, str2));

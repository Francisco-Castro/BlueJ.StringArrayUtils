//
import java.lang.*;
import java.util.*;
import java.util.stream.Stream;
import java.util.function.Predicate;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        System.out.print('\u000C');
        return Arrays.asList(array).contains( value );
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        System.out.print('\u000C');
        System.out.println( Arrays.toString(array) );
        List<String> newList = Arrays.asList(array);
        Collections.reverse( newList );
        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        //System.out.print('\u000C');
        //System.out.println( "Original array: " + Arrays.toString(array) );
        //System.out.println( array );
        String [] cloneArray = Arrays.copyOf(array, array.length); // Clone original array
        List<String> newList = Arrays.asList(cloneArray); // Converting original array to list
        //System.out.println( "List:" + newList );
        Collections.reverse( newList ); //Reverse list
        //System.out.println( "Reverted: " +  newList );
        //System.out.println( Arrays.toString(cloneArray) );
        String[] dummy = newList.toArray(new String[0]);
        //System.out.println( dummy );
        //System.out.println( dummy.equals(cloneArray) );
        Boolean result = dummy.equals(cloneArray);
        //Boolean result = dummy == cloneArray;
        return Arrays.toString(array).equals(Arrays.toString(dummy));
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
       System.out.print('\u000C');
       String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
       String str = String.join(",",array);
       System.out.println( str );       
       str = str.replaceAll("," , "").toLowerCase();
       Boolean flag = true;
       for(String s : alphabet ){ 
           if( str.contains(s) == true){ flag = true; }
           else{ flag = false; break; }
           //System.out.println( s + " - " + str.contains(s) );
       }
       //System.out.println("Flag: " + flag);

       return flag;
    }

    
    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
       System.out.print('\u000C');
       Integer counter = 0;
       for( String s : array){
           //System.out.println( "R: " + counter + " " + value + " - " + s + " - " + s.equals(value) );
           if(s.equals(value)){ counter++;};
       }
       return counter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
       System.out.print('\u000C');
       Integer counter = 0;
       String[] newArray = new String[ array.length ];
       for( String s : array){
           if(!s.equals(valueToRemove)){newArray[counter] = s;}
           counter++;
       }
       return Arrays.stream(newArray).filter(Objects::nonNull).toArray(String[]::new);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
       System.out.print('\u000C');
       Integer counter = 0;
       String[] newArray = new String[ array.length ];
       String dummy = "";
       for( String s : array){
           if(!s.equals( dummy )){newArray[counter] = s;}
           counter++;
           dummy = s;
       }        
       return Arrays.stream(newArray).filter(Objects::nonNull).toArray(String[]::new);
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        System.out.print('\u000C');
        String container = array[0];
        String dummy = array[0];
        String[] dummyArray = new String[array.length];
        for( int i = 1; i < array.length; i++){
            if( dummy.equals(array[i]) ){
                container += array[i];
            }
            else{
                dummyArray[i-1] = container;
                container = array[i];
            }
            dummy = array[i];
        }
        dummyArray[dummyArray.length-1] = container;
        return Arrays.stream(dummyArray).filter(Objects::nonNull).toArray(String[]::new);
    }


}

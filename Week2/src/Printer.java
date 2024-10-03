/**
 * Created by abbyr on 03/10/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public class Printer
{
   public static void main(String[] args){
      Integer[] intArray = {1, 2, 3};
      String[] stringArray = {"one", "two", "three"};
      printArray(intArray);
      printArray(stringArray);
   }

   public static <T> void printArray(T[] arr){
      for(T element : arr) System.out.println(element);
      /*abbreviated version of for loop
      where element will take on all values of the array (arr)
       */

   }
}//class

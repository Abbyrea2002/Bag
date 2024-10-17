/**
 * Created by abbyr on 03/10/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public interface BagInterface<T>
{


   public int getCurrentSize();
   /* the  number of elements currently contained in the bag

   @return - (int) number of elements
    */
   public boolean isEmpty();
   /* test for an empty bag

   @return - (boolean) true if the number og elements is zero, false otherwise
    */

   public boolean addNewEntry(T newEntry);
   /* test for spare capacity in the bag and if it exits, add the elements
   and increment the number of elements in the bag

   @param (t) newEntry - the item to be added to the bag
   @return - (boolean) true if the item is added, false otherwise
    */

   public T remove();
   /* remove any elemet from the bag, if one is avail, and decrement the number
   of elements. Return the remove element or null if none is avail
    */

   public boolean remove(T anEntry);
   /* remove the specified element from the bag, if it is present, and decrement
   the number og elements
    */

   public void clear();
   /* empty the bag - set the number of elements to zero
    */

   public int getFrequencyOf(T anEntry);
   /* count how many times a given element appears in the bag
   @param (T) anEntry - the element to look for in the bag
   @return - (int) the number  of times that the given element appears
    */

   public boolean contains(T anEntry);
   /* check for the presence of a specified element in the bag
   @param (T) anEntry - the item to look for in the bag
   @return - (boolean) true if the bag contains the element, false otherwise
    */

   public T[] toArray();
   /* find all the elements in the bag

   @return - (T[]) an array of the size of the elements, containing all contents of the bag
    */
   public void display();
   /* displays linked bag and array bag using recursion
    */
}

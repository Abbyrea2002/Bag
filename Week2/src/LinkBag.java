/**
 * Created by abbyr on 08/10/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public final class LinkBag<T>
{
   private MyNode<T> firstnode;
   private int numberOfEntries;

   private MyNode<T> findEntry(T anEntry){
      MyNode<T> currentNode = firstnode;
      boolean found = false;
      while(!found && currentNode != null){
         if(currentNode.getData().equals(anEntry)) found = true;
         else currentNode = currentNode.getNext();
      }
      if(found) return currentNode;else return null;
   }

   public LinkBag(){
      firstnode = null;
      numberOfEntries = 0;
   }
   public int getCurrentSize()
   {
   /* the  number of elements currently contained in the bag
   @return - (int) number of elements
    */
      return numberOfEntries;
   }
   public boolean isEmpty()
   {
   /* test for an empty bag

   @return - (boolean) true if the number og elements is zero, false otherwise
    */
      return (numberOfEntries == 0);
   }

   public boolean addNewEntry(T newEntry)
   {
   /* test for spare capacity in the bag and if it exits, add the elements
   and increment the number of elements in the bag
   @param (t) newEntry - the item to be added to the bag
   @return - (boolean) true if the item is added, false otherwise
    */
      MyNode<T> newNode = new MyNode<T>(newEntry);
      newNode.setNext(firstnode);
      firstnode = newNode;
      numberOfEntries++;
      return true;
   }

   public T remove()
   {
   /* remove any elemet from the bag, if one is avail, and decrement the number
   of elements. Return the remove element or null if none is avail
    */
      if(firstnode != null){
         T result = firstnode.getData();
         firstnode = firstnode.getNext();
         numberOfEntries--;
         return result;
      }else return null;
   }

   public boolean remove(T anEntry)
   {
   /* remove the specified element from the bag, if it is present, and decrement
   the number og elements
    */
      MyNode<T> nodeToRemove = findEntry(anEntry);
      if(nodeToRemove == null) return false;
      nodeToRemove.setData(firstnode.getData());
      firstnode = firstnode.getNext();
      numberOfEntries--;
      return true;
   }

   public void clear()
   {
      /* empty the bag - set the number of elements to zero
       */
      firstnode = null;
      numberOfEntries = 0;
   }

   public int getFrequencyOf(T anEntry)
   {
   /* count how many times a given element appears in the bag
   @param (T) anEntry - the element to look for in the bag
   @return - (int) the number  of times that the given element appears
    */
      int count = 0;
      MyNode<T> currentNode = firstnode;
      while(currentNode != null){
         if(currentNode.getData().equals(anEntry)) count++;
         currentNode = currentNode.getNext();
      }
      return count;
   }

   public boolean contains(T anEntry)
   {
   /* check for the presence of a specified element in the bag
   @param (T) anEntry - the item to look for in the bag
   @return - (boolean) true if the bag contains the element, false otherwise
    */
      MyNode<T> currenNode = firstnode;
      boolean found = false;
      while(!found && currenNode != null){
         if(currenNode.getData().equals(anEntry)) found = true;
         currenNode = currenNode.getNext();
      }

      return found;
   }

   public T[] toArray()
   {
   /* find all the elements in the bag
   @return - (T[]) an array of the size of the elements, containing all contents of the bag
    */
      T[] resultArray = (T[]) new Object[numberOfEntries];
      int index = 0;
      MyNode<T> currentNode = firstnode;
      while(currentNode != null){
         resultArray[index++] = currentNode.getData();
         currentNode = currentNode.getNext();
      }
      return resultArray;
   }

   public String toString(){
      MyNode<T> currentNode = firstnode;
      String result = "Bag[ ";
      while(currentNode != null){
         result += currentNode.getData() + "";
         currentNode = currentNode.getNext();
      }
      result += "]";
      return result;
   }

}//class

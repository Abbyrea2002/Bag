/**
 * Created by abbyr on 03/10/2024
 * COMMENTS ABOUT PROGRAM HERE
 */
public final class ArrayBag<T> implements BagInterface<T>
{
   private T[] bag;
   private int numberOfEntries;
   private static final int DEFAULT_CAPACITY = 25;
   private boolean initialised = false;
   private static final int MAX_CAPACITY = 10000;

   private boolean isArrayFull(){
      return(bag.length == numberOfEntries);
   }

   private void checkInitilisation(){
      if(!initialised)
         throw new SecurityException("ArrayBag object is not initialised properly");
   }

   private T removeElementAt(int index){
      T result = null;
      if(!isEmpty() && index >= 0 && index < numberOfEntries)
      {
         result = bag[index];
         bag[index] = bag[numberOfEntries - 1];
         bag[numberOfEntries - 1] = null;
         numberOfEntries--;
      }
      return result;
   }

   public ArrayBag(){
      this(DEFAULT_CAPACITY);
   }

   public ArrayBag(int capacity){
      if(capacity <= MAX_CAPACITY){
      T[] tempBag = (T[]) new Object[capacity];
      bag = tempBag;
      numberOfEntries = 0;
      initialised = true;
      }else throw new IllegalStateException("Attempt  to create a bag where the capacity exceeds maximum");

   }

   public int getCurrentSize(){
      return numberOfEntries;

   }

   public boolean isEmpty(){
      return (numberOfEntries == 0);

   }

   public boolean addNewEntry(T newEntry){
      checkInitilisation();
      if (isArrayFull())return false;
      else{
         bag[numberOfEntries++] = newEntry;
         return true;
      }
   }

   public T remove(){
      checkInitilisation();

      return removeElementAt(numberOfEntries - 1);

   }

   public boolean remove(T anEntry){
      boolean found = false;
      int index = 0;
      while(!found && index < numberOfEntries)
         if(bag[index].equals(anEntry)) found = true;
         else index++;
      if (found) removeElementAt(index);
      return found;
   }

   public void clear(){
      while(!isEmpty()) remove();

   }


   public int getFrequencyof(T anEntry){
      int count = 0 ;
      for(int i; i < numberOfEntries; i++)
        if(bag[i].equals(anEntry)) count++;
      return count;
   }

   public boolean contains(T anEntry){
      boolean found = false;
      int index = 0;
      while(!found &&  index < numberOfEntries)
         if(bag[index++].equals(anEntry)) found = true;
      return found;

   }

   public T[] toArray(){
      T[] resultArray = (T[]) new Object[numberOfEntries];
      System.arraycopy(bag, 0, resultArray, 0, numberOfEntries );
      return resultArray;
   }

   public static void main(String[] args){
      ArrayBag<String> bagOfNames = new ArrayBag<String>(5);

      System.out.println("Adding Abby..... " + bagOfNames.addNewEntry("Abby"));
      System.out.println("Adding meredith..... " + bagOfNames.addNewEntry("meredith"));
      System.out.println("Adding sheldon..... " + bagOfNames.addNewEntry("sheldon"));

      Object[] arrayOfNames = bagOfNames.toArray();
      for(Object name : arrayOfNames) System.out.print(name + "...");
      System.out.println();

      System.out.println("Adding Aaron..... " + bagOfNames.addNewEntry("Aaron"));
      System.out.println("Adding Steph..... " + bagOfNames.addNewEntry("Steph"));
      System.out.println("Adding Simba..... " + bagOfNames.addNewEntry("Simba"));

      Object[] arrayOfNames2 = bagOfNames.toArray();
      for(Object name : arrayOfNames2) System.out.print(name + "...");
      System.out.println();
   }
}//class

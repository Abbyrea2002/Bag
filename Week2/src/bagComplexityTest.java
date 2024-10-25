import java.util.Random;



public class bagComplexityTest {

    public static void main(String[] args){

        LinkBag<Integer> testLinkBag = new LinkBag<>();
        Random random = new Random();

        System.out.println("LinkedBag Performance Analysis (time in ns)");
        System.out.println("-------------------------------------------");
        System.out.printf("%20s %20s %20s %20s %20s%n", "Bag size", "Total time to add","avg time to add", "Total time to remove", "avg time to remove ");
        int[] testValues = { 10, 100, 1000, 10000, 100000};

        for(int n : testValues ){
            long startTimeAdding = System.nanoTime();
            for(int i = 0; i < n; i++){
                int randomValue = random.nextInt(n * 10);
                testLinkBag.addNewEntry(randomValue);
            }
            long endTimeAdding = System.nanoTime();
            long totalTimeAdding = endTimeAdding - startTimeAdding;
            long avgAdding = totalTimeAdding / n;
            long bagSize = testLinkBag.getCurrentSize();

            long startTimeRemoving = System.nanoTime();
            for(int i = 0; i < n; i++){
                int randomValue = random.nextInt(n * 10);
                testLinkBag.remove();
            }
            long endTimeRemoving = System.nanoTime();
            long totalTimeRemoving = endTimeRemoving - startTimeRemoving;
            long avgRemoving = totalTimeRemoving / n;



            System.out.printf("%20s %20s %20s %20s %20s%n", bagSize , totalTimeAdding, avgAdding, totalTimeRemoving, totalTimeRemoving);
        }








    }
}

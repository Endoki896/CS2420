package assignments.assign05;

import java.util.ArrayList;

public class SortTimer {
    public static void main(String[] args)
    {
        int maxSize = 200000;
        int increment = 10000;
        int loopCount = 100;

        ArrayList<Double> averageTimes = new ArrayList<>();

        /*System.out.println("Begin mergesort runtime collection...");
        // mergesort testing
        for(int i = increment; i <= maxSize; i += increment)
        {
            warmUp();
            ArrayList<Integer> testList;
            System.out.println("collecting from " + i + " items...");
            long start = System.nanoTime();
            for(int j = 0; j < loopCount; j++)
            {
                testList = ArrayListSorter.generateDescending(i);
                ArrayListSorter.mergesort(testList);
            }
            long end = System.nanoTime();
            for(int j = 0; j < loopCount; j++)
            {
                testList = ArrayListSorter.generateDescending(i);
            }
            long extra = System.nanoTime();

            averageTimes.add(((end - start) - (extra - end)) / (loopCount + 0.0));
        }
        System.out.println("Mergesort time collection finished:");
        for(Double time : averageTimes)
        {
            System.out.println(time);
        }

        averageTimes.clear();//*/

        System.out.println("Begin quicksort runtime collection...");
        // quicksort testing
        for(int i = increment * 11; i <= maxSize; i += increment)
        {
            warmUp();
            ArrayList<Integer> testList;
            System.out.println("collecting from " + i + " items...");

            long start = System.nanoTime();
            for(int j = 0; j < loopCount; j++)
            {
                testList = ArrayListSorter.generateDescending(i);
                ArrayListSorter.quicksort(testList);
            }
            long end = System.nanoTime();
            for(int j = 0; j < loopCount; j++)
            {
                testList = ArrayListSorter.generateDescending(i);
            }
            long extra = System.nanoTime();

            averageTimes.add(((end - start) - (extra - end)) / (loopCount + 0.0));
        }
        System.out.println("Quicksort runtime collection finished:");
        for(Double time : averageTimes)
        {
            System.out.println(time);
        }
    }

    public static void warmUp()
    {
        long start = System.nanoTime();
        while(System.nanoTime() - start < 1_000_000_000);
    }
}

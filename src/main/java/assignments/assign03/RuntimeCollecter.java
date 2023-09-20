package assignments.assign03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RuntimeCollecter {
    public static void main(String[] args)
    {
        double[] averageRuntimes = new double[20];
        double curAverage = 0;
        long start, end;
        SimplePriorityQueue<Integer> testQueue = new SimplePriorityQueue<>();

        for(int i = 1000; i <= 20000; i += 1000)
        {
            addIn(testQueue, i);
            System.out.print("Warming system...");
            warmup();
            System.out.print(" Done!\nStarting test " + (i / 1000) + " of 20...");
            for(int j = 0; j < 100; j++)
            {
                start = System.nanoTime();
                testQueue.insert(i + 1);
                end = System.nanoTime();
                curAverage = curAverage == 0 ? end - start : (curAverage + (end - start)) / 2.0;
                testQueue.deleteMax();
            }
            System.out.println(" Done!");
            averageRuntimes[(i / 1000) - 1] = curAverage;
            curAverage = 0;
        }
        System.out.println("Runtime collection finished!");
        for(double time : averageRuntimes)
            System.out.println(time);
    }

    public static void addIn(SimplePriorityQueue<Integer> queue, int amount)
    {
        //Random rng = new Random();
        List<Integer> intList = new ArrayList<>();
        for(int i = amount - 1; i >= queue.size(); i--)
            intList.add(i);
        queue.insertAll(intList);
    }

    public static void warmup()
    {
        long time = 0;
        long last = System.nanoTime();
        while(time < 3 * 1E9)
        {
            time += System.nanoTime() - last;
            last = System.nanoTime();
        }
    }
}

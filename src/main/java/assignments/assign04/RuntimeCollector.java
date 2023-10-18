package assignments.assign04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RuntimeCollector {
    public static void main(String[] args)
    {
        double[] averageRuntimes = new double[20];
        double curAverage = 0;
        long start, end;
        int increment = 1000;
        List<Integer[]> testList;

        for(int n = increment; n <= increment * 20; n += increment)
        {
            testList = buildTestList(n);
            System.out.print("Warming system...");
            warmup();
            System.out.print(" Done!\nStarting test " + (n / increment) + " of 20...");
            for(int j = 0; j < 100; j++)
            {
                start = System.nanoTime();
                LargestNumberSolver.findKthLargest(testList, 0);
                end = System.nanoTime();
                curAverage = curAverage == 0 ? end - start : (curAverage + (end - start)) / 2.0;
            }
            System.out.println(" Done!");
            averageRuntimes[(n / increment) - 1] = curAverage;
            curAverage = 0;
        }
        System.out.println("Runtime collection finished!");
        for(double time : averageRuntimes)
            System.out.println(time);
    }

    public static List<Integer[]> buildTestList(int size)
    {
        Random rng = new Random();
        List<Integer[]> output = new ArrayList<>();
        for(int i = 0; i < size; i++)
        {
            Integer[] arr = new Integer[rng.nextInt(2, 7)];
            for(int j = 0; j < arr.length; j++)
                arr[j] = rng.nextInt(100);
            output.add(arr);
        }

        return output;
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

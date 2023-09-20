package labs.lab04;

import java.util.Arrays;
import java.util.Random;

public class PairProgamingPractice {
    public static void main(String[] args)
    {
        Random rand = new Random();
        Integer[] arr = new Integer[10];
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = rand.nextInt(20);
        }
        
        System.out.println(Arrays.toString(arr));
        System.out.println(getMedian(arr));
    }

    public static <T> void printArrayRange(T[] arr, int start, int stop)
    {
        String print = start == 0 ? "[" : "[...,";
        for(int i = start; i <= stop; i++)
        {
            print += arr[i].toString() + (i != stop ? ", " : "");
        }
        print += stop == arr.length - 1 ? "]" : ", ...]";
        System.out.println(print);
    }

    public static <T extends Comparable<T>> void sort(T[] arr)
    {
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i].compareTo(arr[i - 1]) >= 0) continue;
        }
    }
    
    public static <T extends Comparable<T>> int binarySearchRange(T[] arr, T target, int start, int end)
    {
        int low = start, high = end, mid = (low + high) / 2;
        while(low < high)
        {
            mid = (low + high) / 2;
            if(arr[mid].compareTo(target) == 0)
                return mid;
            else if (arr[mid].compareTo(target) < 0) high = mid - 1;
            else low = mid + 1;
        }

        return mid;
    }

    public static <T extends Comparable<T>> T getMedian(T[] arr)
    {
        sort(arr);
        return arr[arr.length / 2];
    }
}

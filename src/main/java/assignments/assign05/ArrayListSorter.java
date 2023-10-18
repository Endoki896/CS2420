package assignments.assign05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ArrayListSorter {

    /**
     * Mergesort algorithm
     * @param list the list to be sorted
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list)
    {
        if(list.size() <= 1) return;
        ArrayList<T> storage = new ArrayList<>(list.size());
        for(int i = 0; i < list.size(); i++)
            storage.add(null);
        mergesort(list, 0, list.size(), storage);
    }

    private static <T extends Comparable<? super T>> void mergesort(ArrayList<T> list, int lower, int upper, ArrayList<T> storage)
    {
        if(upper - lower > 1)
        {
            int mid = (lower + upper) / 2;
            mergesort(list, lower, mid, storage);
            mergesort(list, mid, upper, storage);
            merge(list, lower, mid, upper, storage);
        }
    }

    private static <T extends Comparable<? super T>> void merge(ArrayList<T> list, int lower, int mid, int upper, ArrayList<T> storage)
    {
        for(int i = lower; i < upper; i++)
            storage.set(i, list.get(i));

        int i = lower, j = mid;
        int index = lower;
        while(i < mid && j < upper)
        {
            if(storage.get(i).compareTo(storage.get(j)) < 0)
            {
                list.set(index, storage.get(i++));
            } else {
                list.set(index, storage.get(j++));
            }
            index++;
        }

        while(i < mid)
            list.set(index++, storage.get(i++));

        while(j < upper)
            list.set(index++, storage.get(j++));
    }

    /**
     * Quicksort algorithm
     * @param list the list to be sorted
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list)
    {
        if(list.size() < 2) return;
        if(list.size() < 3)
        {
            if(list.get(0).compareTo(list.get(1)) > 0) swap(list, 0, 1);
            return;
        }
        quicksort(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<? super T>> void quicksort(ArrayList<T> list, int lower, int upper)
    {
        if(upper - lower > 1)
        {
            int pivot = partition(list, lower, upper);

            quicksort(list, lower, pivot);
            quicksort(list, pivot, upper);
        }
    }

    private static <T extends Comparable<? super T>> int partition(ArrayList<T> list, int lower, int upper)
    {
        int pivot = getPivotMedianOfThree(list, lower, upper);
        swap(list, upper, pivot);
        pivot = upper;
        upper--;

        while(lower < upper)
        {
            while(list.get(lower).compareTo(list.get(pivot)) <= 0 && lower < upper)
                lower++;
            while(list.get(upper).compareTo(list.get(pivot)) > 0 && lower < upper)
                upper--;
            if(list.get(lower).compareTo(list.get(upper)) > 0 && lower < upper) swap(list, lower, upper);
        }
        swap(list, lower, pivot);
        return lower;
    }

    private static <T> void swap(List<T> list, int l, int u)
    {
        T tmp = list.get(l);
        list.set(l, list.get(u));
        list.set(u, tmp);
    }

    // Should give a constant runtime behavior
    private static <T extends Comparable<? super T>> int getPivotMedianOfThree(ArrayList<T> list, int from, int to)
    {
        int mid = (from + to) / 2;
        if(list.get(from).compareTo(list.get(mid)) + list.get(from).compareTo(list.get(to)) == 0)
            return from;
        if(list.get(to).compareTo(list.get(from)) + list.get(to).compareTo(list.get(mid)) == 0)
            return to;
        else return mid;
    }

    private static <T> int getPivotListMedian(ArrayList<T> list, int l, int u)
    {
        return (l + u) / 2;
    }

    private static Random rng;

    private static <T> int getPivotRandom(ArrayList<T> list, int l, int u)
    {
        if(rng == null) rng = new Random();
        return rng.nextInt(l, u + 1);
    }

    /**
     * Generates an ArrayList of Integers in ascending order
     * @param size the size of the ArrayList
     * @return
     */
    public static ArrayList<Integer> generateAscending(int size)
    {
        ArrayList<Integer> output = new ArrayList<>(size);
        for(int i = 1; i <= size; i++)
            output.add(i);
        return output;
    }

    /**
     * Generates an ArrayList of Integers from 1-size randomly ordered
     * @param size the size of the ArrayList
     * @return
     */
    public static ArrayList<Integer> generatePermuted(int size)
    {
        ArrayList<Integer> output = generateAscending(size);
        Collections.shuffle(output);
        return output;
    }

    /**
     * Generates an ArrayList of Integers from 1-size in Descending order
     * @param size the size of the ArrayList
     * @return
     */
    public static ArrayList<Integer> generateDescending(int size)
    {
        ArrayList<Integer> output = new ArrayList<>(size);
        for(int i = size; i > 0; i--)
            output.add(i);
        return output;
    }
}

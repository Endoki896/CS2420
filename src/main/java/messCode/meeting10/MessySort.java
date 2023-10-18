package messCode.meeting10;

import java.util.Arrays;
import java.util.Comparator;

public class MessySort {
    // Merge sort

    public static <T> void mergeSort(T[] arr, Comparator<? super T> cmp)
    {
        if(cmp == null) throw new IllegalArgumentException("Must input a comparator");
        mergeSort(arr, 0, arr.length, cmp);
    }

    private static <T> void mergeSort(T[] arr, int lower, int upper, Comparator<? super T> cmp)
    {
        if(upper - lower > 1)
        {
            int mid = (lower + upper) / 2;
            mergeSort(arr, lower, mid, cmp);
            mergeSort(arr, mid, upper, cmp);
            merge(arr, lower, mid, upper, cmp);
        }
    }

    private static <T> void merge(T[] arr, int lower, int mid, int upper, Comparator<? super T> cmp)
    {
        // compute lower array into higher array
        T[] l = Arrays.copyOfRange(arr, lower, mid);
        T[] u = Arrays.copyOfRange(arr, mid, upper);

        int i = 0, j = 0;
        int index = lower;
        while(i < l.length && j < u.length)
        {
            if(cmp.compare(l[i], u[j]) < 0)
            {
                arr[index] = l[i++];
            } else {
                arr[index] = u[j++];
            }
            index++;
        }

        while(i < l.length)
        {
            arr[index] = l[i];
            i++;
            index++;
        }

        while(j < u.length)
        {
            arr[index] = u[j];
            j++;
            index++;
        }
    }

    // Quick sort

    public static <T> void quickSort(T[] arr, Comparator<? super T> cmp)
    {
        if(cmp == null) throw new IllegalArgumentException("Must input a comparator");
    }

    private static <T> void partition(T[] arr, int lower, int mid, int upper, Comparator<? super T> cmp)
    {
        int pivot = median(arr, lower, mid, upper, cmp);
        T hand = arr[pivot];
        arr[pivot] = arr[upper];
        arr[upper] = hand;

        while(cmp.compare(arr[lower], arr[upper]) <= 0)
            lower++;
        while(cmp.compare(arr[upper], arr[pivot]) > 0)
            upper--;
        swap(arr, pivot, lower);
    }

    private static <T> void swap(T[] arr, int pivot, int lower)
    {}

    private static <T> int median(T[] arr, int lower, int mid, int upper, Comparator<? super T> cmp)
    {
        if(cmp.compare(arr[lower], arr[mid]) < 0 && cmp.compare(arr[mid], arr[upper]) < 0 ||
                (cmp.compare(arr[upper], arr[mid]) <= 0 && cmp.compare(arr[mid], arr[lower]) <= 0)) return mid;
        if((cmp.compare(arr[mid], arr[lower]) < 0 && cmp.compare(arr[lower], arr[upper]) < 0) ||
                (cmp.compare(arr[upper], arr[lower]) < 0 && cmp.compare(arr[lower], arr[mid]) < 0)) return lower;
        if(cmp.compare(arr[lower], arr[upper]) < 0 && cmp.compare(arr[upper], arr[mid]) < 0 ||
                (cmp.compare(arr[mid], arr[upper]) < 0 && cmp.compare(arr[upper], arr[lower]) < 0)) return upper;
        return mid;
    }
}

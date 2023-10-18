package assignments.assign05;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListSorterTest {

    @Test
    void testMerge() {
        ArrayList<Integer> testInts = new ArrayList<>(Arrays.asList(4, 8, 0, 64, 27, 94, 76));
        ArrayListSorter.mergesort(testInts);
        assertTrue(listIsSorted(testInts));
    }

    @Test
    void testMergeSmall() {
        ArrayList<Integer> testInts = new ArrayList<>(Arrays.asList(1, 0));
        ArrayListSorter.mergesort(testInts);
        assertTrue(listIsSorted(testInts));
    }

    @Test
    void testMergeBulk() {
        ArrayList<Integer> testInts = ArrayListSorter.generatePermuted(100);
        ArrayListSorter.mergesort(testInts);
        assertTrue(listIsSorted(testInts));
    }

    @Test
    void testQuick() {
        ArrayList<Integer> testInts = new ArrayList<>(Arrays.asList(4, 8, 0, 64, 27, 94, 76));
        ArrayListSorter.quicksort(testInts);
        assertTrue(listIsSorted(testInts));
    }

    @Test
    void testQuickSmall() {
        ArrayList<Integer> testInts = new ArrayList<>(Arrays.asList(1, 0));
        ArrayListSorter.quicksort(testInts);
        assertTrue(listIsSorted(testInts));
    }

    @Test
    void testQuickBulk() {
        ArrayList<Integer> testInts = ArrayListSorter.generatePermuted(100);
        ArrayListSorter.quicksort(testInts);
        assertTrue(listIsSorted(testInts));
    }

    @Test
    void testQuickSame() {
        ArrayList<Integer> testInts = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 2));
        ArrayListSorter.quicksort(testInts);
        assertTrue(listIsSorted(testInts));
    }

    @Test
    void testGenerateAscending()
    {
        assertTrue(listIsSorted(ArrayListSorter.generateAscending(10)));
    }

    @Test
    void testGeneratePermuted()
    {
        assertFalse(listIsSorted(ArrayListSorter.generatePermuted(10)));
    }

    @Test
    void testGenerateDescending()
    {
        assertFalse(listIsSorted(ArrayListSorter.generateDescending(10)));
    }

    static <T extends Comparable<? super T>> boolean listIsSorted(List<T> list)
    {
        for(int i = 0; i < list.size() - 1; i++)
        {
            if(list.get(i).compareTo(list.get(i + 1)) > 0)
            {
                System.err.println(list);
                return false;
            }
        }
        return true;
    }
}
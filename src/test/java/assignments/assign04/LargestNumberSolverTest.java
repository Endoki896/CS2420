package assignments.assign04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*
 * Assignment: 4
 * @Author: Adarsh Sreeram & Stewart Russell
 * @Version: 09/21/2023
 */
class LargestNumberSolverTest {
    /*
     * Instance variables: intArr, longArr, bigArr
     */
    Integer[] intArr;
    Integer[] longArr;
    Integer[] bigArr;

    @BeforeEach
    void init()
    {
        intArr = new Integer[]{23, 5, 36, 8, 1};// largest num = 8,536,231
        longArr = new Integer[]{32, 32, 82, 99, 91, 11, 817, 93};
        bigArr = new Integer[]{410, 21, 93, 80, 69, 379, 20, 60, 432, 13, 72, 62, 70, 83, 9, 3, 14, 11, 62, 55, 34, 83, 80, 99, 56, 25, 79, 51, 51, 70, 79, 20, 34, 67, 40, 51, 41, 94, 89, 116, 874, 554, 137, 371, 17, 77, 97, 58, 83, 97, 26, 17, 54, 96, 33};
    }
    /*
     * findLargestNumberTest method that checks if the largest number in an array is correct
     */
    @Test
    void findLargestNumberTest()
    {
        assertEquals(new BigInteger("8536231"), LargestNumberSolver.findLargestNumber(intArr));
    }
    //findLargestIntTest that checks if the largest number in an array is correct
    @Test
    void findLargestIntTest()
    {
        assertEquals(8536231, LargestNumberSolver.findLargestInt(intArr));
    }
    //findLargestIntExceptionTest that checks if the right exception is thrown
    @Test
    void findLargestIntExceptionTest()
    {
        assertThrows(OutOfRangeException.class, () -> LargestNumberSolver.findLargestInt(bigArr));
    }
    //findLargestLongTest that checks if the largest long number in an array is correct
    @Test
    void findLargestLongTest()
    {
        assertEquals(8536231L, LargestNumberSolver.findLargestLong(intArr));
    }
    //findLargestLongExceptionTest that checks if the right exception is thrown
    @Test
    void findLargestLongExceptionTest()
    {}

    <T> void print(T[] arr)
    {
        StringBuilder sb = new StringBuilder();
        for(T item : arr)
            sb.append(item.toString() +(item.equals(arr[arr.length - 1]) ? "" : ", "));
        System.out.println(sb);
    }
    //testFindKthLargest test method that checks if the kth largest number in a list of arrays is correct
    @Test
    void testFindKthLargest() {
        List<Integer[]> sampleList = new ArrayList<>();
        sampleList.add(new Integer[]{3, 1, 4, 1, 5, 9, 2, 6});// 96543211
        sampleList.add(new Integer[]{5, 3, 5});// 553

        assertTrue(Arrays.equals(LargestNumberSolver.findKthLargest(sampleList, 0), sampleList.get(0))); // First largest
        assertTrue(Arrays.equals(LargestNumberSolver.findKthLargest(sampleList, 1), sampleList.get(1))); // Second largest
        assertThrows(IllegalArgumentException.class, () -> LargestNumberSolver.findKthLargest(sampleList, 2)); // Third largest DNE
    }
    //testBigSum test method that checks if the sum of the largest numbers in a list of arrays is correct
    @Test
    void testBigSum() {
        // Normal cases
        BigInteger sum = LargestNumberSolver.sum(Arrays.asList(new Integer[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}}));
        assert sum.equals(BigInteger.valueOf(54321 + 987610)) : "Expected: " + (54321 + 987610) + "\nResult: " + sum;

    }
    //readFileTest method that checks if the file is read correctly
    @Test
    void readFileTest()
    {
        String path = new File("drop/integers.txt").getAbsolutePath();
        List<Integer[]> list = LargestNumberSolver.readFile(path);
        assertEquals(list.get(0)[0], 410);
    }
}
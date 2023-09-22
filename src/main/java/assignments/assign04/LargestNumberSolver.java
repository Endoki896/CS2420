package assignments.assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

/*
 * Assignment: 4
 * @Version: 09/20/2023
 * @Author: Adarsh Sreeram & Stewart Russell
 */
public class LargestNumberSolver {
    /*
     * customComparator: Finds the largest number by comparing two numbers
     * @return: returns the largest number in the list
     */
    public static Comparator<Integer> customComparator = (Integer x, Integer y) -> {
        String xy = x.toString() + y.toString();
        String yx = y.toString() + x.toString();
        return yx.compareTo(xy);
    };

    /*
     * @param: arr: an array of integers, cmp: a comparator
     * @return: void
     */
    public static <T> void insertionSort(T[] arr, Comparator<? super T> cmp) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && cmp.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /*
     * findLargestNumber method that finds the largest number in an array
     * @param: arr: an array of integers
     * @return: BigInteger that is the largest number in an array
     */
    public static BigInteger findLargestNumber(Integer[] arr) {
        if (arr.length == 0) return BigInteger.ZERO;

        insertionSort(arr, customComparator);

        StringBuilder sb = new StringBuilder();
        for (Integer num : arr) {
            sb.append(num);
        }

        return new BigInteger(sb.toString());
    }

    /*
     * findLargestNumber method that finds the largest number in an array
     * @param: arr: an array of integers
     * @return: bigNum(BigInteger)
     * @throws: OutOfRangeException
     */
    public static int findLargestInt(Integer[] arr) throws OutOfRangeException
    {
        BigInteger bigNum = findLargestNumber(arr);
        if(bigNum.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0 ||
                bigNum.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0) {
            throw new OutOfRangeException("int");
        }

        return bigNum.intValue();
    }
    /*
     * findLargestLong method that finds the largest number in an array
     * @param: arr: an array of integers
     * @return: bigNum(BigInteger) long value
     * @throws: OutOfRangeException
     */
    public static long findLargestLong(Integer[] arr) throws OutOfRangeException
    {
        BigInteger bigNum = findLargestNumber(arr);
        if(bigNum.bitCount() > 64) throw new OutOfRangeException("long");
        return bigNum.longValue();

    }
    /*
     * findKthLargest method that finds the kth largest number in an array
     * @param: list: a list of arrays of integers, k: an integer
     * @return: an array of integers
     * @throws: IllegalArgumentException if k is not a valid position in the list.
     */
    public static Integer[] findKthLargest(List<Integer[]> list, int k) throws IllegalArgumentException {
        if (k < 0 || k >= list.size()) {
            throw new IllegalArgumentException("k is not a valid position in the list.");
        }

        Comparator<Integer[]> customComparator = (arr1, arr2) -> {
            BigInteger num1 = findLargestNumber(arr1);
            BigInteger num2 = findLargestNumber(arr2);
            return num2.compareTo(num1);
        };
        Integer[][] sortList = list.toArray(new Integer[list.size()][]);
        insertionSort(sortList, customComparator);

        return sortList[k];
    }

    /*
     * sum method that finds the sum of all the largest numbers in a list of arrays
     * @param: list: a list of arrays of integers
     * @return: totalSum which is a bigInteger
     */
    public static BigInteger sum(List<Integer[]> list)
    {
        List<Integer[]> deepCopyList = new ArrayList<>();
        for (Integer[] arr : list) {
            Integer[] arrCopy = Arrays.copyOf(arr, arr.length);
            deepCopyList.add(arrCopy);
        }
        BigInteger totalSum = BigInteger.ZERO;
        for (Integer[] arr : deepCopyList) {
            BigInteger largestNumber = findLargestNumber(arr);
            totalSum = totalSum.add(largestNumber);
        }
        return totalSum;
    }

    /*
     * readFile method that reads a file and returns a list of arrays of integers
     * @param: filename: the name of the file to be read
     * @return: a list of arrays of integers
     */
    public static List<Integer[]> readFile(String filename)
    {
        File src = new File(filename);
        try {
            Scanner sc = new Scanner(src);
            List<Integer[]> output = new ArrayList<>();

            while(sc.hasNextLine())
            {
                String[] line = sc.nextLine().split(" ");
                Integer[] arr = new Integer[line.length];
                for(int i = 0; i < line.length; i++)
                {
                    arr[i] = Integer.parseInt(line[i]);
                }
                output.add(arr);
            }

            return output;
        } catch(FileNotFoundException e)
        {
            return new ArrayList<>();
        }
    }
}

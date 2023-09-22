package assignments.assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class LargestNumberSolver {

    public static <T> void insertionSort(T[] arr, Comparator<? super T> cmp)
    {
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

    public static BigInteger findLargestNumber(Integer[] arr)
    {
        if (arr.length == 0) return BigInteger.ZERO;

        insertionSort(arr, (Integer x, Integer y) -> {
            String xy = x.toString() + y.toString();
            String yx = y.toString() + x.toString();
            return yx.compareTo(xy);
        });

        StringBuilder sb = new StringBuilder();
        for (Integer num : arr) {
            sb.append(num);
        }

        return new BigInteger(sb.toString());
    }

    public static int findLargestInt(Integer[] arr) throws OutOfRangeException
    {
        BigInteger bigNum = findLargestNumber(arr);
        if(bigNum.bitCount() > 32) throw new OutOfRangeException("int");
        return bigNum.intValue();
    }

    public static long findLargestLong(Integer[] arr) throws OutOfRangeException
    {
        BigInteger bigNum = findLargestNumber(arr);
        if(bigNum.bitCount() > 64) throw new OutOfRangeException("long");
        return bigNum.intValue();
    }

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

    public static BigInteger sum(List<Integer[]> list)
    {
        BigInteger totalSum = BigInteger.ZERO;
        for (Integer[] arr : list) {
            BigInteger largestNumber = findLargestNumber(arr);
            totalSum = totalSum.add(largestNumber);
        }

        return totalSum;
    }

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

            sc.close();

            return output;
        } catch(FileNotFoundException e)
        {
            return new ArrayList<>();
        }
    }
}

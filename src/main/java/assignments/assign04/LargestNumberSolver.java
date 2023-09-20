package assignments.assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class LargestNumberSolver {

    public static <T> void insertionSort(T[] arr, Comparator<? super T> cmp)
    {
        if(arr.length == 0) return;
        for(int i = 1; i < arr.length; i++)
        {
            if(cmp.compare(arr[i], arr[i - 1]) >= 0) continue;
            T tmp = arr[i];
            for(int j = i; j > 0; j--)
            {
                if(cmp.compare(arr[j], tmp) < 0)
                    arr[j] = arr[j - 1];
                else {
                    arr[j] = tmp;
                    tmp = null;
                    break;
                }
            }
            if(tmp != null) arr[0] = tmp;
        }
    }

    public static BigInteger findLargestNumber(Integer[] arr)
    {
        Integer[] safeCopy = Arrays.copyOf(arr, arr.length);
        Comparator<Integer> cmp = (a, b) -> (a.toString() + b.toString()).compareTo(b.toString() + a.toString());
        insertionSort(safeCopy, cmp);
        StringBuilder bigNum = new StringBuilder();
        for(Integer i : safeCopy)
            bigNum.append(i);
        return new BigInteger(bigNum.toString());
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

    public static BigInteger sum(List<Integer[]> list)
    {
        return new BigInteger("0");
    }

    public static Integer[] findKthLargest(List<Integer[]> list, int k)
    {
        return new Integer[]{};
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

            return output;
        } catch(FileNotFoundException e)
        {
            return new ArrayList<>();
        }
    }
}

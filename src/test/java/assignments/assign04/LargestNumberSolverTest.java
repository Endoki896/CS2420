package assignments.assign04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestNumberSolverTest {

    Integer[] intArr;
    Integer[] longArr;
    Integer[] bigArr;

    @BeforeEach
    void init()
    {
        intArr = new Integer[]{23, 5, 36, 8, 1};// largest num = 8,536,231
        longArr = new Integer[]{32, 32, 82, 99, 91, 11, 817, 93};
    }

    @Test
    void findLargestNumberTest()
    {
        assertEquals(new BigInteger("8536231"), LargestNumberSolver.findLargestNumber(intArr));
    }

    @Test
    void findLargestIntTest()
    {
        assertEquals(8536231, LargestNumberSolver.findLargestInt(intArr));
    }

    @Test
    void findLargestIntExceptionTest()
    {}

    @Test
    void findLargestLongTest()
    {
        assertEquals(8536231L, LargestNumberSolver.findLargestLong(intArr));
    }

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

    @Test
    void testFindKthLargest() {
        List<Integer[]> file = LargestNumberSolver.readFile("integers.txt");
        print(file.get(0));
        assert Arrays.equals(new Integer[]{299, 95, 6, 62, 78, 87, 97, 27, 443, 100, 11, 55, 27, 78, 245, 89, 470, 2, 39, 75, 422, 676, 42, 78, 77, 48, 76, 28, 92, 610, 64, 94, 1362, 3, 16, 29, 749, 64, 89, 6, 41, 836, 83, 24, 18, 47, 90, 42, 52, 87, 70, 68, 78, 38, 76, 16, 18, 27, 84, 34, 28, 5, 12, 490, 24, 92, 11, 42, 19, 60, 73, 43, 14, 35, 99, 3, 39, 27, 5, 93, 53, 23, 25, 90, 65, 37, 75, 88, 21, 90, 28, 6, 55, 15, 57, 8, 48, 836, 39},
                LargestNumberSolver.findKthLargest(file.subList(0, 10), 2));

        assertEquals(1, LargestNumberSolver.findKthLargest(file.subList(0, 1), 1));

        assertEquals(1, LargestNumberSolver.findKthLargest(file.subList(3, 12), 3));
    }

    public static void testBigSum() {
        // Normal cases
        assert LargestNumberSolver.sum(Arrays.asList(new Integer[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}})).equals(BigInteger.valueOf(54321 + 987610));
        /*assert bigSum(new int[]{-1, -2, -3, -4, -5}) == -15;
        assert bigSum(new int[]{1, -2, 3, -4, 5}) == 3;

        // Edge cases
        assert bigSum(new int[]{0, 0, 0, 0}) == 0;
        assert bigSum(new int[]{42}) == 42;
        assert bigSum(new int[]{}) == 0;

        // Side cases
        assert bigSum(new int[]{3, 3, 3, 3, 3}) == 15;
        assert bigSum(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}) == 4294967294L; // Long sum needed*/
    }

    @Test
    void readFileTest()
    {
        String path = new File("drop/integers.txt").getAbsolutePath();
        List<Integer[]> list = LargestNumberSolver.readFile(path);
        assertEquals(list.get(0)[0], 410);
    }
}
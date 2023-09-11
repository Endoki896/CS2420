package labs.lab01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DiffUtilTest {

    @Test
    public void testAllSameNum() {
        int[] arr = {3, 3, 3};
        assertEquals(0, DiffUtil.findSmallestDiff(arr));
    }

    @Test
    public void testNegAndPos()
    {
        int[] arr = {52, 4, -8, 0, -17};
        assertEquals(4, DiffUtil.findSmallestDiff(arr));
    }

    @Test
    public void testTooSmallArray()
    {
        int[] arr = new int[0];
        assertThrows(IllegalArgumentException.class, () -> DiffUtil.findSmallestDiff(arr));
    }

    @Test
    public void testRunTime()
    {
        double aveTime = 0.0;
        int[] arr = {-3, 9, 100, 45, 99, 105};
        for(int i = 0; i < 100; i++)
        {
            long timeStart = System.nanoTime();
            DiffUtil.findSmallestDiff(arr);
            long timeEnd = System.nanoTime();
            aveTime = aveTime == 0 ? (timeEnd - timeStart) : (aveTime + (timeEnd - timeStart)) / 2.0;
        }
        assert (aveTime < 3000): "Time limit exceeded\nExpected: 3000ns\nResult: " + aveTime + "ns";
    }
}
package assignments.assign04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigInteger;
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

    @Test
    void readFileTest()
    {
        String path = new File("drop/integers.txt").getAbsolutePath();
        List<Integer[]> list = LargestNumberSolver.readFile(path);
        assertEquals(list.get(0)[0], 410);
    }
}
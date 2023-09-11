package messCode.meeting03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArrayReverserTest {

    @Test
    void testReverseArray() {
        int[] fibArray = {1, 1, 2, 3, 5, 8};
        int[] expectedReversed = {8, 5, 3, 2, 1, 1};

        ArrayReverser.reverseArray(fibArray);
        for (int i = 0; i < fibArray.length; i++) {
            assertEquals(fibArray[i], expectedReversed[i]);
        }
    }

    @Test
    void testReverseArrayList() {
        ArrayList<Integer> fibArrayList = new ArrayList<Integer>();
        fibArrayList.add(1);
        fibArrayList.add(1);
        fibArrayList.add(2);
        fibArrayList.add(3);
        fibArrayList.add(5);
        fibArrayList.add(8);
        int[] expectedReversed = {8, 5, 3, 2, 1, 1};

        ArrayReverser.reverseArrayList(fibArrayList);
        for (int i = 0; i < fibArrayList.size(); i++) {
            assertEquals(fibArrayList.get(i), expectedReversed[i]);
        }
    }
}
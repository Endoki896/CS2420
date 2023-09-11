package messCode.meeting04.arrayListBuilder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListBuilderTest {

    int[] intArray;
    String[] strArray;
    Point[] pointArray;

    @BeforeEach
    void setup() {
        intArray = new int[] {1, 3, 5, 7, 9};
        strArray = new String[] {"oh, hi", "how are you?", "i'm okay", "thanks"};
        pointArray = new Point[] {
                new Point(1, 2),
                new Point(-3, 1),
                new Point(5, 5)
        };
    }

    @Test
    void testIntArrayList() {
        ArrayList<Integer> arrayList = ArrayListBuilder.fromArray(intArray);
        for (int i=0; i < intArray.length; i++) {
            assertEquals(intArray[i], arrayList.get(i));
        }
    }

    @Test
    void testStrArrayList() {
        ArrayList<String> arrayList = ArrayListBuilder.fromArray(strArray);
        for (int i=0; i < strArray.length; i++) {
            assertTrue(strArray[i].equals(arrayList.get(i)));
        }
    }

    @Test
    void testPointArrayList() {
        ArrayList<Point> arrayList = ArrayListBuilder.fromArray(pointArray);
        for (int i=0; i < pointArray.length; i++) {
            assertTrue(pointArray[i].equals(arrayList.get(i)));
        }
    }
}
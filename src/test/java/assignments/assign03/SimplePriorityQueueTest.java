package assignments.assign03;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SimplePriorityQueueTest {

    private static int size = 10;

    private static Integer[] testPrims = {
            0,
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
    };
    private static String[] testStrings = {
            "Add",
            "Apple",
            "Kerplunk",
            "Meanie",
            "Nah",
            "Shdonk",
            "Shop",
            "Tuvnicker",
            "Vindicate",
            "Zombie",
    };
    private static Object[] testObjects = {};

    private static SimplePriorityQueue<Integer> queuePrim;
    private static SimplePriorityQueue<String> queueString;
    private static SimplePriorityQueue<Object> queueObj;

    @BeforeAll
    static void setUp()
    {
        // initialize all queues
        queuePrim = new SimplePriorityQueue<>();
        queueString = new SimplePriorityQueue<>();
        queueObj = new SimplePriorityQueue<>();

        // insert test variables
        queuePrim.insertAll(arrayToList(testPrims));
        queueString.insertAll(arrayToList(testStrings));
        queueObj.insertAll(arrayToList(testObjects));
    }

    // helper
    static <T> List<T> arrayToList(T[] array)
    {
        List<T> output = new ArrayList<>();
        Collections.addAll(output, array);
        return output;
    }

    // not reliant on specific variable types

    @Test
    void size() {
        assertEquals(size, queuePrim.size());
    }

    @Test
    void isEmpty() {
        assertFalse(queuePrim.isEmpty());
        assertTrue(new SimplePriorityQueue<Integer>().isEmpty());
    }

    @Test
    void clear() {
        SimplePriorityQueue<Integer> clearTest = new SimplePriorityQueue<>();
    }

    @Test
    void getFromEmpty()
    {
        SimplePriorityQueue<Integer> queue = new SimplePriorityQueue<>();

        assertThrows(NoSuchElementException.class, queue::findMax);
        assertThrows(NoSuchElementException.class, queue::deleteMax);
    }

    // with primitive vars

    @Test
    void findMaxPrim() {

    }

    @Test
    void deleteMaxPrim() {
    }

    @Test
    void insertPrim() {
    }

    @Test
    void insertAllPrim() {
    }

    @Test
    void containsPrim() {
    }

    // with Strings

    @Test
    void findMaxString() {
    }

    @Test
    void deleteMaxString() {
    }

    @Test
    void insertString() {
    }

    @Test
    void insertAllString() {
    }

    @Test
    void containsString() {
    }

    // with objects

    @Test
    void findMaxObj() {
    }

    @Test
    void deleteMaxObj() {
    }

    @Test
    void insertObj() {
    }

    @Test
    void insertAllObj() {
    }

    @Test
    void containsObj() {
    }
}
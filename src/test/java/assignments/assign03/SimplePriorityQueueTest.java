package assignments.assign03;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SimplePriorityQueueTest {

    private static int size = 16;

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

    @BeforeEach
    void setUp()
    {
        // initialize all queues
        queuePrim = new SimplePriorityQueue<>();
        queueString = new SimplePriorityQueue<>();
        //queueObj = new SimplePriorityQueue<>();

        // insert test variables
        queuePrim.insertAll(arrayToList(testPrims));
        queueString.insertAll(arrayToList(testStrings));
        // queueObj.insertAll(arrayToList(testObjects));
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
    void isEmpty()
    {
        assertFalse(queuePrim.isEmpty());
        assertTrue(new SimplePriorityQueue<Integer>().isEmpty());
    }

    @Test
    void clear()
    {
        SimplePriorityQueue<Integer> clearTest = new SimplePriorityQueue<>();
        clearTest.insertAll(Arrays.asList(1, 3, 4, 7, 8));
        clearTest.clear();
        assertTrue(clearTest.isEmpty());
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
        int test = 9;
        assertEquals(test, queuePrim.findMax());
    }

    @Test
    void deleteMaxPrim() {
        int test = 9;
        int finalTest = 8;
        assertEquals(test, queuePrim.deleteMax());
        assertEquals(finalTest, queuePrim.findMax());  // The next maximum should be 8 after 9 is deleted
    }

    @Test
    void insertPrim() {
        queuePrim.insert(10);
        int test = 10;
        assertEquals(test, queuePrim.findMax());  // Now, 10 should be the maximum
    }

    @Test
    void insertAllPrim() {
        List<Integer> newList = Arrays.asList(11, 12, 13);
        queuePrim.insertAll(newList);
        assertEquals(Integer.valueOf(13), queuePrim.findMax());  // The maximum should now be 13
    }

    @Test
    void containsPrim() {
        assertTrue(queuePrim.contains(3));
        assertFalse(queuePrim.contains(10));
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
package assignments.assign03;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

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
    private static Person[] testSubjects = {
            new Person(40, "Bruce Wane"),
            new Person(26, "Barry Allen"),
            new Person(40, "Clark Kent"),
            new Person(18, "Peter Parker"),
            new Person(40, "Tony Stark"),
            new Person(40, "Bruce Banner"),
            new Person(1500, "Thor Odinson"),
            new Person(5000, "Diana Prince"),
            new Person(30, "Wanda Maximoff"),
            new Person(53, "Clint Barton"),
            new Person(179, "Steve Rodgers"),
    };

    private static SimplePriorityQueue<Integer> queuePrim;
    private static SimplePriorityQueue<String> queueString;
    private static SimplePriorityQueue<Person> queueObj;
    private static SimplePriorityQueue<Person> queueCom;

    @BeforeEach
    void setUp()
    {
        // initialize all queues
        queuePrim = new SimplePriorityQueue<>();
        queueString = new SimplePriorityQueue<>();
        queueObj = new SimplePriorityQueue<>();
        queueCom = new SimplePriorityQueue<>((a, b) -> a.name.compareTo(b.name));

        // insert test variables
        queuePrim.insertAll(arrayToList(testPrims));
        queueString.insertAll(arrayToList(testStrings));
        queueObj.insertAll(arrayToList(testSubjects));
        queueCom.insertAll(arrayToList(testSubjects));
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
        assertEquals("Zombie", queueString.findMax());
    }

    @Test
    void deleteMaxString() {
        assertEquals("Zombie", queueString.deleteMax());
        assertEquals("Vindicate",queueString.findMax());
    }

    @Test
    void insertString() {
        queueString.insert("Zute");
        assertEquals("Zute",queueString.findMax());
    }

    @Test
    void insertAllString() {
        List<String> newString = Arrays.asList("Alpha","Beta");
        queueString.insertAll(newString);
        assertTrue(queueString.contains("Alpha"));
        assertTrue(queueString.contains("Beta"));
        assertEquals("Zombie", queueString.findMax());
    }

    @Test
    void containsString() {
        //False test case for queueString
        assertFalse(queueString.contains("Omega"));
        //True test case for queueString
        assertTrue(queueString.contains("Zombie"));
    }

    // with objects
    // default
    @Test
    void findMaxObj() {
        assertEquals(new Person(5000, "Diana Prince"), queueObj.findMax());
        assertNotEquals(new Person(18, "Peter Parker"), queueObj.findMax());
    }

    @Test
    void deleteMaxObj() {
        assertEquals(new Person(5000, "Diana Prince"), queueObj.deleteMax());
        assertEquals(new Person(1500, "Thor Odinson"), queueObj.findMax());
    }

    @Test
    void insertObj() {
        queueObj.insert(new Person(35, "Jack White"));
        assertTrue(queueObj.contains(new Person(35, "Jack White")));
    }

    @Test
    void insertAllObj() {
        List<Person> subjectList = Arrays.asList(new Person(62, "Eduardo Dorrance"), new Person(56, "Norman Osborn"), new Person(1000, "Thanos"));
        queueObj.insertAll(subjectList);
        assertTrue(queueObj.contains(new Person(62, "Eduardo Dorrance")));
        assertTrue(queueObj.contains(new Person(56, "Norman Osborn")));
        assertTrue(queueObj.contains(new Person(1000, "Thanos")));
    }

    @Test
    void containsObj() {
        assertTrue(queueObj.contains(new Person(179, "Steve Rodgers")));
    }

    // comparator
    @Test
    void findMaxCom() {
        assertEquals(new Person(30, "Wanda Maximoff"), queueCom.findMax());
        assertNotEquals(new Person(1500, "Thor Odinson"), queueCom.findMax());
    }

    @Test
    void deleteMaxCom() {
        assertEquals(new Person(30, "Wanda Maximoff"), queueCom.deleteMax());
        assertEquals(new Person(40, "Tony Stark"), queueCom.findMax());
    }

    @Test
    void insertCom() {
        queueCom.insert(new Person(35, "Jack White"));
        assertTrue(queueCom.contains(new Person(35, "Jack White")));
    }

    @Test
    void insertAllCom() {
        List<Person> subjectList = Arrays.asList(new Person(62, "Eduardo Dorrance"), new Person(56, "Norman Osborn"), new Person(1000, "Thanos"));
        queueCom.insertAll(subjectList);
        assertTrue(queueCom.contains(new Person(62, "Eduardo Dorrance")));
        assertTrue(queueCom.contains(new Person(56, "Norman Osborn")));
        assertTrue(queueCom.contains(new Person(1000, "Thanos")));
    }

    @Test
    void containsCom() {
        assertTrue(queueCom.contains(new Person(179, "Steve Rodgers")));
    }

    static class Person implements Comparable<Person> {

        public int age;
        public String name;

        public Person(int age, String name)
        {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }

        @Override
        public boolean equals(Object o)
        {
            if(!(o instanceof Person)) return false;

            Person other = (Person) o;

            return other.age == this.age && this.name.equals(other.name);
        }

        @Override
        public String toString()
        {
            return this.name + ", " + this.age;
        }
    }
}
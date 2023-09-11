package messCode.meeting03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodOverloadingTest {

    @Test
    void testSumTwoInt() {
        int a = 5;
        int b = 7;
        int sum = MethodOverloading.sum(a, b);
        assertEquals(sum, 12);
    }

    @Test
    void testSumThreeInt() {
        int a = 5;
        int b = 7;
        int c = -2;
        int sum = MethodOverloading.sum(a, b, c);
        assertEquals(sum, 10);
    }

    @Test
    void testSumTwoShort() {
        short a = 5;
        short b = 7;
        int sum = MethodOverloading.sum(a, b);
        assertEquals(sum, 12);
    }

    @Test
    void testSumArray() {
        int [] array = {3, 6, 7, -11, 20};
        int sum = MethodOverloading.sum(array);
        assertEquals(sum, 25);
    }
}
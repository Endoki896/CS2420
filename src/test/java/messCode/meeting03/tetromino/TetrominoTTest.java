package messCode.meeting03.tetromino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TetrominoTTest {

    public TetrominoT t;

    public Point[] expectedT = new Point[4];
    public Point[] expectedTright = new Point[4];
    public Point[] expectedTleft = new Point[4];
    public Point[] expectedTdown = new Point[4];
    public Point[] expectedTrotate1 = new Point[4];
    public Point[] expectedTrotate2 = new Point[4];
    public Point[] expectedTrotate3 = new Point[4];

    @BeforeEach
    void setup() {
        t = new TetrominoT();

        expectedT[0] = new Point(0, 1);
        expectedT[1] = new Point(1, 1);
        expectedT[2] = new Point(2, 1);
        expectedT[3] = new Point(1, 2);

        expectedTright[0] = new Point(1, 1);
        expectedTright[1] = new Point(2, 1);
        expectedTright[2] = new Point(3, 1);
        expectedTright[3] = new Point(2, 2);

        expectedTleft[0] = new Point(-1, 1);
        expectedTleft[1] = new Point(0, 1);
        expectedTleft[2] = new Point(1, 1);
        expectedTleft[3] = new Point(0, 2);

        expectedTdown[0] = new Point(0, 2);
        expectedTdown[1] = new Point(1, 2);
        expectedTdown[2] = new Point(2, 2);
        expectedTdown[3] = new Point(1, 3);

        expectedTrotate1[0] = new Point(1, 0);
        expectedTrotate1[1] = new Point(1, 1);
        expectedTrotate1[2] = new Point(1, 2);
        expectedTrotate1[3] = new Point(0, 1);

        expectedTrotate2[0] = new Point(2, 1);
        expectedTrotate2[1] = new Point(1, 1);
        expectedTrotate2[2] = new Point(0, 1);
        expectedTrotate2[3] = new Point(1, 0);

        expectedTrotate3[0] = new Point(1, 2);
        expectedTrotate3[1] = new Point(1, 1);
        expectedTrotate3[2] = new Point(1, 0);
        expectedTrotate3[3] = new Point(2, 1);
    }

    @Test
    void testTLeft() {
        t.moveLeft();
        assertTrue(Arrays.equals(t.getSquares(), expectedTleft));
    }

    @Test
    void testTRight() {
        t.moveRight();
        assertTrue(Arrays.equals(t.getSquares(), expectedTright));
    }

    @Test
    void testTDown() {
        t.moveDown();
        assertTrue(Arrays.equals(t.getSquares(), expectedTdown));
    }

    @Test
    void testTCw() {
        t.rotateCW();
        assertTrue(Arrays.equals(t.getSquares(), expectedTrotate1));
    }

    @Test
    void testTCcw() {
        t.rotateCCW();
        assertTrue(Arrays.equals(t.getSquares(), expectedTrotate3));
    }

    @Test
    void testTCwCw() {
        t.rotateCW();
        t.rotateCW();
        assertTrue(Arrays.equals(t.getSquares(), expectedTrotate2));
    }

    @Test
    void testTCcwCcw() {
        t.rotateCCW();
        t.rotateCCW();
        assertTrue(Arrays.equals(t.getSquares(), expectedTrotate2));
    }

    @Test
    void testTCwCwCw() {
        t.rotateCW();
        t.rotateCW();
        t.rotateCW();
        assertTrue(Arrays.equals(t.getSquares(), expectedTrotate3));
    }

    @Test
    void testTCcwCcwCcw() {
        t.rotateCCW();
        t.rotateCCW();
        t.rotateCCW();
        assertTrue(Arrays.equals(t.getSquares(), expectedTrotate1));
    }

    @Test
    void testTCwCwCwCw() {
        t.rotateCW();
        t.rotateCW();
        t.rotateCW();
        t.rotateCW();
        assertTrue(Arrays.equals(t.getSquares(), expectedT));
    }

    @Test
    void testTCcwCcwCcwCcw() {
        t.rotateCCW();
        t.rotateCCW();
        t.rotateCCW();
        t.rotateCCW();
        assertTrue(Arrays.equals(t.getSquares(), expectedT));
    }
}
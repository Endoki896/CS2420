package messCode.meeting03.tetromino;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TetrominoSTest {

    public TetrominoS s;

    public Point[] expectedS = new Point[4];
    public Point[] expectedSright = new Point[4];
    public Point[] expectedSleft = new Point[4];
    public Point[] expectedSdown = new Point[4];
    public Point[] expectedSrotate = new Point[4];

    @BeforeEach
    void setup() {
        s = new TetrominoS();

        expectedS[0] = new Point(0, 2);
        expectedS[1] = new Point(1, 2);
        expectedS[2] = new Point(1, 1);
        expectedS[3] = new Point(2, 1);

        expectedSright[0] = new Point(1, 2);
        expectedSright[1] = new Point(2, 2);
        expectedSright[2] = new Point(2, 1);
        expectedSright[3] = new Point(3, 1);

        expectedSleft[0] = new Point(-1, 2);
        expectedSleft[1] = new Point(0, 2);
        expectedSleft[2] = new Point(0, 1);
        expectedSleft[3] = new Point(1, 1);

        expectedSdown[0] = new Point(0, 3);
        expectedSdown[1] = new Point(1, 3);
        expectedSdown[2] = new Point(1, 2);
        expectedSdown[3] = new Point(2, 2);

        expectedSrotate[0] = new Point(2, 2);
        expectedSrotate[1] = new Point(2, 1);
        expectedSrotate[2] = new Point(1, 1);
        expectedSrotate[3] = new Point(1, 0);

    }

    @Test
    void testSRight() {
        s.moveRight();
        assertTrue(Arrays.equals(s.getSquares(), expectedSright));
    }

    @Test
    void testSLeft() {
        s.moveLeft();
        assertTrue(Arrays.equals(s.getSquares(), expectedSleft));
    }

    @Test
    void testSDown() {
        s.moveDown();
        assertTrue(Arrays.equals(s.getSquares(), expectedSdown));
    }

    @Test
    void testSCw() {
        s.rotateCW();
        assertTrue(Arrays.equals(s.getSquares(), expectedSrotate));
    }

    @Test
    void testSCcw() {
        s.rotateCCW();
        assertTrue(Arrays.equals(s.getSquares(), expectedSrotate));
    }

    @Test
    void testSCwCw() {
        s.rotateCW();
        s.rotateCW();
        assertTrue(Arrays.equals(s.getSquares(), expectedS));
    }

    @Test
    void testSCcwCcw() {
        s.rotateCCW();
        s.rotateCCW();
        assertTrue(Arrays.equals(s.getSquares(), expectedS));
    }
}
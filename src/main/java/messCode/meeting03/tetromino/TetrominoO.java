package messCode.meeting03.tetromino;

import java.awt.*;

/**
 * This object represents the O-tetromino.
 *
 * 		 01
 * 		+--+
 * 	  0	|##|
 * 	  1	|##|
 * 		+--+
 * 		0		(orientation)
 *
 * @author Stewart Russell
 * @version 2023-08-29
 */
public class TetrominoO extends Tetromino {

    public TetrominoO()
    {
        super();
        this.squares[0] = new Point(0, 0);
        this.squares[1] = new Point(1, 0);
        this.squares[2] = new Point(0, 1);
        this.squares[3] = new Point(1, 1);
    }

    @Override
    public void rotateCW()
    {}

    @Override
    public void rotateCCW()
    {}
}

package messCode.meeting03.tetromino;

import java.awt.Point;

/**
 * This object represents the S-tetromino.
 * 
 * 		 012	  012
 * 		+---+	 +---+
 * 	  0 |   |    | # |
 * 	  1 | ##| -> | ##|
 * 	  2 |## |    |  #|
 * 		+---+    +---+
 * 		0		 1		(orientation)
 * 
 * @author Aaron Wood
 * @version 2023-08-29
 */
public class TetrominoS extends Tetromino{
	
	/**
	 * Constructs a new S-tetromino with default initial values.
	 */
	public TetrominoS() {
		super();
		this.squares[0] = new Point(0, 2);
		this.squares[1] = new Point(1, 2);
		this.squares[2] = new Point(1, 1);
		this.squares[3] = new Point(2, 1);
	}
	
	/**
	 * Rotate the tetromino clockwise based on orientation.
	 * Note that `this.squares[2]` stays in the same position.
	 */
	@Override
	public void rotateCW() {
		switch (orientation) {
			case 0 -> {
				this.squares[0].translate(2, 0);
				this.squares[1].translate(1, -1);
				this.squares[3].translate(-1, -1);
				this.orientation = 1;
			}
			case 1 -> {
				this.squares[0].translate(-2, 0);
				this.squares[1].translate(-1, 1);
				this.squares[3].translate(1, 1);
				this.orientation = 0;
			}
			default -> 
				throw new IllegalArgumentException("invalid orientation");
		}
	}
	
	/**
	 * Rotate the tetromino counter-clockwise based on orientation.
	 */
	@Override
	public void rotateCCW() {
		rotateCW();
	}
}

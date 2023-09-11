package messCode.meeting03.tetromino;

import java.awt.Point;

/**
 * This object represents the T-tetromino.
 * 
 * 		 012      012      012      012
 * 		+---+	 +---+ 	  +---+	   +---+
 * 	  0	|   |    | # |    | # |    | # |
 * 	  1	|###| -> |## | -> |###| -> | ##|
 * 	  2	| # |    | # |    |   |    | # |
 * 		+---+    +---+    +---+    +---+
 * 		0		 1		  2		   3		(orientation)
 * 
 * @author Aaron Wood
 * @version 2023-08-29
 */
public class TetrominoT extends Tetromino {
	
	public TetrominoT() {
		super();
		this.squares[0] = new Point(0, 1);
		this.squares[1] = new Point(1, 1);
		this.squares[2] = new Point(2, 1);
		this.squares[3] = new Point(1, 2);
	}
	
	/**
	 * Rotate the tetromino clockwise.
	 *   - `this.squares[1]` is the pivot point for the rotation.
	 *   - `this.orientation` increases by 1 modulo 4.
	 */
	@Override
	public void rotateCW() {
		int pivotX = this.squares[1].x;
		int pivotY = this.squares[1].y;
		for (Point p : this.squares) {
			int newX = pivotX + pivotY - p.y;
			int newY = -pivotX + pivotY + p.x;
			p.x = newX;
			p.y = newY;
		}
		this.orientation = (byte)(this.orientation + 1 % 4);
	}

	/**
	 * Rotate the tetromino counter-clockwise.
	 *   - `this.squares[1]` is the pivot point for the rotation.
	 *   - `this.orientation` decreases by 1 modulo 4 (same as +3 module 4).
	 */
	@Override
	public void rotateCCW() {
		int pivotX = this.squares[1].x;
		int pivotY = this.squares[1].y;
		for (Point p : this.squares) {
			int newX = pivotX - pivotY + p.y;
			int newY = pivotX + pivotY - p.x;
			p.x = newX;
			p.y = newY;
		}
		this.orientation = (byte)(this.orientation + 3 % 4);
	}
}

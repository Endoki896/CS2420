package messCode.meeting04.shape;

import java.awt.Point;

/**
 * Object representing a square in the plane.
 * 
 * Exercise: implement missing methods.
 * 
 * @author Aaron Wood
 * @version 2023-08-31
 */
public class Square extends Rectangle {
	public Square(Point lowerLeft, int width) {
		super(lowerLeft, width, width);
	}
}

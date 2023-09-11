package messCode.meeting04.shape;

import java.awt.Point;

/**
 * Object representing a rectangle in the plane.
 * 
 * Exercise: implement missing methods.
 * 
 * @author Aaron Wood
 * @version 2023-08-31
 */
public class Rectangle extends Shape {
	private int width, height;

	public Rectangle(Point lowerLeft, int width, int height) {
		super(new Point[] {
			lowerLeft,
			new Point(lowerLeft.x + width, lowerLeft.y),
			new Point(lowerLeft.x, lowerLeft.y + height),
			new Point(lowerLeft.x + width, lowerLeft.y + height)
		});
		this.width = width;
		this.height = height;
	}

	@Override
	public double perimeter()
	{
		return 2 * (width + height);
	}

	@Override
	public double area()
	{
		return width * height;
	}
}

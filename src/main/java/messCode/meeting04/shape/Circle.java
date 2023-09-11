package messCode.meeting04.shape;

import java.awt.Point;

/**
 * Object representing a circle in the plane.
 * 
 * @author Aaron Wood
 * @version 2023-08-31
 */
public class Circle extends Shape {
	private Point center;
	private double radius;
	
	public Circle(Point center, double radius) {
		super(new Point[] {center});
		this.center = center;
		this.radius = radius;
	}

	@Override
	public double perimeter()
	{
		return radius * (2 * Math.PI);
	}

	@Override
	public double area()
	{
		return Math.PI * radius * radius;
	}
}

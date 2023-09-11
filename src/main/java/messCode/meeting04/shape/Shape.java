package messCode.meeting04.shape;

import java.awt.Point;

/**
 * Abstract class representing a shape in the plane.
 * 
 * Exercise: implement missing methods.
 * 
 * @author Aaron Wood
 * @version 2023-08-31
 */
public abstract class Shape 
	implements PlanarMotion, PlanarGeometry 
{
	// The important points for the shape.
	protected Point[] points;
	
	public Shape(Point[] points) {
		this.points = points;
	}

	@Override
	public void translate(int dx, int dy)
	{
		for(Point point : points)
		{
			point.translate(dx, dy);
		}
	}
}

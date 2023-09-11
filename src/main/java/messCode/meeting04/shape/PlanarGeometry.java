package messCode.meeting04.shape;

/**
 * Interface for geometry of objects in a plane.
 * 
 * @author Aaron Wood
 * @version 2023-08-31
 */
public interface PlanarGeometry {
	/**
	 * Compute the perimeter of a planar object.
	 * @return
	 */
	abstract public double perimeter();
	
	/**
	 * Compute the area of a planar object.
	 * @return
	 */
	abstract public double area();
}

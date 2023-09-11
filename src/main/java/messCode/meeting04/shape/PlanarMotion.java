package messCode.meeting04.shape;

/**
 * Interface for motion of objects in a plane.
 * 
 * @author Aaron Wood
 * @version 2023-08-31
 */
public interface PlanarMotion {
	/**
	 * Translate planar object dx along x-axis and dy along y-axis.
	 * @param dx
	 * @param dy
	 */
	abstract public void translate(int dx, int dy);
}

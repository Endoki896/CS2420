package messCode.meeting04.orchard;

import java.awt.Point;
import java.util.Date;

/**
 * Object representing an orchard.
 * 
 * @author Aaron Wood and Stewart Russell
 * @version 2023-08-31
 */
public class Orchard implements Comparable<Orchard> {
	private String fruit;
	private int treeCount;
	private Point location;
	private Date foundedAt;
	
	public Orchard(String fruit, int treeCount, Point location, Date foundedAt) {
		this.fruit = fruit;
		this.treeCount = treeCount;
		this.location = location;
		this.foundedAt = foundedAt;
	}
	
	public String getFruit()
	{
		return this.fruit;
	}

	public int getTreeCount()
	{
		return this.treeCount;
	}

	public Point getLocation()
	{
		return this.location;
	}

	public Date getFoundedAt()
	{
		return this.foundedAt;
	}

	@Override
	public int compareTo(Orchard o) {
		return this.fruit.compareTo(o.fruit);
	}
}

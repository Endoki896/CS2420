package messCode.meeting04.set;

import java.util.ArrayList;

/**
 * Class to represent a set of integers.
 * Note that elements of a set must be unique.
 * 
 * Exercise #1: implement the following methods
 * 		- public boolean includes(Integer element)
 * 		- public boolean add(Integer element)
 * 		- public boolean remove(Integer element)
 * 
 * Exercise #2: convert to a generic class for sets of any objects.
 * 
 * @author Aaron Wood and Stewart Russell
 * @version 2023-08-31
 *
 */
public class Set<T> {
	private ArrayList<T> data;
	
	public Set() {
		this.data = new ArrayList<T>();
	}
	
	/**
	 * Compute the number of elements in the set.
	 * @return
	 */
	public int size() {
		return this.data.size();
	}
	
	/**
	 * Determine whether an element is a member of the set.
	 * @param element
	 * @return {@code true} if element is a member of the set
	 */
	public boolean includes(T element)
	{
		return this.data.contains(element);
	}
	
	/**
	 * Add an element to the set, if possible.
	 *   - If element is not a member, add it and return {@code true}
	 *   - If element is a member, do nothing and return {@code true}
	 * @param element
	 * @return {@code true} if element was added to the set
	 */
	public boolean add(T element)
	{
		if(this.includes(element)) return false;
		this.data.add(element);
		return true;
	}
	
	/**
	 * Remove an element from the set, if possible.
	 *   - If element is a member, remove it and return {@code true}
	 *   - If element is not a member, do nothing and return {@code false}
	 * @param element
	 * @return {@code true} if element was removed from the set
	 */
	public boolean remove(T element)
	{
		if(!this.includes(element)) return false;
		this.data.remove(element);
		return true;
	}

}

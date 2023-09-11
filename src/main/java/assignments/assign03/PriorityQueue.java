package assignments.assign03;

import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * A priority queue that supports access of the maximum element only.
 *
 * @author Aaron Wood
 * @version 2023-09-07
 *
 * @param <E> - the type of elements contained in this priority queue
 */
public interface PriorityQueue<E> {

	/**
	 * Retrieves, but does not remove, the maximum element in this priority
	 * queue.
	 *
	 * @return the maximum element
	 * @throws NoSuchElementException if the priority queue is empty
	 */
	public E findMax() throws NoSuchElementException;

	/**
	 * Retrieves and removes the maximum element in this priority queue.
	 *
	 * @return the maximum element
	 * @throws NoSuchElementException if the priority queue is empty
	 */
	public E deleteMax() throws NoSuchElementException;

	/**
	 * Inserts the specified element into this priority queue.
	 *
	 * @param item - the element to insert
	 */
	public void insert(E item);

	/**
	 * Inserts the specified elements into this priority queue.
	 *
	 * @param coll - the collection of elements to insert
	 */
	public void insertAll(Collection<? extends E> coll);

	/**
	 * Indicates whether this priority queue contains the specified element.
	 *
	 * @param item - the element to be checked for containment in this priority queue
	 */
	public boolean contains(E item);

	/**
	 * @return the number of elements in this priority queue
	 */
	public int size();

	/**
	 * @return true if this priority queue contains no elements, false otherwise
	 */
	public boolean isEmpty();

	/**
	 * Removes all the elements from this priority queue. The queue will be
	 * empty when this call returns.
	 */
	public void clear();
}

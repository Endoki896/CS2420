package messCode.meeting13;

import java.util.NoSuchElementException;

/**
 * Interface to specify the behavior of a queue of elements,
 * ie, first-in, first-out (FIFO).
 * 
 * Each method should be O(1).
 * 
 * @author Aaron Wood
 * @version 2023-10-05
 * 
 * @param <E> - the type of the elements in the queue.
 */
public interface Queue<E> {

	/**
	 * @return the number of elements in the queue 
	 */
	public int size();
	
	/**
	 * @return true if queue contains no elements, false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Remove all elements from the queue
	 */
	public void clear();
	
	/**
	 * Get the element at the front of the queue.
	 * 
	 * @return the element at the front of the queue
	 * @throws NoSuchElementException if queue is empty
	 */
	public E peek() throws NoSuchElementException;
	
	/**
	 * Get and remove the element at the front of the queue.
	 * 
	 * @return the element at the front of the queue
	 * @throws NoSuchElementException if queue is empty
	 */
	public E dequeue() throws NoSuchElementException;
	
	/**
	 * Add an element to the back of the queue.
	 * 
	 * @param element - to be added.
	 */
	public void enqueue(E element);

}

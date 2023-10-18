package messCode.meeting13;

import java.util.NoSuchElementException;

/**
 * Interface to specify the behavior of a stack of elements,
 * ie, list-in, first-out (LIFO).
 * 
 * Each method should be O(1).
 * 
 * @author Aaron Wood
 * @version 2023-10-05
 * 
 * @param <E> - the type of the elements in the stack.
 */
public interface Stack<E> {
	
	/**
	 * @return the number of elements in the stack
	 */
	public int size();
	
	/**
	 * @return true if stack contains no elements, false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Remove all elements from the stack
	 */
	public void clear();
	
	/**
	 * Get the element at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if stack is empty
	 */
	public E peek() throws NoSuchElementException;
	
	/**
	 * Get and remove the element at the top of the stack.
	 * 
	 * @return the element at the top of the stack
	 * @throws NoSuchElementException if stack is empty
	 */
	public E pop() throws NoSuchElementException;
	
	/**
	 * Add an element to the top of the stack.
	 * 
	 * @param element - to be added.
	 */
	public void push(E element);

}

package assignments.assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This interface specifies the general behavior of an ordered list of elements.
 *
 * @author Aaron Wood
 * @version 2023-10-05
 *
 * @param <E> - the type of elements contained in the list
 */
public interface List<E> extends Iterable<E> {

	/**
	 * Inserts an element at the beginning of the list.
	 * O(1) for a singly-linked list.
	 *
	 * @param element - the element to add
	 */
	public void insertFirst(E element);

	/**
	 * Inserts an element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 *
	 * @param index - the specified position
	 * @param element - the element to add
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index > size())
	 */
	public void insert(int index, E element) throws IndexOutOfBoundsException;

	/**
	 * Gets the first element in the list.
	 * O(1) for a singly-linked list.
	 *
	 * @return the first element in the list
	 * @throws NoSuchElementException if the list is empty
	 */
	public E getFirst() throws NoSuchElementException;

	/**
	 * Gets the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 *
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
	 */
	public E get(int index) throws IndexOutOfBoundsException;

	/**
	 * Deletes and returns the first element from the list.
	 * O(1) for a singly-linked list.
	 *
	 * @return the first element
	 * @throws NoSuchElementException if the list is empty
	 */
	public E deleteFirst() throws NoSuchElementException;

	/**
	 * Deletes and returns the element at a specific position in the list.
	 * O(N) for a singly-linked list.
	 *
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 || index >= size())
	 */
	public E delete(int index) throws IndexOutOfBoundsException;

	/**
	 * Determines the index of the first occurrence of the specified element in the list,
	 * or -1 if this list does not contain the element.
	 * O(N) for a singly-linked list.
	 *
	 * @param element - the element to search for
	 * @return the index of the first occurrence; -1 if the element is not found
	 */
	public int indexOf(E element);

	/**
	 * O(1) for a singly-linked list.
	 *
	 * @return the number of elements in this list
	 */
	public int size();

	/**
	 * O(1) for a singly-linked list.
	 *
	 * @return true if this collection contains no elements; false, otherwise
	 */
	public boolean isEmpty();

	/**
	 * Removes all of the elements from this list.
	 * O(1) for a singly-linked list.
	 */
	public void clear();

	/**
	 * Generates an array containing all of the elements in this list in proper sequence
	 * (from first element to last element).
	 * O(N) for a singly-linked list.
	 *
	 * @return an array containing all of the elements in this list, in order
	 */
	public Object[] toArray();

	/**
	 * @return an iterator over the elements in this list in proper sequence (from first
	 * element to last element)
	 */
	public Iterator<E> iterator();
}

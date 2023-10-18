package messCode.meeting13;

import java.util.NoSuchElementException;

/**
 * Class implementing a queue backed by a basic array.
 * 
 * @author Aaron Wood
 * @version 2023-10-05
 * 
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {
	
	/**
	 * Backing array for the queue.
	 */
	private E[] array;
	
	/**
	 * Size of the queue. 
	 */
	private int length;
	
	/**
	 * Index indicating the front of the queue.
	 */
	private int front;
	
	/**
	 * Index indicating the back of the queue.
	 */
	private int back;

	
	/**
	 * Create a new array-backed queue.
	 */
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		this.array = (E[]) new Object[100];
		this.front = 0;
		this.back = -1;
		this.length = 0;
	}

	@Override
	public int size() {
		return this.length;
	}

	@Override
	public boolean isEmpty() {
		return this.length == 0;
	}

	@Override
	public void clear() {
		this.front = 0;
		this.back = -1;
		this.length = 0;
	}

	@Override
	public E peek() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		if (front >= this.array.length)
		{
			front = 0;
		}

		return this.array[front];
	}

	@Override
	public E dequeue() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		if (front >= this.array.length)
		{
			front = 0;
		}
		this.length--;

		return this.array[front++];
	}

	@Override
	public void enqueue(E element) {
		if (this.length == this.array.length) {
			this.resizeBackingArray();
		}
		if(back == this.array.length - 1) back = -1;
		this.length++;

		this.array[++back] = element;
	}
	
	/**
	 * Double the size of the backing array.
	 * 
	 * Copies contents of backing array into larger one,
	 * resetting the front to 0 and the back to length - 1.
	 * 
	 * Note that the index of the backing array wraps around,
	 * so incrementing must happen modulo the length.
	 */
	@SuppressWarnings("unchecked")
	private void resizeBackingArray() {
		Object[] temp = new Object[2 * this.array.length];
		for (int i = this.front, ti = 0; 
			ti < this.length;
			ti++, i = (i + 1) % this.length
		) {
			temp[ti] = this.array[i];
		}
		this.array = (E[]) temp;
		this.front = 0;
		this.back = this.length - 1;
	}

}

package messCode.meeting13;

import java.util.NoSuchElementException;

/**
 * Class implementing a stack backed by a basic array.
 * 
 * @author Aaron Wood
 * @version 2023-10-05
 * 
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

	/**
	 * Backing array for the stack.
	 */
	private E[] array;
	
	/**
	 * Index indicating the top of the stack.
	 */
	private int top;
	
	/**
	 * Create a new array-backed stack.
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		this.array = (E[]) new Object[100];
		top = -1;
	}

	@Override
	public int size() {
		return this.top + 1;
	}

	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public void clear() {
		this.top = -1;
	}

	@Override
	public E peek() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}

		return this.array[top];
	}

	@Override
	public E pop() throws NoSuchElementException {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}

		return this.array[top--];
	}

	@Override
	public void push(E element) {
		if (top == array.length - 1) {
			this.resizeBackingArray();
		}

		this.array[++top] = element;
	}
	
	/**
	 * Double the size of the backing array.
	 */
	@SuppressWarnings("unchecked")
	private void resizeBackingArray() {
		Object[] temp = new Object[2 * this.array.length];
		for (int i = 0; i < array.length; i++) {
			temp[i] = this.array[i];
		}
		this.array = (E[]) temp;
	}

}

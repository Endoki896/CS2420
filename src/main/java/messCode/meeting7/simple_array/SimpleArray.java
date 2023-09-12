package messCode.meeting7.simple_array;

/**
 * Object to represent a simple dynamic generic array.
 * 
 * Exercise #1: implement the following methods
 * 		- get(int index)
 * 		- set(int index, T element)
 * 		- add(T element)
 * Now the tests should pass.
 * 
 * @author Aaron Wood
 * @version 2023-09-12
 */
public class SimpleArray<T> {
	private T[] data;
	private int size;
	private static int DEFAULT_LENGTH = 10;
	
	/**
	 * Initialize empty simple array.
	 */
	@SuppressWarnings("unchecked")
	public SimpleArray() {
		this.size = 0;
		this.data = (T[])(new Object[DEFAULT_LENGTH]);
	}
	
	/**
	 * Get size of the array.
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Get the element of the array at an index.
	 * @param index
	 * @return element at the given index
	 * @throws ArrayIndexOutOfBoundsException if index is out of bounds.
	 */
	public T get(int index) throws ArrayIndexOutOfBoundsException {
		handleIndexOutOfBounds(index);
		return this.data[index];
	}
	
	/**
	 * Set an element at an index of the array.
	 * @param index
	 * @param element
	 * @throws ArrayIndexOutOfBoundsException if index is out of bounds.
	 */
	public void set(int index, T element) throws ArrayIndexOutOfBoundsException {
		handleIndexOutOfBounds(index);
		this.data[index] = element;
	}
	
	/**
	 * Add an element to the array.
	 * @param element
	 */
	public void add(T element) {
		if(size == data.length) expandBackingArray();
		this.data[this.size] = element;
		this.size++;
	}

	/**
	 *
	 * @param index
	 */
	private void handleIndexOutOfBounds(int index)
	{
		if(index < 0 || index >= this.size()) throw new ArrayIndexOutOfBoundsException("Index out of bounds");
	}

	/**
	 * Expand the backing array to twice the original size
	 */
	@SuppressWarnings("unchecked")
	private void expandBackingArray()
	{
		T[] array = (T[]) new Object[this.size * 2];
		for(int i = 0; i < this.size; i++)
			array[i] = this.data[i];
		this.data = array;
	}
}

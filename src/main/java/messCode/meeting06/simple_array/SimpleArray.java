package messCode.meeting06.simple_array;

import java.lang.reflect.GenericArrayType;

/**
 * Object to represent a simple dynamic generic array.
 * 
 * Exercise: implement missing pieces until tests pass.
 * 
 * @author Aaron Wood
 * @version 2023-09-23
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
		// Initialize generic backing array `data` with DEFAULT_LENGTH.
		data = (T[]) new Object[DEFAULT_LENGTH];
	}
	
	/**
	 * Get size of the array.
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Get the element at an index.
	 * 
	 * Throw an ArrayIndexOutOfBoundsException if index is out of bounds.
	 * 
	 * @param index
	 * @return
	 */
	public T get(int index) {
		// Implement
		if(index >= this.size) return null;
		return this.data[index];
	}
	
	/**
	 * Add element to the array.
	 */
	@SuppressWarnings("unchecked")
	public void add(T element) {
		// Implement
		for(int i = 0; i < data.length; i++)
		{
			if(data[i] == null) {
				data[i] = element;
				return;
			}
		}
		T[] array = (T[]) new Object[this.size + 1];
		System.arraycopy(data, 0, array, 0, data.length);
		array[array.length - 1] = element;
	}
	
	/**
	 * Remove element from the array.
	 * @return whether the element was added
	 */
	public boolean remove(T element) {
		// Implement
		return false;
	}
}

package messCode.meeting03;

/**
 * This class is to explore method overloading.
 * 
 * @author Aaron Wood
 * @version 2023-08-29
 */
public class MethodOverloading {

	/**
	 * Computes sum of two integers.
	 * @param a
	 * @param b
	 * @return
	 */
	public static int sum(int a, int b) {
		return a + b;
	}
	
	/**
	 * Computes sum of two short integers as an integer.
	 * @param a
	 * @param b
	 * @return
	 */
	public static int sum(short a, short b) {
		return a + b;
	}
	
	/**
	 * Computes sum of three integers.
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int sum(int a, int b, int c) {
		return a + b + c;
	}
	
	/**
	 * Computes sum of integers in an array.
	 * @param array
	 * @return
	 */
	public static int sum(int[] array) {
		int total = 0;
		for(int value : array)
		{
			total += value;
		}
		return total;
	}

}

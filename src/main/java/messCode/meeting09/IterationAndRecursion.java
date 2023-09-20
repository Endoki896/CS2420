package messCode.meeting09;

import java.util.Random;

public class IterationAndRecursion {

	public static void main(String[] args) {	
		Random random = new Random();
		long startTime, endTime;
		long iterativeResult, recursiveResult;
		
		int n = 10;
		long[] array = new long[n];
		for(int i = 0; i < n; i++)
			array[i] = random.nextLong();
		
		startTime = System.nanoTime();
		iterativeResult = fibonacciIterative(n);
		endTime = System.nanoTime();
		System.out.println(
			"iterative: " + iterativeResult 
			+ " (" + (endTime - startTime) + " ns)"
		);

		startTime = System.nanoTime();
		recursiveResult = fibonacciRecursive(n);
		endTime = System.nanoTime();
		System.out.println(
			"recursive: " + recursiveResult 
			+ " (" + (endTime - startTime) + " ns)"
		);
	}
	
	/* ----- sumUpTo ----- */
	
	/**
	 * Compute sum of integers from 1 to n iteratively.
	 * @param n
	 */
	public static long sumUpToIterative(long n) {
		long total = 0;
		for (int i = 1; i <= n; i++) {
			total += i;
		}
		return total;
	}
	
	/**
	 * Compute sum of integers from 1 to n recursively.
	 * @param n
	 */
	public static long sumUpToRecursive(long n) {
		return n == 0 ? 0 : n + sumUpToRecursive(n - 1);
	}
	
	/* ----- findMax ----- */
	
	/**
	 * Compute maximum element of an array iteratively.
	 * @param array
	 */
	public static long findMaxIterative(long[] array) {
		if (array.length == 0) {
			throw new IllegalArgumentException("empty array has no max");
		}

		long max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	/**
	 * Compute maximum element of an array recursively.
	 * @param array
	 */
	public static long findMaxRecursive(long[] array) {
		if (array.length == 0) {
			throw new IllegalArgumentException("empty array has no max");
		}
		return findMaxRecursive(array, 0);
	}

	private static long findMaxRecursive(long[] array, int lowerIndex)
	{
		if(lowerIndex == array.length - 1) return array[lowerIndex];
		long subMax = findMaxRecursive(array, lowerIndex + 1);
		if(subMax > array[lowerIndex])
			return subMax;
		return array[lowerIndex];
	}
	
	/* ----- fibonacci ----- */

	/**
	 * Compute nth fibonacci number iteratively.
	 * @param n
	 */
	public static long fibonacciIterative(long n) {
		if(n < 2) return 1;
		long prev = 1;
		long curr = 1;
		for(int i = 2; i <= n; i++)
		{
			long temp = prev + curr;
			prev = curr;
			curr = temp;
		}
		return curr;
	}
	
	/**
	 * Compute nth fibonacci number recursively.
	 * @param n
	 */
	public static long fibonacciRecursive(long n) {
		if(n < 2) return 1;
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	/* ----- computeGcd ----- */
	
	/**
	 * Compute greatest common divisor iteratively.
	 * @param a
	 * @param b
	 */
	public static long computeGcdIterative(long a, long b) {
		if (a == 0 && b == 0) {
			throw new IllegalArgumentException("gcd(0, 0) is undefined");
		}
		
		while (b != 0) {
			long rem = a % b;
			a = b;
			b = rem;
		}
		
		return a;
	}
	
	/**
	 * Compute greatest common divisor recursively.
	 * @param a
	 * @param b
	 */
	public static long computeGcdRecursive(long a, long b) {
		return 0;  // Implement
	}
}

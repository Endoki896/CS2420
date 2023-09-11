package messCode.meeting06;

import java.text.DecimalFormat;

/**
 * Class with static methods for exploring timing and time complexity notation.
 * 
 * @author Aaron Wood
 * @version 2023-09-07
 */
public class TimeAnalysis {
	public static int LOOP_COUNT = 1000;
	public static int STEP_SIZE = 50;
	public static DecimalFormat FORMATTER = new DecimalFormat("00000E00");

	public static void main(String[] args) {
		printHeader();
		for (int i = 1; i < 10; i++) {
			int n = i * STEP_SIZE;
			printRow(n, averageTime(n));
		}
	}
	
	private static double averageTime(int n) {
		long start, mid, end;
		
		// Warm up the system
		start = System.nanoTime();
		while (System.nanoTime() - start < 1_000_000_000) {}
		
		// Time the computation
		start = System.nanoTime();
		for (int i = 0; i < LOOP_COUNT; i++) {
			doComputation(n);
		}
		mid = System.nanoTime();
		
		// Time the looping itself
		for (int i = 0; i < LOOP_COUNT; i++) {}
		end = System.nanoTime();
		
		// compute average time
		return ((mid - start) - (end - mid)) / (double)LOOP_COUNT;
	}
	
	private static void doComputation(int n) {
		long count = 0;
		
//		// Option #1 (STEP_SIZE = 1000 for class)
//		// What is the time complexity of this?
		for (int i = 0; i < 1000; i++) {
			innerComputation(count++);
		}
//
//		// Option #2 (STEP_SIZE = 100 for class)
//		// What is the time complexity of this?
//		for (int i = 0; i < n; i++) {
//			innerComputation(count++);
//		}
//
//		// Option #3 (STEP_SIZE = 50 for class)
//		// What is the time complexity of this?
//		for (int i = 0; i < 5 * n; i++) {
//			innerComputation(count++);
//		}
//
//		// Option #4 (STEP_SIZE = 50 for class)
//		// What is the time complexity of this?
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < 5; j++) {
//				innerComputation(count++);
//			}
//		}
//		
//		// Option #5 (STEP_SIZE = 10000000 for class)
//		// What is the time complexity of this?
//		for (int i = 1; i < n; i *= 2) {
//			count++;
//			for (int j = 1; j < 10; j++) {
//				innerComputation(count);
//			}
//		}
//		
//		// Option #6 (STEP_SIZE = 10 for class)
//		// What is the time complexity of this?
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n / 2; j++) {
//				innerComputation(count++);
//			}
//		}
//
//		// Option #7 (STEP_SIZE = 1000 for class)
//		// What is the time complexity of this?
//		for (int i = 1; i < n; i *= 2) {
//			for (int j = 0; j < n / 5; j++) {
//				innerComputation(count++);
//			}
//		}
	}
	
	/**
	 * Inner computation that doesn't depend heavily on size of value.
	 * @param value
	 */
	private static void innerComputation(long value) {
		FORMATTER.format(value);
	}
	
	/**
	 * Print the table header.
	 */
	private static void printHeader() {
		System.out.println(
			"N\t\t| ... / logN\t| ... / 1\t| ... / N\t| ... / N^2"
		);
	}
	
	/**
	 * Print the table row size and time.
	 * @param n - size
	 * @param time
	 */
	private static void printRow(int n, double time) {
		System.out.println(
			FORMATTER.format(n) + "\t| "
			+ FORMATTER.format(time / log2(n)) + "\t| "
			+ FORMATTER.format(time) + "\t| "
			+ FORMATTER.format(time / n) + "\t| "
			+ FORMATTER.format(time / (n * n))
		);
	}
	
	/**
	 * Compute log base 2 of an integer.
	 * @param n
	 * @return
	 */
	private static double log2(int n) {
		return Math.log(n) / Math.log(2);
	}

}

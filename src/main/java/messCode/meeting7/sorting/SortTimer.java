package messCode.meeting7.sorting;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class SortTimer {
	
	public static Random RANDOM = new Random();
	public static DecimalFormat FORMATTER = new DecimalFormat("00000E00");
	
	public static int LOOP_COUNT = 100;
	
	// Increase these outside of class for longer timer tests
	public static int STEP_SIZE = 1000; 
	public static int ROW_COUNT = 10;

	public static void main(String[] args) {
		ArrayList<Integer> arraySizes = new ArrayList<Integer>();
		ArrayList<Double> averageTimes = new ArrayList<Double>();

		// Initialize sorter
		Sorter sorter = new SelectionSort();
		
		printTableHeader();
		warmUp(1);
		
		for (int row = 0; row < ROW_COUNT; row++) {
			int size = STEP_SIZE * (row + 1);
			double averageTime = computeAverageSortTime(size, sorter);
			
			// print array size and average time
			printTableRow(size, averageTime);
			
			// Store array size and average time
			arraySizes.add(size);
			averageTimes.add(averageTime);
		}

		// Print arraySizes and averageTimes for plotting
		System.out.println("\narray_sizes = " + arraySizes);
		System.out.println("average_times = " + averageTimes);
	}
	
	public static double computeAverageSortTime(int size, Sorter sorter) {
		double startTime, midTime, stopTime;
		
		// Re-warm the system
		warmUp(0.2);
		
		// Begin timer
		startTime = System.nanoTime();
		
		// Do the search loopCount times
		for (int i = 0; i < LOOP_COUNT; i++) {
			Integer[] array = randomDistinctArray(size);
			sorter.sort(array);
		}
		
		// End timer
		midTime = System.nanoTime();
		
		// Compute the time taken by looping 
		for (int i = 0; i < LOOP_COUNT; i++) {
			randomDistinctArray(size);
		}
		stopTime = System.nanoTime();
		
		// Return average time
		return (2 * midTime - startTime - stopTime) / (double)LOOP_COUNT;
	}
	
	/**
	 * Generate randomly ordered array of integers from 1 to {@code size}.
	 * @param size
	 */
	public static Integer[] randomDistinctArray(int size) {
		Integer[] array = new Integer[size];
		for (int i = 0; i < size; i++) {
			array[i] = i + 1;
		}
		shuffle(array);
		return array;
	}
	
	/**
	 * Shuffle contents of array at random
	 * @param array
	 */
	public static void shuffle(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			int j = RANDOM.nextInt(i, array.length);
			Integer temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}

	/**
	 * Warm up the system for a specified amount of time.
	 * @param seconds
	 */
	private static void warmUp(double seconds) {
		long time = System.nanoTime();
		while (System.nanoTime() - time < 1_000_000_000 * seconds) {} 
	}

	private static void printTableHeader() {
		System.out.println("arraySize\t| averageTime\t| ... / NlogN\t| ... / N^2");
	}
	
	private static void printTableRow(int arraySize, double averageTime) {
		double NlogN = arraySize * Math.log(arraySize) * Math.log(2);
		double N2 = arraySize * arraySize;
		
		System.out.println(
			FORMATTER.format(arraySize) + "\t| " 
			+ FORMATTER.format(averageTime) + "\t| "
			+ FORMATTER.format(averageTime / NlogN) + "\t| "
			+ FORMATTER.format(averageTime / N2)
		);
	}
	

}

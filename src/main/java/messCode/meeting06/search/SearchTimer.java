package messCode.meeting06.search;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Timer class to compare linear and binary search.
 * 
 * @author Aaron Wood
 * @version 2023-09-07
 */
public class SearchTimer {
	
	public static Random RANDOM = new Random();
	public static DecimalFormat FORMATTER = new DecimalFormat("00000E00");

	// number of targets to search for in each array
	public static int TARGET_COUNT = 100;
	
	// number of times to search for each target
	public static int LOOP_COUNT = 100;
	
	// total number of searches on an array
	public static int TOTAL_LOOP_COUNT = LOOP_COUNT * TARGET_COUNT;
	
	// iteration step size
	public static int STEP_SIZE = 30_000;
	
	public static void main(String[] args) throws IOException {
		ArrayList<String> fullStringArray = getStringArray();
		int maxSize = fullStringArray.size();  // 370_105

		// Initialize arrays to store the array sizes and average times
		ArrayList<Integer> arraySizes = new ArrayList<Integer>();
		ArrayList<Double> averageTimes = new ArrayList<Double>();
		
		printTableHeader();
		
		warmUp();
		
		// Get average time for an array of each size from STEP_SIZE to maxSize
		// in increments of STEP_SIZE
		for (int arraySize = STEP_SIZE; arraySize <= maxSize; arraySize += STEP_SIZE) {
			ArrayList<String> subArray = getSubArray(fullStringArray, arraySize);
			ArrayList<String> targets = getTargets(subArray);
			double averageTime = computeAverageTime(subArray, targets);
			
			// Print arraySize and averageTime
			printTableRow(arraySize, averageTime);

			// Store arraySize and averageTime
			arraySizes.add(arraySize);
			averageTimes.add(averageTime);
		}
		
		// Print arraySizes and averageTimes for plotting
		System.out.println("\narray_sizes = " + arraySizes);
		System.out.println("average_times = " + averageTimes);
	}
	
	/**
	 * Compute average time to search for targets in an array list.
	 * @param <T>
	 * @param sortedArray
	 * @param targets
	 * @return
	 */
	private static <T extends Comparable<T>> double computeAverageTime(
		ArrayList<T> sortedArray,
		ArrayList<T> targets
		
	) {
		double startTime, midTime, stopTime;
		
		// Re-warm the system
		warmUp(0.2);
		
		// Begin timer
		startTime = System.nanoTime();
		
		// Search for each target
		for (T target : targets) {
			// Do the search loopCount times
			for (int i = 0; i < LOOP_COUNT; i++) {
//				Search.linearSearch(sortedArray, target);
				Search.binarySearch(sortedArray, target);
			}
		}
		
		// End timer
		midTime = System.nanoTime();
		
		// Compute the time taken by looping 
		for (T target : targets) {
			for (int i = 0; i < LOOP_COUNT; i++) {}
		}
		stopTime = System.nanoTime();
		
		// Return average time
		return (2 * midTime - startTime - stopTime) / TOTAL_LOOP_COUNT;
	}
	
	/**
	 * Get strings in "words_alpha.txt" as an array list.
	 * @return
	 * @throws IOException
	 */
	private static ArrayList<String> getStringArray() throws IOException {
		String filename = "src/meeting06/words_alpha.txt";
		Path filePath = new File(filename).toPath();
		List<String> stringList = Files.readAllLines(filePath);
		return new ArrayList<String>(stringList); 
	}
	
	/**
	 * Get random targets from within an array list.
	 * @param <T>
	 * @param sortedArray
	 * @return
	 */
	private static <T extends Comparable<T>> 
	ArrayList<T> getTargets(ArrayList<T> sortedArray) {
		ArrayList<T> result = new ArrayList<T>();
		int maxIndex = sortedArray.size() - 1;
		for (int i = 0; i < TARGET_COUNT; i++) {
			result.add(sortedArray.get(RANDOM.nextInt(maxIndex)));
		}
		return result;
	}
	
	/**
	 * Get sub array list of an array list from index 0 to upper index.
	 * @param <T>
	 * @param sortedArray
	 * @param upperIndex
	 * @return
	 */
	private static <T extends Comparable<T>>
	ArrayList<T> getSubArray(ArrayList<T> sortedArray, int upperIndex) {
		List<T> subList = sortedArray.subList(0, upperIndex);
		return new ArrayList<T>(subList);
	}
	
	/**
	 * Warm up the system for a specified amount of time.
	 * @param seconds
	 */
	private static void warmUp(double seconds) {
		long time = System.nanoTime();
		while (System.nanoTime() - time < 1_000_000_000 * seconds) {} 
	}
	
	/**
	 * Warm up the system for 1 second.
	 */
	private static void warmUp() {
		warmUp(1);
	}
	
	private static void printTableHeader() {
		System.out.println("arraySize\t| averageTime\t| ... / N\t| ... / logN");
	}
	
	private static void printTableRow(int arraySize, double averageTime) {
		System.out.println(
			FORMATTER.format(arraySize) + "\t| " 
			+ FORMATTER.format(averageTime) + "\t| "
			+ FORMATTER.format(averageTime / arraySize) + "\t| "
			+ FORMATTER.format(averageTime / Math.log(arraySize) * Math.log(2))
		);
	}
	
}

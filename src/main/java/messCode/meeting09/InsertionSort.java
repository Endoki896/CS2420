package messCode.meeting09;

import java.util.Arrays;
import java.util.Random;

/**
 * Various implementations of insertion sort.
 * 
 * @author Aaron Wood
 * @version 2023-09-19
 */
public class InsertionSort {
	
	public static void sort1(int[] array) {
		for (int k = 1; k < array.length; k++) {
			// find index i to insert
			int i = k;
			for (int j = k - 1; j >= 0; j--) {
				if (array[j] > array[k]) {
					i = j;
				} else
					break;
			}

			// insert a[k] into index i
			int temp = array[k];
			for (int j = k; j > i; j--) {
				array[j] = array[j - 1];
			}
			array[i] = temp;
		}
		
	}

	public static void sort2(int[] array) {
		for (int k = 1; k < array.length; k++) {
			// swap a[k] down one spot until it is in place
			for (int j = k; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				} else {
					break;
				}
			}
		}
		
	}

	public static void sort3(int[] array) {
		for (int k = 1; k < array.length; k++) {
			// store a[k] in temp
			int temp = array[k];

			// move a[i] up one spot if bigger than temp
			int i = k - 1;
			while (i >= 0 && array[i] > temp) {
				array[i + 1] = array[i];
				i--;
			}

			// write temp at insertion point
			// (we decremented one too many times)
			array[i + 1] = temp;
		}
	}
	
	public static void main(String[] args) {
		int loopCount = 100;
		int stepSize = 500;
		int stepCount = 20;
		Random random = new Random();
		
		int[] arraySizes = new int[stepCount];
		double[] averageTimes = new double[stepCount];
		
		System.out.println("array size\t| average sort time");
		
		long start, end, extra;
		
		for (int k = 0; k < stepCount; k++) {
			int arraySize = (k + 1) * stepSize;
			int[] array = new int[arraySize];
			for (int i = 0; i < arraySize; i++) {
				array[i] = random.nextInt();
			}
			
			// Warm up
			start = System.nanoTime();
			while (System.nanoTime() - start > 1_000_000_000) {}
			
			// time the insertion sort
			start = System.nanoTime();
			
			for (int l = 0; l < loopCount; l++) {
				int[] dupArray = Arrays.copyOf(array, array.length);
				sort2(dupArray);
			}
			
			end = System.nanoTime();
			
			// time the extras: 
			//	- doing the loops
			//	- duplicating the array for each loop
			for (int l = 0; l < loopCount; l++) {
				Arrays.copyOf(array, array.length);
			}
			
			extra = System.nanoTime();
			
			// compute average time per loop
			long totalTime = end - start;
			long extraTime = extra - end;
			double averageTime = (totalTime - extraTime) / (double)loopCount; 
			
			arraySizes[k] = arraySize;
			averageTimes[k] = averageTime;
			
			System.out.println(arraySize + "\t\t| " + averageTime);
			
		}
		
		System.out.println("\narray_sizes = " + Arrays.toString(arraySizes));
		System.out.println("average_times = " + Arrays.toString(averageTimes));

	}
}

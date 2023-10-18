package messCode.meeting10;

import java.util.Arrays;

/**
 * Class with three solutions for computing the Maximum
 * Contiguous Subsequence Sum of an array.
 * 
 * @author Aaron Wood
 * @version 2023-09-21
 */
public class MaximumContiguousSubsequenceSum {
	// or MCSS
	public static void main(String[] args) {
		int[] array1 = { 4, -3, 5, -2, -1, 2, 6, -2 };
		System.out.println("-----\n" + Arrays.toString(array1));
		System.out.println("brute force: " + computeBruteForce(array1));
		System.out.println("improved   : " + computeImproved(array1));
		System.out.println("recursive  : " + computeRecursive(array1));
		
		int[] array2 = { -1, 8, -4, 2, 3, -6, 4, -10, 2 };
		System.out.println("\n-----\n" + Arrays.toString(array2));
		System.out.println("brute force: " + computeBruteForce(array2));
		System.out.println("improved   : " + computeImproved(array2));
		System.out.println("recursive  : " + computeRecursive(array2));

		int[] array3 = { -1, 10, -2, 13, -21, 9, -5, 16 };
		System.out.println("\n-----\n" + Arrays.toString(array3));
		System.out.println("brute force: " + computeBruteForce(array3));
		System.out.println("improved   : " + computeImproved(array3));
		System.out.println("recursive  : " + computeRecursive(array3));
	}

	/**
	 * Solve MCSS in O(N^3) using exhaustive search.
	 * @param array
	 * @return
	 */
	public static int computeBruteForce(int[] array) {
		int max = 0;
		
		for (int lower = 0; lower < array.length; lower++) {
			for (int upper = lower; upper < array.length; upper++) {
				int sum = 0;
				for (int i = lower; i < upper; i++) {
					sum += array[i];
					if (sum > max) {
						max = sum;
					}
				}
			}
		}
		
		return max;
	}
	
	/**
	 * Solve MCSS in O(N^2) using improved exhaustive search.
	 * @param array
	 * @return
	 */
	public static int computeImproved(int[] array) {
		int max = 0;
		
		for (int lower = 0; lower < array.length; lower++) {
			int sum = 0;
			for (int i = lower; i < array.length; i++) {
				sum += array[i];
				if (sum > max) {
					max = sum;
				}
			}
		}

		return max;
	}
	
	/**
	 * Solve MCSS in O(N log N) using recursion.
	 * @param array
	 * @return
	 */
	public static int computeRecursive(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		return computeRecursive(array, 0, array.length - 1);
	}
	
	private static int computeRecursive(int[] array, int lower, int upper) {
		// base case
		if (lower == upper) {
			if (array[lower] < 0) {
				// empty array has sum of 0, so it's better than negative
				return 0;
			}
			return array[lower];
		}
		
		int mid = (lower + upper) / 2;
		
		int leftMax = computeRecursive(array, lower, mid);
		int rightMax = computeRecursive(array, mid + 1, upper);

		int spanningMax = computeSpanningMax(array, lower, mid, upper);
		
		return Math.max(spanningMax, Math.max(leftMax, rightMax));
	}
	
	/**
	 * Compute the maximum sum of a subsequence that spans both
	 * the left and right halves.
	 * @param array
	 * @param lower
	 * @param mid
	 * @param upper
	 * @return
	 */
	private static int computeSpanningMax(int[] array, int lower, int mid, int upper) {
		int sum;

		// compute max sum of left half ending at mid
		int leftMax = 0;
		sum = 0;
		for (int i = mid; i >= lower; i--) {
			sum += array[i];
			if (sum > leftMax) {
				leftMax = sum;
			}
		}
		
		// compute max sum of right half starting at mid + 1
		int rightMax = 0;
		sum = 0;
		for (int i = mid + 1; i <= upper; i++) {
			sum += array[i];
			if (sum > rightMax) {
				rightMax = sum;
			}
		}
		
		return leftMax + rightMax;
	}
	
}

package labs.lab01;

/**
 * This class contains a utility method for finding the smallest difference.
 *
 * @author Aaron Wood and ??
 * @version 2023-08-23
 */
public class DiffUtil {

	/**
	 * Computes and returns the smallest difference (absolute value of subtraction)
	 * among every pair of integers in the input array.
	 * @param arr - input array of integers
	 * @throws IllegalArgumentException - if the array contains less than two items
	 */
	public static int findSmallestDiff(int[] arr) {
		if(arr.length <= 1) throw new IllegalArgumentException("Array length must be at least 2");
		int diff = Math.abs(arr[1] - arr[0]);
		for(int i = 0; i < arr.length; i++) for(int j = 0; j < arr.length; j++)
		{
			if(i == j) continue;
			int tmpDiff = Math.abs(arr[i] - arr[j]);
			if(tmpDiff < diff) diff = tmpDiff;
		}
		return diff;
	}
}

package messCode.meeting06.search;

import java.util.ArrayList;

/**
 * Class for search sorted arrays for values.
 * 
 * @author Aaron Wood
 * @version 2023-09-07
 */
public class Search {
	
	/**
	 * Find index of a target element in a sorted array list using linear search.
	 * 
	 * @param <T> - element and target type
	 * @param sortedArray - sorted array list to be searched
	 * @param target - element to be searched for
	 * @return index of element equal to target or -1 if target is not found
	 */
	// Implement the generic static method linearSearch
	public static <T extends Comparable<? super T>> int linearSearch(ArrayList<T> sortedArray, T target)
	{
		for(int i = 0; i < sortedArray.size(); i++)
		{
			int comparison = sortedArray.get(i).compareTo(target);
			if(comparison == 0) return i;
			else if(comparison > 0) return -1;
		}
		return -1;
	}
	 
	/**
	 * Find index of a target element in an array list using binary search.
	 * 
	 * @param <T> - element and target type
	 * @param sortedArray - sorted array list to be searched
	 * @param target - element to be searched for
	 * @return index of element equal to target or -1 if target is not found
	 */
	// Implement the generic static method binarySearch
	public static <T extends Comparable<? super T>> int binarySearch(ArrayList<T> sortedArray, T target)
	{
		int lower = 0, upper = sortedArray.size(), mid;
		while(lower < upper)
		{
			mid = (lower + upper) / 2;

			T element = sortedArray.get(mid);
			int comparison = element.compareTo(target);

			if(comparison == 0) return mid;
			else if(comparison > 0)
			{
				upper = mid - 1;
			} else {
				lower = mid + 1;
			}
		}
		return -1;
	}
}

package messCode.meeting7.sorting;

import java.util.Comparator;

abstract class Sorter {
	/**
	 * Sort an array of integers in place.
	 * @param array
	 */
	abstract void sort(Integer[] array);
	
	/**
	 * Sort an array of integers in place using a comparator.
	 * @param array
	 * @param comparator
	 */
	abstract void sort(Integer[] array, Comparator<Integer> comparator);
}

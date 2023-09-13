package messCode.meeting7.sorting;

import java.util.Comparator;

/**
 * Sorter class that implements the selection sort algorithm.
 *
 * Exercise #1: implement sort(Integer[] array)
 * Exercise #2: implement sort(Integer[] array, Comparator<Integer> comparator)
 * Exercise #3: refactor to clean up duplicate code
 * Exercise #4: genericize to SelectionSort<T>
 * 
 * @author Aaron Wood
 * @version 2023-09-12
 */
public class SelectionSort extends Sorter {

	public void sort(Integer[] array) {
		int min, hand;
		for(int i = 0; i < array.length; i++)
		{
			min = i;
			for(int j = i; j < array.length; j++)
			{
				if(array[j].compareTo(array[min]) < 0)
					min = j;
			}
			hand = array[i];
			array[i] = array[min];
			array[min] = hand;
		}
	}
	
	public void sort(Integer[] array, Comparator<Integer> comparator) {
		int min, hand;
		for(int i = 0; i < array.length; i++)
		{
			min = i;
			for(int j = i; j < array.length; j++)
			{
				if(comparator.compare(array[j], array[min]) < 0)
					min = j;
			}
			hand = array[i];
			array[i] = array[min];
			array[min] = hand;
		}
	}
	
}

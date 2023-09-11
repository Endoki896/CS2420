package messCode.meeting03;

import java.util.ArrayList;

/**
 * This class is to explore the difference between a basic array
 * and an ArrayList, with exercises of implementing in-place reversal.
 * 
 * @author Aaron Wood
 * @version 2023-08-29
 */

public class ArrayReverser {
	
	/**
	 * Reverse a basic array in place.
	 * @param array
	 */
	public static void reverseArray(int [] array) {
		int hand;
		for(int i = 0; i < array.length / 2; i++)
		{
			hand = array[i];
			array[i] = array[(array.length - 1) - i];
			array[(array.length - 1) - i] = hand;
		}
	}
	
	/**
	 * Reverse an ArrayList in place.
	 * @param arrayList
	 */
	public static void reverseArrayList(ArrayList<Integer> arrayList) {
		int hand;
		for(int i = 0; i < arrayList.size() / 2; i++)
		{
			hand = arrayList.get(i);
			arrayList.set(i, arrayList.get((arrayList.size() - 1) - i));
			arrayList.set((arrayList.size() - 1) - i, hand);
		}
	}
}
package messCode.meeting04.arrayListBuilder;

import java.util.ArrayList;

/**
 * This class is for exploring generic methods by converting
 * an array of objects into an ArrayList.
 * 
 * @author Aaron Wood
 * @version 2023-08-31
 */
public class ArrayListBuilder {

	/**
	 * @param array
	 * @return an ArrayList of type T containing all items in array
	 * @param <T>
	 */
	public static <T> ArrayList<T> fromArray(T[] array) {
		ArrayList<T> arrayList = new ArrayList<T>();
		for (T element : array) {
			arrayList.add(element);
		}
		return arrayList;
	}

	public static ArrayList<Integer> fromArray(int[] array)
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int element : array) {
			arrayList.add(element);
		}
		return arrayList;
	}
}

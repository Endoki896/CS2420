package messCode.meeting7.sorting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SorterTest {
	
	Integer[] distinctArray;
	Integer[] duplicatesArray;
	Integer[] constantArray;
	Integer[] orderedArray;
//	String[] stringArray;
	
	Sorter selectionSorter;
	
	@BeforeEach
	void setupArrays() {
		distinctArray = new Integer[] {8, 2, 5, 9, 6};
		duplicatesArray = new Integer[] {8, 2, 2, 2, 2, 5, 9, 6, 6, 6};
		constantArray = new Integer[] {4, 4, 4, 4, 4, 4};
		orderedArray = new Integer[] {4, 6, 9, 11};
//		stringArray = new String[] {"oh hi", "how are you?", "pretty good", "cool"};
	}
	
	@BeforeEach
	void setupSorters() {
		selectionSorter = new SelectionSort();
	}

	@Test
	void testSelectionDistinct() {
		selectionSorter.sort(distinctArray);
		assertSorted(distinctArray);
	}

	@Test
	void testSelectionDuplicates() {
		selectionSorter.sort(duplicatesArray);
		assertSorted(duplicatesArray);
	}
	
	@Test
	void testSelectionConstant() {
		selectionSorter.sort(constantArray);
		assertSorted(constantArray);
	}

	@Test
	void testSelectionOrdered() {
		selectionSorter.sort(orderedArray);
		assertSorted(orderedArray);
	}
	
	@Test
	void testSelectionSortReverseComparator() {
		selectionSorter.sort(distinctArray, (i1, i2) -> i2.compareTo(i1));
		assertTrue(Arrays.equals(distinctArray, new Integer[] {9, 8, 6, 5, 2}));
	}

//	@Test
//	void testSelectionString() {
//		selectionSorter.sort(stringArray);
//		assertSorted(stringArray);
//	}

	public void assertSorted(Integer[] array) {
		for (int i = 1; i < array.length; i++) {
			assertTrue(
				array[i - 1].compareTo(array[i]) <= 0,
				"out of order at index " + (i - 1)
				+ ": expected `" + array[i] 
				+ "` to come before `" + array[i - 1] + "`"
			);
		}
	}

}

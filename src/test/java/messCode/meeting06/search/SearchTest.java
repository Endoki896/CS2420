package messCode.meeting06.search;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class for testing linear and binary search on various Comparable data types.
 * 
 * @author Aaron Wood
 * @version 2023-09-07
 */
class SearchTest {
	
	public Random random = new Random();
	
	public ArrayList<Integer> intArray;
	public Integer intMember;
	public Integer intTooSmall;
	public Integer intTooLarge;
	public Integer intInBetween;
	
	public ArrayList<String> strArray;
	public String strMember;
	public String strTooSmall;
	public String strTooLarge;
	public String strInBetween;
	
	@BeforeEach
	void setup() {
		intArray = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			intArray.add(random.nextInt());
		}
		intArray.sort(null);
		intMember = intArray.get(random.nextInt(intArray.size()));
		intTooSmall = random.nextInt(
			Integer.MIN_VALUE, 
			intArray.get(0) - 1
		);
		intTooLarge = random.nextInt(
			intArray.get(intArray.size() - 1) + 1, 
			Integer.MAX_VALUE
		);
		intInBetween = intMember;
		while (intArray.contains(intInBetween)) {
			intInBetween++;
		}
		
		strArray = new ArrayList<String>();
		strArray.add("hi");
		strArray.add("how are you?");
		strArray.add("i'm fine, thx");
		strArray.add("that's really nice i'm so glad");
		strArray.add("what about you?");
		strMember = "how are you?";
		strTooSmall = "are you home yet?";
		strTooLarge = "when will you be home?";
		strInBetween = "now is a great time!";
	}

	@Test
	void testIntLinearSearchSuccess() {
		int index = Search.linearSearch(intArray, intMember);
		assertEquals(intArray.get(index), intMember);
	}
	
	@Test
	void testStrLinearSearchSuccess() {
		int index = Search.linearSearch(strArray, strMember);
		assertEquals(strArray.get(index), strMember);
	}
		
	@Test
	void testIntBinarySearchSuccess() {
		int index = Search.binarySearch(intArray, intMember);
		assertEquals(intArray.get(index), intMember);
	}

	@Test
	void testStrBinarySearchSuccess() {
		int index = Search.binarySearch(strArray, strMember);
		assertEquals(strArray.get(index), strMember);
	}
	
	@Test
	void testIntLinearSearchTooSmall() {
		int index = Search.linearSearch(intArray, intTooSmall);
		assertEquals(index, -1);
	}

	@Test
	void testStrLinearSearchTooSmall() {
		int index = Search.linearSearch(strArray, strTooSmall);
		assertEquals(index, -1);
	}

	@Test
	void testIntBinarySearchTooSmall() {
		int index = Search.binarySearch(intArray, intTooSmall);
		assertEquals(index, -1);
	}

	@Test
	void testStrBinarySearchTooSmall() {
		int index = Search.binarySearch(strArray, strTooSmall);
		assertEquals(index, -1);
	}

	@Test
	void testIntLinearSearchTooLarge() {
		int index = Search.linearSearch(intArray, intTooLarge);
		assertEquals(index, -1);
	}

	@Test
	void testStrLinearSearchTooLarge() {
		int index = Search.linearSearch(strArray, strTooLarge);
		assertEquals(index, -1);
	}

	@Test
	void testIntBinarySearchTooLarge() {
		int index = Search.binarySearch(intArray, intTooLarge);
		assertEquals(index, -1);
	}

	@Test
	void testStrBinarySearchTooLarge() {
		int index = Search.binarySearch(strArray, strTooLarge);
		assertEquals(index, -1);
	}	
	
	@Test
	void testIntLinearSearchInBetween() {
		int index = Search.linearSearch(intArray, intInBetween);
		assertEquals(index, -1);
	}

	@Test
	void testStrLinearSearchInBetween() {
		int index = Search.linearSearch(strArray, strInBetween);
		assertEquals(index, -1);
	}

	@Test
	void testIntBinarySearchInBetween() {
		int index = Search.binarySearch(intArray, intInBetween);
		assertEquals(index, -1);
	}

	@Test
	void testStrBinarySearchInBetween() {
		int index = Search.binarySearch(strArray, strInBetween);
		assertEquals(index, -1);
	}

}

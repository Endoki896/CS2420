package messCode.meeting06.simple_array;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleArrayTest {
	
	SimpleArray<String> array;
	
	@BeforeEach
	void setup() {
		array = new SimpleArray<String>();
		array.add("hi");
		array.add("how are you?");
		array.add("i'm okay, thx");
	}

	@Test
	void testSize() {
		assertEquals(array.size(), 3);
	}
	
	@Test
	void testGet() {
		assertEquals(array.get(1), "how are you?");
	}
	
	@Test
	void testGetNegative() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> { array.get(-1); });
	}
	
	@Test
	void testGetTooLarge() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> { array.get(5); });
	}
	
	@Test
	void testAdd() {
		array.add("this is cool");
		assertEquals(array.size(), 4);
		assertEquals(array.get(0), "hi");
		assertEquals(array.get(1), "how are you?");
		assertEquals(array.get(2), "i'm okay, thx");
		assertEquals(array.get(3), "this is cool");
	}
	
	@Test
	void testRemoveSuccess() {
		assertTrue(array.remove("how are you?"));
		assertEquals(array.size(), 2);
		assertEquals(array.get(0), "hi");
		assertEquals(array.get(1), "i'm okay, thx");
	}
	
	@Test
	void testRemoveFail() {
		assertFalse(array.remove("this is cool"));
		assertEquals(array.size(), 3);
		assertEquals(array.get(0), "hi");
		assertEquals(array.get(1), "how are you?");
		assertEquals(array.get(2), "i'm okay, thx");
	}
	
	@Test
	void testAddLots() {
		for (int i = 0; i < 100; i++) {
			array.add(Integer.toString(i));
		}
		assertEquals(array.size(), 103);
		assertEquals(array.get(0), "hi");
		assertEquals(array.get(1), "how are you?");
		assertEquals(array.get(2), "i'm okay, thx");
		for (int i = 0; i < 100; i++) {
			assertEquals(array.get(i + 3), Integer.toString(i));
		}
	}

}

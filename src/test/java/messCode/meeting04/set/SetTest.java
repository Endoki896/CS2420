package messCode.meeting04.set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetTest {

    public Set intSet;
    public int intSetSize;
    public int intMember;
    public int intOther;

    @BeforeEach
    void setupIntSet() {
        intSetSize = 5;
        intMember = 99;
        intOther = 200;
        intSet = new Set();
        intSet.add(10);
        intSet.add(201);
        intSet.add(99);
        intSet.add(50);
        intSet.add(7);
    }

//	public Set<String> strSet;
//	public int strSetSize;
//	public String strMember;
//	public String strOther;
//
//	@BeforeEach
//	void setupStringSet() {
//		strSetSize = 4;
//		strMember = "i'm okay";
//		strOther = "how are you??";
//		strSet = new Set<String>();
//		strSet.add("hi");
//		strSet.add("how are you?");
//		strSet.add("i'm okay");
//		strSet.add("thanks");
//	}

    @Test
    void testSizeInteger() {
        assertEquals(intSet.size(), intSetSize);
    }

    @Test
    void testIncludesInteger() {
        assertTrue(intSet.includes(intMember));
        assertFalse(intSet.includes(intOther));
    }

    @Test
    void testAddNewInteger() {
        assertFalse(intSet.includes(intOther));
        assertTrue(intSet.add(intOther));
        assertTrue(intSet.includes(intOther));
        assertEquals(intSet.size(), intSetSize + 1);
    }

    @Test
    void testAddExistingInteger() {
        assertTrue(intSet.includes(intMember));
        assertFalse(intSet.add(intMember));
        assertTrue(intSet.includes(intMember));
        assertEquals(intSet.size(), intSetSize);
    }

    @Test
    void testRemoveExistingInteger() {
        assertTrue(intSet.includes(intMember));
        assertTrue(intSet.remove(intMember));
        assertFalse(intSet.includes(intMember));
        assertEquals(intSet.size(), intSetSize - 1);
    }

    @Test
    void testRemoveNonExistingInteger() {
        assertFalse(intSet.includes(intOther));
        assertFalse(intSet.remove(intOther));
        assertFalse(intSet.includes(intOther));
        assertEquals(intSet.size(), intSetSize);
    }

//	@Test
//	void testSizeString() {
//		assertEquals(strSet.size(), strSetSize);
//	}
//
//	@Test
//	void testIncludesString() {
//		assertTrue(strSet.includes(strMember));
//		assertFalse(strSet.includes(strOther));
//	}
//
//	@Test
//	void testAddNewString() {
//		assertFalse(strSet.includes(strOther));
//		assertTrue(strSet.add(strOther));
//		assertTrue(strSet.includes(strOther));
//		assertEquals(strSet.size(), strSetSize + 1);
//	}
//
//	@Test
//	void testAddExistingString() {
//		assertTrue(strSet.includes(strMember));
//		assertFalse(strSet.add(strMember));
//		assertTrue(strSet.includes(strMember));
//		assertEquals(strSet.size(), strSetSize);
//	}
//
//	@Test
//	void testRemoveExistingString() {
//		assertTrue(strSet.includes(strMember));
//		assertTrue(strSet.remove(strMember));
//		assertFalse(strSet.includes(strMember));
//		assertEquals(strSet.size(), strSetSize - 1);
//	}
//
//	@Test
//	void testRemoveNonExistingString() {
//		assertFalse(strSet.includes(strOther));
//		assertFalse(strSet.remove(strOther));
//		assertFalse(strSet.includes(strOther));
//		assertEquals(strSet.size(), strSetSize);
//	}
}
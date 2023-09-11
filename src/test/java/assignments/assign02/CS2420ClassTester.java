package assignments.assign02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains tests for CS2420Class.
 * 
 * @author Aaron Wood and Stewart Russell
 * @version 2023-08-31 
 */
public class CS2420ClassTester {

	private int verySmall = 3, small = 10, medium = 20, large = 30;
	private static String[] firstNames = {
			"William",
			"David",
			"John",
			"Lexi",
			"Abby",
			"Peter",
			"Wade",
			"John",
			"Richard",
			"Daniel",
			"Theresa",
			"Giovanni",
			"Simon",
			"James",
			"Jackson",
			"Sarah",
			"Olivia",
			"Emma",
			"Christopher",
			"Alexander",
			"Riley"
	};
	private static String[] lastNames = {
			"Jones",
			"Walker",
			"Bond",
			"Scott",
			"Baker",
			"Allen",
			"Williams",
			"Rodriguez",
			"Moore",
			"Russell",
			"Strobehn",
			"Robinson",
			"Clark",
			"Schock",
			"Campbell",
			"Taylor",
			"Miller",
			"Lewis",
			"Great",
			"Johnson",
			"Rodriguez"
	};
	private static String[] domainNames = {
			"gmail.com",
			"yahoo.com",
			"icloud.com",
			"hotmail.com"
	};
	private static List<Integer> usedUNIDs = new ArrayList<>();
	private CS2420Class emptyClass, verySmallClass, smallClass, mediumClass, largeClass;
	
	@BeforeEach
	void setUp() throws Exception {
		emptyClass = new CS2420Class();
		
		verySmallClass = new CS2420Class();
		verySmallClass.addStudent(new CS2420Student("Jane", "Doe", 1010101, new EmailAddress("hi", "gmail.com")));
		verySmallClass.addStudent(new CS2420Student("Drew", "Hall", 2323232, new EmailAddress("howdy", "gmail.com")));
		verySmallClass.addStudent(new CS2420Student("Riley", "Nguyen", 4545454, new EmailAddress("hello", "gmail.com")));

		smallClass = new CS2420Class();
		smallClass.addAll(new File("src/a_small_2420_class.txt").getAbsolutePath());

		mediumClass = generateClassOf(medium);
		largeClass = generateClassOf(large);
	}

	static CS2420Student generateStudent()
	{
		Random rand = new Random();
		String firstName = firstNames[rand.nextInt(firstNames.length)];
		String lastName = lastNames[rand.nextInt(lastNames.length)];
		String domain = domainNames[rand.nextInt(domainNames.length)];
		int unid = rand.nextInt(1000000, 10000000);
		while(usedUNIDs.contains(unid))
		{
			unid = rand.nextInt(1000000, 10000000);
		}
		usedUNIDs.add(unid);
		return new CS2420Student(firstName, lastName, unid, new EmailAddress(firstName.substring(0, 1).toLowerCase() + lastName.toLowerCase(), domain));
	}

	static CS2420Class generateClassOf(int size)
	{
		CS2420Class output = new CS2420Class();
		output.addStudent(new CS2420Student("Kennedy", "Miller", 888888, new EmailAddress("we_love_puppies", "geemail.com")));
		output.addStudent(new CS2420Student("Taylor", "Miller", 999999, new EmailAddress("we_love_puppies", "geemail.com")));
		output.addStudent(new CS2420Student("Casey", "Brown", 333333, new EmailAddress("casey", "lol.com")));
		if(!usedUNIDs.contains(888888)) usedUNIDs.add(888888);
		if(!usedUNIDs.contains(999999)) usedUNIDs.add(999999);
		if(!usedUNIDs.contains(333333)) usedUNIDs.add(333333);
		for(int i = 0; i < size; i++) output.addStudent(generateStudent());

		return output;
	}
	
	// Empty CS 2420 class tests --------------------------------------------------------------------------

	@Test
	public void testEmptyLookupUNID() {
		assertNull(emptyClass.lookup(1234567));
	}
	
	@Test
	public void testEmptyLookupContactInfo() {
		ArrayList<CS2420Student> students = emptyClass.lookup(new EmailAddress("hello", "gmail.com"));
		assertEquals(0, students.size());
	}
	
	@Test
	public void testEmptyAddScore() {
		// ensure no exceptions thrown
		emptyClass.addScore(1234567, 100, "assignment");
	}

	@Test
	public void testEmptyClassAverage() {
		assertEquals(0, emptyClass.computeClassAverage(), 0);
	}
	
	@Test
	public void testEmptyContactList() {
		ArrayList<EmailAddress> contactList = emptyClass.getContactList();
		assertEquals(0, contactList.size());
	}

	// Very small CS 2420 class tests --------------------------------------------------------------------

	@Test
	public void testVerySmallLookupUNID() {
		UofUStudent expected = new UofUStudent("Drew", "Hall", 2323232);
		CS2420Student actual = verySmallClass.lookup(2323232);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testVerySmallLookupContactInfo() {
		UofUStudent expectedStudent = new UofUStudent("Riley", "Nguyen", 4545454);
		ArrayList<CS2420Student> actualStudents = verySmallClass.lookup(new EmailAddress("hello", "gmail.com"));
		assertEquals(1, actualStudents.size());
		assertEquals(expectedStudent, actualStudents.get(0));
	}
	
	@Test
	public void testVerySmallAddDuplicateStudent() {
		boolean actual = verySmallClass.addStudent(new CS2420Student("Jane", "Doe", 1010101, 
				new EmailAddress("hi", "gmail.com")));
		assertFalse(actual);
	}
	
	@Test
	public void testVerySmallAddNewStudent() {
		boolean actual = verySmallClass.addStudent(new CS2420Student("Jane", "Doe", 1010100, 
				new EmailAddress("hi", "gmail.com")));
		assertTrue(actual);		
	}

	@Test
	public void testVerySmallStudentFinalScore0() {
		CS2420Student student = verySmallClass.lookup(2323232);
		student.addScore(86.5, "assignment");
		student.addScore(75, "exam");
		student.addScore(89.2, "quiz");
		assertEquals(0, student.computeFinalScore(), 0);
	}
	
	@Test
	public void testVerySmallStudentFinalGradeNA() {
		CS2420Student student = verySmallClass.lookup(2323232);
		student.addScore(86.5, "assignment");
		student.addScore(75, "exam");
		student.addScore(100, "lab");
		assertEquals("N/A", student.computeFinalGrade());
	}
	
	@Test
	public void testVerySmallStudentFinalScore() {
		CS2420Student student = verySmallClass.lookup(2323232);
		student.addScore(86.5, "assignment");
		student.addScore(55, "exam");
		student.addScore(90, "lab");
		student.addScore(89.2, "quiz");
		student.addScore(99, "assignment");
		student.addScore(80, "lab");
		student.addScore(77.7, "quiz");
		assertEquals(55, student.computeFinalScore(), 0.001);
	}
	
	@Test
	public void testVerySmallStudentFinalGrade() {
		CS2420Student student = verySmallClass.lookup(2323232);
		student.addScore(86.5, "assignment");
		student.addScore(75, "exam");
		student.addScore(90, "lab");
		student.addScore(89.2, "quiz");
		student.addScore(99, "assignment");
		student.addScore(80, "lab");
		student.addScore(77.7, "quiz");
		assertEquals("B", student.computeFinalGrade());
	}
	
	@Test
	public void testVerySmallStudentComputeScoreTwice() {
		CS2420Student student = verySmallClass.lookup(2323232);
		student.addScore(86.5, "assignment");
		student.addScore(75, "exam");
		student.addScore(90, "lab");
		student.addScore(89.2, "quiz");
		student.addScore(99, "assignment");
		student.addScore(80, "lab");
		student.addScore(77.7, "quiz");
		student.computeFinalScore();   
		student.addScore(70, "lab");
		student.addScore(54.5, "exam");				
		assertEquals(64.75, student.computeFinalScore(), 0.001);
	}

	@Test
	public void testVerySmallUpdateName() {
		verySmallClass.lookup(1010101).updateName("John", "Doe");
		ArrayList<CS2420Student> students = verySmallClass.lookup(new EmailAddress("hi", "gmail.com"));
		assertEquals("John", students.get(0).getFirstName());
		assertEquals("Doe", students.get(0).getLastName());
	}	
	
	// Small CS 2420 class tests -------------------------------------------------------------------------

	@Test
	public void testSmallLookupContactInfo() {
		UofUStudent expectedStudent1 = new UofUStudent("Kennedy", "Miller", 888888);
		UofUStudent expectedStudent2 = new UofUStudent("Taylor", "Miller", 999999);

		ArrayList<CS2420Student> actualStudents = smallClass.lookup(new EmailAddress("we_love_puppies", "geemail.com"));
		assertEquals(2, actualStudents.size());
		assertTrue(actualStudents.contains(expectedStudent1));
		assertTrue(actualStudents.contains(expectedStudent2));
	}
	
	@Test
	public void testSmallGetContactList() {
		ArrayList<EmailAddress> actual = smallClass.getContactList();
		assertEquals(9, actual.size());
	}

	@Test
	public void testSmallStudentFinalScore() {
		CS2420Student student = smallClass.lookup(333333);
		assertEquals(95.6027, student.computeFinalScore(), 0.001);
	}

	@Test
	public void testSmallComputeClassAverage() {
		assertEquals(78.3191, smallClass.computeClassAverage(), 0.001);
	}

	// Medium CS 2420 tests -------------------------------------------------------------------------

	@Test
	public void testMediumLookupContactInfo() {
		UofUStudent expectedStudent1 = new UofUStudent("Kennedy", "Miller", 888888);
		UofUStudent expectedStudent2 = new UofUStudent("Taylor", "Miller", 999999);

		ArrayList<CS2420Student> actualStudents = mediumClass.lookup(new EmailAddress("we_love_puppies", "geemail.com"));
		assertEquals(2, actualStudents.size());
		assertTrue(actualStudents.contains(expectedStudent1));
		assertTrue(actualStudents.contains(expectedStudent2));
	}

	@Test
	public void testMediumGetContactList() {
		ArrayList<EmailAddress> actual = mediumClass.getContactList();
		assertEquals(22, actual.size());
	}

	// Large CS 2420 tests -------------------------------------------------------------------------

	@Test
	public void testLargeLookupContactInfo() {
		UofUStudent expectedStudent1 = new UofUStudent("Kennedy", "Miller", 888888);
		UofUStudent expectedStudent2 = new UofUStudent("Taylor", "Miller", 999999);

		ArrayList<CS2420Student> actualStudents = largeClass.lookup(new EmailAddress("we_love_puppies", "geemail.com"));
		assertEquals(2, actualStudents.size());
		assertTrue(actualStudents.contains(expectedStudent1));
		assertTrue(actualStudents.contains(expectedStudent2));
	}

	@Test
	public void testLargeGetContactList() {
		ArrayList<EmailAddress> actual = largeClass.getContactList();
		assertEquals(32, actual.size());
	}
}
package labs.lab07;

import java.util.Arrays;

/**
 * This class checks to see how well an RNG works.
 * It reports on several important properties, including the following:
 *    the number of zeros after 1000 tries
 *    how many tries before all the numbers between 1-1000 are generated
 *    the number of unique numbers generated in 1000 tries
 *    the number of odd-even pairs
 *    the number of odd-odd pairs
 *    the number of even-odd pairs
 *    the number of even-even pairs
 *    the average number generated
 *
 * @author Aaron Wood
 * @version 2023-10-06
 */
public class CheckRandomNumberGenerator {

	public static void main(String[] args) {
		System.out.println("---------------------------------------");
		System.out.println("Testing Poor Random Number Generator");
		RandomNumberGenerator rng = new PoorRandomNumberGenerator();
		CheckRandomNumberGenerator checker = new CheckRandomNumberGenerator();
		checker.checkRandom(rng, 0);

		System.out.println("---------------------------------------");
		System.out.println("Testing Java's Random Number Generator");
		rng = new JavasRandomNumberGenerator();
		checker = new CheckRandomNumberGenerator();
		checker.checkRandom(rng, 0);

		System.out.println("---------------------------------------");
		System.out.println ("Testing Better Random Number Generator");
		rng = new BetterRandomNumberGenerator();
		checker = new CheckRandomNumberGenerator();
		checker.checkRandom(rng, 0);
	}

	// for checking, only generate numbers between 0 and maxSize
	private final int maxSize;

	// keeps track the oddness/evenness of consecutive numbers
	private int oddOddCount;
	private int oddEvenCount;
	private int evenEvenCount;
	private int evenOddCount;

	// average of all the random numbers
	private long totalOfAll = 0;
	private int counter = 0;

	// histogram of the random numbers being generated
	private int[] histogram;
	private int previous;

	// number of boxes in the histogram that are still
	// empty after a thousand numbers are generated
	private int numberOfZerosAfterTenThousand;

	// number of boxes filled
	private int numbersFilled;

	// number of tries taken to fill in box
	private int numbersGenerated;

	public CheckRandomNumberGenerator() {
		maxSize = 10000;
		oddOddCount = 0;
		oddEvenCount = 0;
		evenEvenCount = 0;
		evenOddCount = 0;
		totalOfAll = 0;
		counter = 0;
		histogram = new int[maxSize];
		previous = -1;
		numberOfZerosAfterTenThousand = 0;
		numbersFilled = 0;
		numbersGenerated = 0;
	}

	/**
	 * Clears the histogram.
	 */
	public void clearHistogram() {
		for(int i = 0; i < maxSize; i++)
			histogram[i] = 0;
	}

	/**
	 * Runs a series of checks to see how well an RNG works.
	 *
	 * @param generator - the random number generator to check
	 * @param seed - the value to set the seed in the random number generator
	 */
	public void checkRandom(RandomNumberGenerator generator, int seed) {
		// set the seed of the random number generator
		generator.setSeed(seed);

		clearHistogram();

		// check odd/even of numbers and average number
		for(int i = 0; i < maxSize; i++) {
			int value = generator.nextInt(maxSize);

			histogram[value]++;

			totalOfAll += value;
			counter++;

			if(previous >= 0)

				if(isOdd(previous))
					if(isOdd(value))
						oddOddCount++;
					else
						oddEvenCount++;

				else if(isOdd(value))
					evenOddCount++;
				else
					evenEvenCount++;

			previous = value;
		}

		Arrays.sort(histogram);

		// check how many zeros
		while(histogram[numberOfZerosAfterTenThousand] == 0)
			numberOfZerosAfterTenThousand++;

		// determine how many calls to nextInt are required to hit every number
		fillArray(generator);

		// time how long it takes to generate 10,000,000 numbers
		long start = System.nanoTime();
		for(int i = 0; i < 10000000; i++)
			generator.nextInt(10000);

		long end = System.nanoTime();

		// print some stats:
		System.out.println("\n  -- Random Number Tester Stats --\n");

		System.out.printf("Time to generate 10000000 random numbers is:  %.1f seconds\n\n",
				(double) ((end - start) / 1000000000.0));

		System.out.println("Number of zeros after " + maxSize + " tries: " + numberOfZerosAfterTenThousand);
		System.out.println("Number of odd-even  pairs: " + oddEvenCount);
		System.out.println("Number of odd-odd   pairs: " + oddOddCount);
		System.out.println("Number of even-odd  pairs: " + evenOddCount);
		System.out.println("Number of even-even pairs: " + evenEvenCount + "\n");

		System.out.println("Average number is: " + (double) totalOfAll / (double) counter);
		System.out.println("Median number of times a number was generated: " + histogram[histogram.length / 2]);
		System.out.println("Min    number of times a number was generated: " + histogram[0]);
		System.out.println("Max    number of times a number was generated: " + histogram[histogram.length - 1] + "\n");

		System.out.println("Repeatability on same seed: " + testSeed(generator) + "\n");

		if(numbersFilled < maxSize) {
			System.out.println("Could not fill histogram after 1000000 tries.");
			System.out.println("There were still " + (maxSize - numbersFilled) + " indices empty.\n");
		}
		else
			System.out.println(
					"It took " + numbersGenerated + " generated numbers to hit every possibility from 0 to " + maxSize + ".");
	}

	/**
	 * Checks to see if setting the seed to the same value returns the same
	 * sequence.
	 *
	 * @param generator - the random number generator to use
	 * @return true if setting the seed to the same value returns the same
	 *         sequence, false otherwise
	 */
	private boolean testSeed(RandomNumberGenerator generator) {
		int[] firstSequence = new int[10000];
		generator.setSeed(0);

		for(int i = 0; i < 10000; i++)
			firstSequence[i] = generator.nextInt(10000);

		int[] secondSequence = new int[10000];
		generator.setSeed(0);
		for(int i = 0; i < 10000; i++)
			secondSequence[i] = generator.nextInt(10000);

		for(int i = 0; i < 10000; i++)
			if(firstSequence[i] != secondSequence[i])
				return false;

		return true;
	}

	/**
	 * Determines how many numbers need to be generated before an array of
	 * "maxSize" is filled.
	 *
	 * @param generator - the random number generator to test
	 */
	private void fillArray(RandomNumberGenerator generator) {
		boolean[] isEmpty = new boolean[maxSize];
		for(int i = 0; i < isEmpty.length; i++)
			isEmpty[i] = true;

		int index;
		while(numbersFilled < maxSize && numbersGenerated < 1000000) {
			index = generator.nextInt(maxSize);
			if(isEmpty[index]) {
				isEmpty[index] = false;
				numbersFilled++;
			}
			numbersGenerated++;
		}
	}

	/**
	 * Determines if a number is odd.
	 *
	 * @param value - the number to determine if it is odd
	 * @return returns true if the value is odd, false otherwise
	 */
	private boolean isOdd(int value) {
		return (value % 2) == 1;
	}
}

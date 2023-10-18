package labs.lab07;

import java.util.Random;

/**
 * Builds an RNG simply by wrapping the java.util.Random class.
 *
 * @author Aaron Wood
 * @version 2023-10-06
 */
public class JavasRandomNumberGenerator implements RandomNumberGenerator {

	// a Random object to do the actual "work" of this class
	private Random rng;

	public JavasRandomNumberGenerator() {
		rng = new Random();
	}

	public int nextInt(int max) {
		return rng.nextInt(max);
	}

	public void setSeed(long seed) {
		rng.setSeed(seed);
	}

	public void setConstants(long const1, long const2) {
		// Body purposely omitted since constants not used.
	}
}

package labs.lab07;

/**
 * This is a simple interface for a random number generator (RNG).
 *
 * @author Aaron Wood
 * @version 2023-10-06
 */
public interface RandomNumberGenerator {

	/**
	 * Generates and returns a random integer between [0,max).
	 *
	 * @param max - the upper bound for the range of the random number, non-inclusive
	 * @return an integer between [0, max)
	 */
	public int nextInt(int max);

	/**
	 * Sets a seed for the random number generator. A random number generator should
	 * return the same sequence of numbers for the same seed.
	 *
	 * @param seed - the seed parameter used to initialize the random number generator.
	 */
	public void setSeed(long seed);

	/**
	 * Sets two constants for use with the random generator, such as a linear congruential
	 * generator (see https://en.wikipedia.org/wiki/Linear_congruential_generator).
	 * If your generator does not use such constants, you are free to ignore the input from
	 * this method.
	 */
	public void setConstants(long const1, long const2);
}

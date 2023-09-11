package lab02;

/**
 * This program tries to determine how long it takes to compute the square root
 * of each number from 1 through 10.  But, it is doing a very bad job!
 * 
 * @author Aaron Wood
 * @version 2023-08-29
 */
public class TimingExperiment07 {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		for(double d = 1; d <= 10; d++)
			Math.sqrt(d);

		long stopTime = System.nanoTime();

		System.out.println("It takes exactly " + (stopTime - startTime)
				+ " nanoseconds to compute the square roots of the numbers 1..10.");
	}

}

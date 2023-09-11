package lab02;

/**
 * This program counts how many times the nanosecond timer changes in one
 * second.
 * 
 * Notice that computations are arranged to minimize how many times they are
 * repeated.
 * 
 * @author Aaron Wood
 * @version 2023-08-29
 */
public class TimingExperiment06 {

	public static void main(String[] args) {
		long secondsToRun = 10;
		long startTime = System.nanoTime();
		long lastTime = startTime;
		long advanceCount = 0;
		long loopCount = 0;
		long currentTime;
		long totalTime = 1000000000 * secondsToRun;
		long elapsedTime = 0;
		while(elapsedTime < totalTime) {
			loopCount++;
			if((currentTime = System.nanoTime()) != lastTime) {
				lastTime = currentTime;
				elapsedTime = lastTime - startTime;
				advanceCount++;
			}
		}
		double advancesPerSecond = advanceCount / (double) secondsToRun;
		System.out.println("Time advanced " + advancesPerSecond + " times per second.");
		System.out.println("The loop tested the time " + loopCount + " times.");
	}

}

package lab02;

/**
 * This program counts how many times the millisecond timer changes in one
 * second.
 * 
 * @author Aaron Wood
 * @version 2023-08-29
 */
public class TimingExperiment02 {

	public static void main(String[] args) {
		long secondsToRun = 1;
		long startTime = System.currentTimeMillis();
		long lastTime = startTime;
		long advanceCount = 0;
		long loopCount = 0;
		while(lastTime - startTime < 1000 * secondsToRun) {
			loopCount++;
			long currentTime = System.currentTimeMillis();
			if(currentTime == lastTime)
				continue;
			lastTime = currentTime;
			advanceCount++;
		}
		double advancesPerSecond = advanceCount / (double) secondsToRun;
		System.out.println("Time advanced " + advancesPerSecond + " times per second.");
		System.out.println("The loop tested the time " + loopCount + " times.");
	}

}

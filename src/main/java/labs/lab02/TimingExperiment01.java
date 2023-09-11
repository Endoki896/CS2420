package lab02;

/**
 * This program loops 100 times looking for changes in the current time.  If
 * time advances in one-millisecond increments, then this code should complete
 * in 100 milliseconds.
 * 
 * @author Aaron Wood
 * @version 2023-08-29
 */
public class TimingExperiment01 {

	public static void main(String[] args) {
		long lastTime = System.currentTimeMillis();
		long advanceCount = 0;
		while(advanceCount < 100) {
			long currentTime = System.currentTimeMillis();
			if(currentTime == lastTime)
				continue;
			System.out.println("Time advanced " + (currentTime - lastTime) + " milliseconds.");
			lastTime = currentTime;
			advanceCount++;
		}
	}

}

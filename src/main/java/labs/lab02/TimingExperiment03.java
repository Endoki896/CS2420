package lab02;

/**
 * This program loops 100 times looking for changes in the current time.  If
 * time advances in one-nanosecond increments, then this code should complete in
 * 100 nanoseconds.
 * 
 * Notice the print statement inside the loop. Is that a good idea?
 * 
 * @author Aaron Wood
 * @version 2023-08-29
 */
public class TimingExperiment03 {

	public static void main(String[] args) {
		long lastTime = System.nanoTime();
		long advanceCount = 0;
		while(advanceCount < 100) {
			long currentTime = System.nanoTime();
			if(currentTime == lastTime)
				continue;
			System.out.println("Time advanced " + (currentTime - lastTime) + " nanoseconds.");
			lastTime = currentTime;
			advanceCount++;
		}
	}

}

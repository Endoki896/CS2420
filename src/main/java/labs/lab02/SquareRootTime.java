package labs.lab02;

public class SquareRootTime {
    public static void main(String[] args)
    {
        long startTime = System.nanoTime();
        while(System.nanoTime() - startTime < 1000000000)
        {}

        long averageTime = 0;
        for(int i = 0; i < 1000; i++)
        {
            long squareTime = 0;
            for(double j = 1.0; j < 11.0; j += 1.0)
            {
                startTime = System.nanoTime();
                Math.sqrt(j);
                squareTime += System.nanoTime() - startTime;
            }
            averageTime = (averageTime + squareTime) / 2;
        }

        System.out.println("Approx time to compute the square roots of the numbers 1 - 10: " + averageTime + " ns");
    }
}

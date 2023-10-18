package labs.lab07;

public class BetterRandomNumberGenerator implements RandomNumberGenerator {

    private long seed;
    private long x;

    private final long a = 2147483629, c = 2147483587, m = Math.round(Math.pow(2, 31) - 1);

    public BetterRandomNumberGenerator()
    {
        this.seed = System.nanoTime();
        x = seed;
    }

    public BetterRandomNumberGenerator(long seed)
    {
        this.seed = seed;
        x = seed;
    }

    @Override
    public int nextInt(int max) {
        x = (a * x + c) % m;
        return (int) (x % max);
    }

    @Override
    public void setSeed(long seed) {
        this.seed = seed;
        x = seed;
    }

    @Override
    public void setConstants(long const1, long const2) {
    }
}

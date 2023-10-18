package messCode.meeting11;

/**
 * Implement the gcd algorithm recursively.
 *
 * @author Aaron Wood
 * @version 2023-09-26
 */
public class Recursion {
	/**
	 * Computes the greatest common divisor of two integers recursively.
	 * @param a
	 * @param b
	 */
	public static int computeGcd(int a, int b) {
		if (a == 0 && b == 0) {
			throw new IllegalArgumentException("gcd(0, 0) is undefined");
		}
		return computeGcdInner(a, b);
	}

	private static int computeGcdInner(int a, int b)
	{
		if(b == 0) return Math.abs(a);
		else return computeGcdInner(b, a % b);
	}

	/**
	 * Computes the greatest common divisor of two integers iteratively.
	 * @param a
	 * @param b
	 */
	public static int computeGcdIterative(int a, int b) {
		if (a == 0 && b == 0) {
			throw new IllegalArgumentException("gcd(0, 0) is undefined");
		}

		while (b != 0) {
			int rem = a % b;
			a = b;
			b = rem;
		}

		return Math.abs(a);
	}
}

import java.util.Set;
import java.util.HashSet;

/**
 * Finds the first triangle number with more than the given number of divisors.
 */
public class TriangleNumber {

	/**
	 * Finds all divisors for a given number.
	 * @param number the number to find the divisors for.
	 * @return a set of the divisors.
	 */
	public static Set<Long> divisors(long number) {
		Set<Long> set = new HashSet<Long>();
		long limit = (long) Math.sqrt(number);
		for (long i = 1 ; i <= limit ; i++) {
			if (number % i == 0) {
				set.add(i);
				set.add(number / i);
			}
		}
		return set;
	}

	/**
	 * Finds the triangle number with more than the given number of divisors.
	 * @param numberOfDivisors the number of divisors required.
	 * @return the triangle number with the correct number of divisors.
	 */
	public static long getTriangleNumberWithDivisors(int numberOfDivisors) {
		long currentNumber = 1;
		for (int i = 2 ; (divisors(currentNumber)).size() <= numberOfDivisors ; i++) {
			currentNumber += i;
		}
		return currentNumber;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please provide the number of divisors for the expected triangle number. Exitting.");
			System.exit(0);
		}
		
		int numberOfDivisors = Integer.parseInt(args[0]);
		long answer = getTriangleNumberWithDivisors(numberOfDivisors);
		System.out.println("The first triangle number with more than " + numberOfDivisors + " divisors is " + answer);
	}
}
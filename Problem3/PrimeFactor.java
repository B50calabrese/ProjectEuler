/**
 * Finds the largest prime factor of a given number.
 */
public class PrimeFactor {

	/**
	 * @returns true if n is prime.
	 */
	public static boolean isPrime(long n) {
		// First, all even numbers are not prime, so we will check for that.
		if (n % 2 == 0) {
			return false;
		}
		
		// We will check up to the square root to see if a value is prime, and only use odds to check.
		long stopVal = (long) Math.sqrt(n);
		for (long i = 3 ; i <= stopVal ; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("No number provided, exitting.");
			System.exit(0);
		}
		long value = Long.parseLong(args[0]);
		long largestPrime = 2;
		
		// 2 is a special case, and we will continually divide value by 2 until it isn't possible.
		while (value % 2 == 0) {
			value = value / 2;
		}
		
		long currentDivisor = 3;
		// Once we have done that, we will go up in prime factors, until value itself is prime or is smaller than our divisor, then take the biggest prime.
		while (!isPrime(value) && value > currentDivisor) {
			// Find the next prime in the sequence.
			while (!isPrime(currentDivisor)) {
				currentDivisor += 2;
			}
			
			// If the current divisor divides evenly, then save the current divisor as the largest and divide value.
			while (value % currentDivisor == 0) {
				largestPrime = currentDivisor;
				value = value / currentDivisor;
			}
			
			// Increment the divisor so that we get the next one in the sequence.
			currentDivisor += 2;
		}
		
		// Once we have terminated because the value is prime, we need to check if it is the greatest.
		if (largestPrime < value) {
			largestPrime = value;
		}
		
		System.out.println("The largest prime factor is : " + largestPrime);
	}
}
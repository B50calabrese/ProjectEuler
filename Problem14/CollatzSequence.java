/**
 * Used to determine the starting number that results in the largest collatz sequence.
 *
 * The collatz sequence is defined as:
 * n -> n / 2 (when n is even)
 * n -> 3n + 1 (when n is odd)
 */
public class CollatzSequence {

	/**
	 * Finds the length of the collatz sequence for the starting number.
	 * @param start the number to start with.
	 * @return the length of the collatz sequence.
	 */
	public static long collatzSequenceLength(long start) {
		long currentVal = start;
		long length = 1;
		while (currentVal != 1) {
			currentVal = (currentVal % 2 == 0) ? (currentVal / 2) : ((currentVal * 3) + 1);
			length++;
		}
		return length;
	}

	/**
	 * Finds the starting number that results in the longest collatz sequence.
	 * @param limit the upper limit, exclusive, for the starting numbers.
	 * @return the starting number of the longest sequence.
	 */
	public static long longestSequence(long limit) {
		long longest = 1;
		long start = 1;
		for (long i = 2 ; i < limit ; i++) {
			long length = collatzSequenceLength(i);
			if (length > longest) {
				longest = length;
				start = i;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Must provide an upper bound. Exiting.");
			System.exit(0);
		}
		long limit = Long.parseLong(args[0]);
		long startingNumber = longestSequence(limit);
		System.out.println("The number that provides the longest collatz sequence is : " + startingNumber);
	}
}
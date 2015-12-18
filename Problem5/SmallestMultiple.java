/**
 * Computes the smallest positive number that is divisble by the numbers 1 to n, where n is provided.
 */
public class SmallestMultiple {
	
	/**
	 * @returns true if val is divisible by the numbers 1 to n.
	 */
	public static boolean divisible(int val, int n) {
		// Here we do a brute force check, we could make this faster if we knew which
		// values from 1 to n were redundant, for instance if n = 20, then checking if
		// a number is divisible by 20 would mean the number is also divisible by 5 and 4.
		for (int i = 2 ; i <= n ; i++) {
			if (val % i != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("No value provided, exitting.");
			System.exit(0);
		}
		int n = Integer.parseInt(args[0]);
		int val = n + 1;
		while (!divisible(val, n)) {
			val += 1;
		}
		System.out.println("Smallest number evenly divisible by all values 1 to " + n + " is " + val);
	}
}
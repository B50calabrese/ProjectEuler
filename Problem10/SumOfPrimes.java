/**
 * Used to sum the primes below a certain number
 */
public class SumOfPrimes {
	private boolean[] primes;
	private int numberOfSavedValues;
	
	/**
	 * Creates a variable that keeps track of the numbers 0 to numberOfSavedValues and whether or not they are prime.
	 */
	public SumOfPrimes(int numberOfSavedValues) {
		this.numberOfSavedValues = numberOfSavedValues;
		primes = new boolean[numberOfSavedValues];
	}
	
	/**
	 * Loops through the numbers 0 to numberOfSavedValues populating the primes using a multiples method.
	 */
	private void populatePrimeList() {
		// Start with setting everything as prime above 2.
		for (int i = 2 ; i < numberOfSavedValues ; i++) {
			primes[i] = true;
		}
		
		// From here, set the multiples of the given index as composite.
		for (int i = 2 ; i < numberOfSavedValues ; i++) {
			int multiple = i + i;
			while (multiple < numberOfSavedValues) {
				primes[multiple] = false;
				multiple = multiple + i;
			}
		}
	}
	
	/**
	 * Sums the primes for the primes list.
	 */
	public long sumPrimes() {
		populatePrimeList();
		
		long sum = 0;
		
		for (int i = 0 ; i < numberOfSavedValues ; i++) {
			if (primes[i]) {
				sum += i;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Need to provide the upper bound for the primes. Exitting.");
			System.exit(0);
		}
		int n = Integer.parseInt(args[0]);
		SumOfPrimes primeSum = new SumOfPrimes(n);
		System.out.println("The sum of primes below " + n + " is " + primeSum.sumPrimes());
	}
}
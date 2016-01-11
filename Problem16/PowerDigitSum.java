import java.math.BigInteger;
/**
 * Finds the sum of digits for a given power of 2.
 */
public class PowerDigitSum {
	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Must provide a power of 2. Exiting.");
			System.exit(0);
		}
		int power = Integer.parseInt(args[0]);
		BigInteger val = new BigInteger("2");
		val = val.pow(power);
		String valString = val.toString();
		long sum = 0;
		for (int i = 0 ; i < valString.length() ; i++) {
			int digit = valString.charAt(i) - '0';
			sum += digit;
		}
		System.out.println("The sum of the digits of 2^" + power + " is " + sum);
	}
}
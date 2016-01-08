import java.math.BigInteger;
import java.util.Scanner;

/**
 * Adds really large numbers together.
 */
public class SumBigNumbers {
	public static void main(String[] args) {
		BigInteger sum = new BigInteger("0");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter big numbers, and enter 0 when finished.");
		String valString = "";
		while (!valString.equals("0")) {
			valString = scanner.next();
			BigInteger nextVal = new BigInteger(valString);
			sum = sum.add(nextVal);
		}
		String firstTenDigits = (sum.toString()).substring(0,10);
		System.out.println("The sum of the values is:");
		System.out.println(sum);
		System.out.println("The first ten digits are:");
		System.out.println(firstTenDigits);
	}
}
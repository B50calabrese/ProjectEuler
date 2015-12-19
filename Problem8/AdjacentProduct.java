/**
 * Used to find the greatest product among a certain number of adjacent numbers.
 */
public class AdjacentProduct {
	/**
	 * Finds the product of a substring in a string of digits.
	 * @param index the starting index of the substring.
	 * @param numOfDigits the number of digits to find the product of.
	 * @param data the string to find the product in.
	 * @return the product of the digits in the substring.
	 */
	public static long findProduct(int index, int numOfDigits, String data) {
		long product = 1;
		for (int i = index ; i < index + numOfDigits ; i++) {
			int currentVal = Character.getNumericValue(data.charAt(i));
			product *= currentVal;
		}
		return product;
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Must provide the number of adjacent numbers and the string to find the product in. Exitting.");
			System.out.println("Usage: java AdjacentProduct <numberOfAdjacentDigits> <stringToFindProductIn>");
			System.exit(0);
		}
		int adjacentDigits = Integer.parseInt(args[0]);
		String data = args[1];
		long largestProduct = 0;
		int currentIndex = 0;
		
		while (currentIndex + adjacentDigits <= data.length()) {
			long product = findProduct(currentIndex, adjacentDigits, data);
			largestProduct = (largestProduct > product) ? largestProduct : product;
			currentIndex++;
		}
		
		System.out.println("The greatest product of the substrings in the original string for " + adjacentDigits + " adjacent digits was " + largestProduct);
	}
}
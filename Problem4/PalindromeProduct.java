/**
 * Determines the largest palindrome formed by the product of two 3 digit numbers.
 */
public class PalindromeProduct {

	/**
	 * @returns true if the number is a palindrome.
	 */
	public static boolean isPalindrome(int val) {
		String valString = Integer.toString(val);
		int left = valString.length() - 1;
		int right = 0;
		
		// Loop using two indices to check if the characters are equal, when the
		// indices cross each other, then the loop is finished.
		while (left > right) {
			if (valString.charAt(left) != valString.charAt(right)) {
				return false;
			}
			left -= 1;
			right += 1;
		}
		return true;
	}

	public static void main(String[] args) {
		int largestProduct = 0;
		
		// Loop through each product and determine if it is a palindrome, saving it if it is the largest.
		for (int i = 100 ; i < 1000 ; i++) {
			for (int j = i ; j < 1000 ; j++) {
				int product = i * j;
				if (isPalindrome(product)) {
					largestProduct = (largestProduct > product) ? largestProduct : product;
				}
			}
		}
		System.out.println("The largest product palindrome of 3-digit numbers is : " + largestProduct);
	}
}
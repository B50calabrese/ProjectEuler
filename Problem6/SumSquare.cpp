#include <stdio.h>

// Prototypes
long sumOfSquares(int);
long squareOfSum(int);

/**
 * Squares each number up to the max and then sums the total.
 * Example:
 * 1^2 + 2^2 + ... + 10^2 = 385 when max = 10
 */
long sumOfSquares(int max) {
	long sum = 0;
	for (int i = 1 ; i <= max ; i++) {
		sum = sum + (i * i);
	}
	return sum;
}

/**
 * Sums the numbers up to the max, then squares the result.
 * Example:
 * (1 + 2 + ... + 10)^2 = 3025 when max = 10
 */
long squareOfSum(int max) {
	long sum = 0;
	for (int i = 1 ; i <= max ; i++) {
		sum = sum + i;
	}
	return (sum * sum);
}

int main(void) {
	int limit;
	printf("Input the max natural number : ");
	fflush(stdout);
	scanf_s("%d", &limit);
	
	long sumSquares = sumOfSquares(limit);
	long squareSums = squareOfSum(limit);
	long difference = squareSums - sumSquares;
	printf("The sum square difference of the natural numbers up to %d is %ld\n", limit, difference);
	return 0;
}
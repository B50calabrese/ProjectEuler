#include <stdio.h>
#include <math.h>

// Prototypes
bool isPrime(long);

/**
 * Returns true if the value provided is prime, else false.
 */
bool isPrime(long val) {
	if (val == 2) {
		return true;
	}
	if (val % 2 == 0) {
		return false;
	}
	long stopVal = sqrt((double) val);
	long i = 3;
	for (; i <= stopVal ; i = i + 2) {
		if (val % i == 0) {
			return false;
		}
	}
	return true;
}

int main(void) {
	int n;
	printf("Which prime number do you want? ");
	fflush(stdout);
	scanf_s("%d", &n);
	long currentNumber = 1;
	int counter = 0;
	
	while (counter < n) {
		do {
			currentNumber++;
		} while (!isPrime(currentNumber));
		counter++;
	}
	printf("The %dth prime number is %ld\n", n, currentNumber);
	return 0;
}
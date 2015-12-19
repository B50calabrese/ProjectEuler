#include <stdio.h>
#include <math.h>

/**
 * This will compute pythagorean triples that add up to the sum provided by the user.
 * A pythagorean triple is a triple, (a,b,c), such that:
 * a^2 + b^2 = c^2 and a < b < c
 */
int main(void) {
	int sum;
	printf("What would you like the triple to sum to? ");
	fflush(stdout);
	scanf_s("%d", &sum);
	
	// Here we will use two loops, one for a, and one for b.
	// We know the terminating condition is when a goes over a third of the sum, because
	// b and c are both greater, and thus the sum of a, b, and c would be over the sum.
	int stoppingPoint = (sum / 3) + 1;
	for (int a = 1 ; a < stoppingPoint ; a++) {
		for (int b = a + 1 ; b < sum ; b++) {
			double probableC = sqrt((double) (a * a) + (b * b));
			// This is a check to see if what we computed is actually an int.
			if (modf((double) probableC, &probableC) == 0.0) {
				int c = probableC;
				long product = a * b * c;
				// At this point we have a triplet, so now if the sum of a, b, and c is equal to the sum, then we are done.
				if (a + b + c == sum) {
					printf("Triplet found! A = %d B = %d C = %d and %d + %d + %d = %d\n", a, b, c, a, b, c, sum);
					printf("The product of %d, %d, and %d is %ld\n", a, b, c, product);
					return 0;
				}
			}
		}
	}
	
	printf("No triplet sums to %d", sum);
	return 0;
}
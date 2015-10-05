// This program is meant to find the sum of all even valued fibonnacci numbers
// up to 4 million.
#include <stdio.h>

int main()
{
    int val1 = 1;
    int val2 = 2;
    int val3 = 3;
    int sum = 2;

    while (val3 < 4000000) {
        // Calculate the next fibonnacci number.
        val3 = val1 + val2;

        // If the new number is even and below 4000000 then we can add it to the
        // running sum.
        if (val3 % 2 == 0 && val3 < 4000000) {
            sum = sum + val3;
        }

        // Now we need to move our values down.
        val1 = val2;
        val2 = val3;
    }

    printf("Sum : %i\n", sum);
    return 0;
}
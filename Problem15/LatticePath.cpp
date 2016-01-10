#include <iostream>

long long **grid;

/**
 * A recursive function that finds the number of paths from the given point.
 * The result of this function will be at the position 0,0.
 * @param x the current x position.
 * @param y the current y position.
 * @param size the size of the grid.
 */
void findPaths(int x, int y, int size) {
	long long paths = 0;
	
	if (grid[x][y] != -1) {
		return;
	}
	
	// If we are in the last position, then we are in the base case for the recursive call.
	if (x == size && y == size) {
		grid[x][y] = 1;
		return;
	}
	
	// The basic algorithm adds the number of paths from each available next position.
	if (x != size) {
		findPaths(x + 1, y, size);
		paths = paths + grid[x + 1][y];
	}
	
	if (y != size) {
		findPaths(x, y + 1, size);
		paths = paths + grid[x][y + 1];
	}
	grid[x][y] = paths;
}

/**
 * Creates a grid that keeps track of the number of paths from each point.
 */
void initializeGrid(int size) {
	// Create the array of pointers;
	grid = new long long*[size + 1];
	
	// Initiliaze each pointer to point to an array.
	for (int i = 0 ; i <= size ; i++) {
		grid[i] = new long long[size + 1];
		for (int j = 0 ; j <= size ; j++) {
			grid[i][j] = -1;
		}
	}
}

int main(void) {
	int size;
	std::cout << "Please enter the grid size\n";
	std::cin >> size;
	if (size <= 0) {
		std::cout << "Must provide a size that is greater than 0. Exiting.\n";
		return -1;
	}
	initializeGrid(size);
	
	findPaths(0, 0, size);

	std::cout << "The number of paths for a grid of size " << size << "x" << size << " is " << grid[0][0] << "\n";
	return 0;
}
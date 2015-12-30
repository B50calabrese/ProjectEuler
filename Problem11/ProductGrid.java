import java.util.Scanner;

/**
 * Finds the greatest product in a grid of numbers.
 */
public class ProductGrid {

	/**
	 * Handles the reception of the grid from the user.
	 * @return the grid of numbers the user has inputed.
	 */
	public static int[][] retrieveGrid() {
		// Used for input.
		Scanner scan = new Scanner(System.in);
		System.out.println("How many rows?");
		int rows = scan.nextInt();
		System.out.println("How many numbers per row?");
		int columns = scan.nextInt();
		int[][] grid = new int[rows][];
		System.out.println("Enter each row now");
		// Clears the buffer
		scan.nextLine();
		
		// Handles the appropriate number of rows.
		for (int i = 0 ; i < rows ; i++) {
			grid[i] = new int[columns];
			String line = scan.nextLine();

			// Use the scanner as a tokenizer, using the default spaces as delimeters.
			Scanner lineScan = new Scanner(line);
			for (int j = 0 ; j < columns ; j++) {
				grid[i][j] = Integer.parseInt(lineScan.next());
			}
		}
		
		return grid;
	}
	
	/**
	 * Finds the best product amongst n numbers in any direction.
	 * @param grid the number grid that we will find the product in.
	 * @param n the number of numbers in a row for the product.
	 * @return the greatest product of n numbers.
	 */
	public static int findProduct(int[][] grid, int n) {
		// We will loop through each position, checking all directions for validity and their product, taking the largest,
		// from all directions, and starting positions.
		// Note there could be better ways that are less redundant, such as using memoization, but this is a simple brute force approach.
		int greatestProduct = 0;
		for (int i = 0 ; i < grid.length ; i++) {
			for (int j = 0 ; j < grid[i].length ; j++) {
				int product = productAtPoint(grid, i, j, n);
				greatestProduct = (greatestProduct > product) ? greatestProduct : product;
			}
		}
		return greatestProduct;
	}
	
	/**
	 * Finds the best product at the given coordinates.
	 * @param grid the number grid.
	 * @param x the "x" coordinate.
	 * @param y the "y" coordinate.
	 * @param n the number of numbers in a row.
	 * @return the best product for all directions.
	 */
	public static int productAtPoint(int[][] grid, int x, int y, int n) {
		int product = 0;
		int testProduct;
		
		for (int i = -1 ; i <= 1 ; i++) {
			for (int j = -1 ; j <= 1 ; j++) {
				// This excludes the case of just using the same number n times.
				if (i != 0 || j != 0) {
					testProduct = productDirection(grid, x, y, i, j, n);
					product = (product > testProduct) ? product : testProduct;
				}
			}
		}
		return product;
	}
	
	/**
	 * Finds the product for the given direction.
	 * @param grid the grid of numbers.
	 * @param x the "x" coordinate.
	 * @param y the "y" coordinate.
	 * @param dx the change in x.
	 * @param dy the change in y.
	 * @param n the number of numbers in a row.
	 * @return the product for the direction, 0 if not valid.
	 */
	public static int productDirection(int[][] grid, int x, int y, int dx, int dy, int n) {
		// The final positions for x and y, we need these for the bounds checks.
		int fx = x + (dx * (n - 1));
		int fy = y + (dy * (n - 1));
		
		// If the final position falls in these bounds, then it is a valid row of numbers.
		if (fx >= 0 && fx < grid.length && fy >= 0 && fy < grid[0].length) {
			int product = 1;
			for (int i = 0 ; i < n ; i ++) {
				product *= grid[x + (i * dx)][y + (i * dy)];
			}
			return product;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[][] grid = retrieveGrid();
		System.out.println("Number of numbers in a row?");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int product = findProduct(grid, n);
		System.out.println("The greatest product in the grid is : " + product);
	}
}
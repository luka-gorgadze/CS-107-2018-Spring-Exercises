package exercises;

import java.util.Scanner;

public class SummationEfficient {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		int m;
		int element1Row;
		int element1Column;
		int element2Row;
		int element2Column;
		int[][] data;
		int sum;
		int number;

		System.out.println("Please enter number of rows and columns: ");
		n = scanner.nextInt();
		m = scanner.nextInt();
		data = new int[n][m];

		System.out.println("Please enter a table data: ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				number = scanner.nextInt();
				/*
				 * data[i][j] contains sum of all numbers with columns 0, 1, ... i and rows 0,
				 * 1, ... j. This helps for computing sum required in queries efficiently
				 */
				data[i][j] = number;
				if (i > 0) {
					data[i][j] += data[i - 1][j];
				}
				if (j > 0) {
					data[i][j] += data[i][j - 1];
				}
				if (i > 0 && j > 0) {
					data[i][j] -= data[i - 1][j - 1];
				}
			}
		}

		while (true) {
			System.out.println("Please enter indices for two points of a table: ");
			System.out.println("(Enter -1 -1 -1 -1 to quit)");
			element1Row = scanner.nextInt();
			element1Column = scanner.nextInt();
			element2Row = scanner.nextInt();
			element2Column = scanner.nextInt();

			if (element1Row == -1) {
				break;
			}

			/*
			 * because we saved data in useful form, we can answer queries in constant
			 * amount of operations instead of doing nested cycle, like in easy solution
			 */
			sum = data[element2Row][element2Column];

			if (element1Row > 0) {
				sum -= data[element1Row - 1][element2Column];
			}
			if (element1Column > 0) {
				sum -= data[element2Row][element1Column - 1];
			}
			if (element1Row > 0 && element1Column > 0) {
				sum += data[element1Row - 1][element1Column - 1];
			}

			System.out.println("Sum = " + sum);
		}

	}

}

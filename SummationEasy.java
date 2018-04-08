package exercises;

import java.util.Scanner;

public class SummationEasy {

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

		System.out.println("Please enter number of rows and columns: ");
		n = scanner.nextInt();
		m = scanner.nextInt();
		data = new int[n][m];

		System.out.println("Please enter a table data: ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				data[i][j] = scanner.nextInt();
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

			sum = 0;

			for (int i = element1Row; i <= element2Row; i++) {
				for (int j = element1Column; j <= element2Column; j++) {
					sum += data[i][j];
				}
			}

			System.out.println("Sum = " + sum);
		}

	}

}

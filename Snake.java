package exercises;

import java.util.Scanner;

public class Snake {

	public static void main(String[] args) throws InterruptedException {
		// initialize variables
		Scanner scanner = new Scanner(System.in);
		char[][] field = new char[8][30]; //board
		char[][] directions = new char[8][30]; //which direction head moved from each index
		char direction;
		int headRow = 1;
		int headColumn = 4;
		int tailRow = 1;
		int tailColumn = 1;

		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				field[i][j] = ' ';
				directions[i][j] = ' ';
			}
		}

		for (int i = 0; i < field.length; i++) {
			field[i][0] = 'A';
			field[i][field[i].length - 1] = 'A';
		}
		for (int j = 0; j < field[0].length; j++) {

			field[0][j] = 'A';
			field[field.length - 1][j] = 'A';
		}

		field[1][1] = '*';
		field[1][2] = '*';
		field[1][3] = '*';
		field[1][4] = '*';
		directions[1][1] = 'd';
		directions[1][2] = 'd';
		directions[1][3] = 'd';
		//end of initialization
		
		while (true) {
			//clear the console, btw there are some better ways for doing this, google it
			for (int i = 0; i < 50; ++i)
				System.out.println();

			//print the board
			for (int i = 0; i < field.length; i++) {
				for (int j = 0; j < field[i].length; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}

			//ask for the input
			System.out.print("Please enter the move(a,s,d or w) or q to quit: ");
			
			//get input from the user
			direction = scanner.next().charAt(0);
			
			//check for quit condition
			if(direction == 'q') {
				break;
			}
			
			//ask for input again if invalid input was entered
			if(direction != 'w' && direction != 'a' && direction != 's' && direction != 'd') {
				continue;
			}

			//try to move head indices if there is no obstacle, keep track of where snake moved
			switch (direction) {
			case 'w':
				if (field[headRow - 1][headColumn] != ' ') {
					continue;
				}
				directions[headRow][headColumn] = 'w';
				headRow--;
				break;
			case 'a':
				if (field[headRow][headColumn - 1] != ' ') {
					continue;
				}
				directions[headRow][headColumn] = 'a';
				headColumn--;
				break;
			case 's':
				if (field[headRow + 1][headColumn] != ' ') {
					continue;
				}
				directions[headRow][headColumn] = 's';
				headRow++;
				break;
			case 'd':
				if (field[headRow][headColumn + 1] != ' ') {
					continue;
				}
				directions[headRow][headColumn] = 'd';
				headColumn++;
				break;
			}

			//move snake in the array
			field[headRow][headColumn] = '*';
			field[tailRow][tailColumn] = ' ';
			
			//move tail indices
			switch (directions[tailRow][tailColumn]) {
			case 'w':
				tailRow--;
				break;
			case 'a':
				tailColumn--;
				break;
			case 's':
				tailRow++;
				break;
			case 'd':
				tailColumn++;
				break;
			}
		}
	}

}

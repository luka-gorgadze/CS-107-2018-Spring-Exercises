package exercises;

import java.util.Scanner;

public class RecurringCharacterEasy {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		boolean found = false;

		System.out.print("Please enter a string of characters: ");
		input = scanner.next();

		for (int i = 0; i < input.length() && found == false; i++) {
			for (int j = i + 1; j < input.length(); j++) {
				if (input.charAt(i) == input.charAt(j)) {
					found = true;
					System.out.println("First recurring character is : " + input.charAt(i));
					break;
				}
			}
		}
		if (!found) {
			System.out.println("The string doesn't contain recurring character");
		}
	}

}

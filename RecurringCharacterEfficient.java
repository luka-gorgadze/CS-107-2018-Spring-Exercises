package exercises;

import java.util.Scanner;

public class RecurringCharacterEfficient {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] frequencies = new int[26];
		String input;
		boolean found = false;

		System.out.print("Please enter a string of characters: ");
		input = scanner.next().toLowerCase();

		// count frequencies
		for (int i = 0; i < input.length(); i++) {
			frequencies[input.charAt(i) - 'a']++;
		}

		// find first recurring character
		for (int i = 0; i < input.length(); i++) {
			if (frequencies[input.charAt(i) - 'a'] > 1) {
				found = true;
				System.out.println("First recurring character is : " + input.charAt(i));
				break;
			}
		}
		if (!found) {
			System.out.println("The string doesn't contain recurring character");
		}
	}

}

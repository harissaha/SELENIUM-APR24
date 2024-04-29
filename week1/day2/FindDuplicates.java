package week1.day2;

import java.util.Arrays;

public class FindDuplicates {

	public static void main(String[] args) {
		int[] input = { 2, 5, 7, 7, 5, 9, 2, 3 };
		Arrays.sort(input);
		System.out.println("Duplicate output: ");
		for (int i = 0; i < input.length - 1; i++) {
			if (input[i] == input[i + 1]) {
				System.out.println(input[i]);
			}

		}
	}

}

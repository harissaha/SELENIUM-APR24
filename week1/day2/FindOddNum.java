package week1.day2;

import java.util.Iterator;

public class FindOddNum {

	public static void main(String[] aargs) {

		int maxRange = 10;
		System.out.println("Below are the ODD Numbers:");
		for (int i = 0; i < maxRange; i++) {
			if (i % 2 != 0) {
				System.out.println(i);
			}
		}
	}

}

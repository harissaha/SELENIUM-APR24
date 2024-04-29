package week1.assignments;

public class FibonacciSeries {

	public static void main(String[] args) {
		int range = 8;
		int f = 0;
		int s = 1;
		int c;
		System.out.print(f + "," + s + ",");
		for (int i = 0; i <= range; i++) {
			c = f + s;
			f = s;
			s = c;
			if (i != range) {
				System.out.print(c + ",");
			} else {
				System.out.println(c);
			}
		}
	}

}

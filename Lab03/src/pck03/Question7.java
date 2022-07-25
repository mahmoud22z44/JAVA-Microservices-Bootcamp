package pck03;

public class Question7 {
	int a;

	public Question7() {
		a = (int) (Math.random() * ((7 - 1) + 1)) + 1;
		System.out.println(a);
		int fact = 1, i;
		for (i = 1; i <= a; i++) {
			fact *= i;
		}
		System.out.println("The factorial value is " + fact);

//		---------------------------------------------------------------
//		question8
		// for loop
		// incremental loop
		for (i = 1; i <= a; i++) {
			if (i != a)
				System.out.print(i + "X");
			else
				System.out.println(i);
		}
		// decremental loop
		for (i = a; i > 0; i--) {
			if (i != 1)
				System.out.print(i + "X");
			else
				System.out.println(i);
		}
		// while loop
		// incremental loop
		i = 1;
		while (i++ <= a) {
			if (i != a)
				System.out.print(i + "X");
			else
				System.out.println(i);

		}
		// decremental loop
		i = a;
		while (i-- > 0) {
			if (i != 1)
				System.out.print(i + "X");
			else
				System.out.println(i);
		}
	}
}
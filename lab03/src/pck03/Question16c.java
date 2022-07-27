package pck03;

public class Question16c {
	int number;
	public Question16c() {
		number = (int) (Math.random() * ((50 - 10) + 10)) + 10;
		Question16a fib = new Question16a();
		for (int i = 0; i < fib.fibonacci.length; i++) {
			if(fib.fibonacci[i]< number) {
				System.out.print(fib.fibonacci[i]+",");
			}
			System.out.println(" ");
		}
	}
}

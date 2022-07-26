package pck03;

public class Question12 {
	int number;
	int oppositeNumber;
	public Question12() {
		number = (int) (Math.random() * 10000);
		System.out.print("question 12 [" + number + "-> ");
		oppositeNumber = 0;
		while (number > 0) {
			oppositeNumber += number % 10;
			oppositeNumber *= 10;
			number /= 10;
		}
		System.out.println(oppositeNumber + "]");
	}

	public Question12(int number) {
		super();
		this.number = number;
		oppositeNumber = 0;
		while (number > 0) {
			oppositeNumber += number % 10;
			oppositeNumber *= 10;
			number /= 10;
		}
	}

}

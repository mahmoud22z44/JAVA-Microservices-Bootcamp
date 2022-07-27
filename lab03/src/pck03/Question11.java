package pck03;

public class Question11 {
	int number;

	public Question11() {
		number = (int) (Math.random() * 10000);
		System.out.print("question 11 ["+number+"-> ");
		while(number > 10 ) {
			number /= 10;
		}
		System.out.println(number+"]");
	}

	public Question11(int number) {
		super();
		this.number = number;
		while(number > 10 ) {
			number /= 10;
		}
	}
	
}

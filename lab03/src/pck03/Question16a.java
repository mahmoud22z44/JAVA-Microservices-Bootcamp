package pck03;

public class Question16a {
	int[] fibonacci;
	public Question16a() {
		fibonacci = new int[40];
		fibonacci[0]= 1;
		fibonacci[1]= 1;
		for (int i = 2; i < 40; i++) {
			fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
		}
	}
}

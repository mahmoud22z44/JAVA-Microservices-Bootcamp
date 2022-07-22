package pck02;

public class ThreeRandomNumberSmall {
	public int number1;
	public int number2;
	public int number3;
	public ThreeRandomNumberSmall() {
		number1 = (int)(Math.random()*101);
		number2 = (int)(Math.random()*101);
		number3 = (int)(Math.random()*101);
		System.out.println("the smaller value is "+Math.min(Math.min(number1, number2), number3));
	}
}

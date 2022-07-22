package pck02;

public class ThreeRandomNumberBig {
	public int number1;
	public int number2;
	public int number3;
	public ThreeRandomNumberBig() {
		number1 = (int)(Math.random()*101);
		number2 = (int)(Math.random()*101);
		number3 = (int)(Math.random()*101);
		System.out.println("the bigger value is "+Math.max(Math.max(number1, number2), number3));
	}
	
}

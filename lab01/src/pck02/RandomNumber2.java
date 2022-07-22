package pck02;

public class RandomNumber2 {
	public int randomNumber;
	public RandomNumber2() {
		randomNumber = (int)(Math.random() * 101);
		if(randomNumber<50 && randomNumber > 0)
			System.out.println("Small!");
		else
			System.out.println("Big!");
		if(randomNumber%2==0)
			System.out.println("Even");
		else
			System.out.println("Odd");
	}
}

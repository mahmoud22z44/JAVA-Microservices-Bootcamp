package pck02;

public class RandomNumber {
	public int randomNumber;
	public RandomNumber() {
		randomNumber = (int)(Math.random() * 101);
		if(randomNumber>50)
			System.out.println("Big!");
		else if(randomNumber<50)
			System.out.println("Small!");
		else
			System.out.println("Bingo!");
	}
	
}

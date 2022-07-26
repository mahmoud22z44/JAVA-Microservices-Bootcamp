package pck03;

public class Question14 {
int number;
public Question14() {
	number = (int)(Math.random()*10000);
	Question12 opposite = new Question12(number);
	if(number == opposite.oppositeNumber)
		System.out.println("The number "+number +" is palindrome");
	else
		System.out.println("The number "+number +" is't palindrome");
}
}

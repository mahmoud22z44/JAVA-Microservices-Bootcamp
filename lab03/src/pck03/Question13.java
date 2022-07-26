package pck03;

public class Question13 {
int number;
public Question13() {
	number = (int)(Math.random()*10000);
	int copyNum = number;
	Question9 numOfDigit = new Question9(number);
	Question11 leftDigit = new Question11(number);
	Question12 oppositNum = new Question12(number);
	int sum = 0; 
	while(number>0) {
		sum += number%10;
		number /= 10;
	}
	System.out.println("Number of digits ["+copyNum+" -> "+numOfDigit.counter+"]");
	System.out.println("The first lift digit ["+copyNum+" -> "+leftDigit.number+"]");
	System.out.println("Sum of the number's digits ["+copyNum+" -> "+sum+"]");
	System.out.println("Opposite order of the number’s digits  ["+copyNum+" -> "+oppositNum.oppositeNumber+"]");
}
}

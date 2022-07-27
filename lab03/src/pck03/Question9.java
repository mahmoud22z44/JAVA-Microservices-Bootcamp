package pck03;

public class Question9 {
int number;
int counter;
public Question9() {
	number = (int)(Math.random()*10000);
	System.out.print("question 9 ["+number+"-> ");
	counter = 0;
	while(number/10 > 0) {
		counter++;
		number /= 10;
	}
	System.out.println(counter+"]");
}
public Question9(int number) {
	super();
	this.number = number;
	counter = 0;
	while(number/10 > 0) {
		counter++;
		number /= 10;
	}
}

}

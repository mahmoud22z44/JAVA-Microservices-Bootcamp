package pck03;

public class Question16b {
int index;
public Question16b() {
	index = (int) (Math.random() * 40) ;
	Question16a fib = new Question16a();
	System.out.println("["+index+"->"+fib.fibonacci[index]+"]");
}
}

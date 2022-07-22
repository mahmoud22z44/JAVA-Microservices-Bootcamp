package pck01;

public class Comparison {
	public int a;
	public int b;
	public Comparison() {
		a = (int)(Math.random()*101);
		b = (int)(Math.random()*101);
		System.out.println("The bigger value is "+Math.max(a,b));
	}
	public String toString() {
		return ("The bigger value is "+Math.max(a,b));
	}
}

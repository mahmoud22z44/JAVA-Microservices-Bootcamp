package pck01;

public class Test {
	public int a;
	public int b;
	
	public Test() {
		a = (int)(Math.random()*101);
		b = (int)(Math.random()*101);
		System.out.println("A: "+a);
		System.out.println("B: "+b);
		System.out.println("The sum of the numbers: "+(a+b));
		System.out.println("The average value: "+((a+b)/2));
		System.out.println("The remainder when dividing A in 10: "+(a%10));
		System.out.println("The remainder when dividing B in 10: "+(b%10));
		System.out.println("The area of a rectangle: "+(a*b));
	}
	
	public String toString() {
		return ("A: "+a+"\nB: "+b+"\nThe sum of the numbers: "+(a+b)
	+"\nThe average value: "+((a+b)/2)
	+"\nThe remainder when dividing A in 10: "+(a%10)
	+"\nThe remainder when dividing B in 10: "+(b%10)
	+"\nThe area of a rectangle: "+(a*b));
	}
}

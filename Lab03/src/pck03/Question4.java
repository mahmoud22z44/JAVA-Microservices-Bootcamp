package pck03;

public class Question4 {
	int a ;
	int b ;
	public Question4() {
		a = (int)(Math.random()*101);
		b = (int)(Math.random()*101);
		if(a >= b) {
			b++;
			while(b++ < a) {
				System.out.println(b);
			}
		}else {
			a++;
			while(a++ < b) {
				System.out.println(a);
			}
		}
	}
}

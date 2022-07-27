package pck03;

public class Question6 {
int max;
int den;
public Question6() {
	max = (int)(Math.random()*101);
	den = (int)(Math.random()*101);
	for (int i = 0; i <= max; i++) {
		if(i%den == 0) {
			System.out.println(i);
		}
	}
}
}

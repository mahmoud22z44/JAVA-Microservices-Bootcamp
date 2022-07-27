package pck03;

public class Question15 {
int number;
public Question15() {
	number = (int)(Math.random()*101);
	if(number%7==0) {
		System.out.println("boom");
	}else {
		int copy = number;
		while(copy > 0) {
			if(copy%10 == 7) {
				System.out.println("boom");
				return;
			}
			copy /= 10;
		}
		System.out.println(number);
	}
}
}

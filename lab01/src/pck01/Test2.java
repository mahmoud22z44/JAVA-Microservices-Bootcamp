package pck01;

public class Test2 {
	public int randomNumber;
	public Test2() {
		randomNumber = (int)(Math.random() * ((350 - 100) + 1)) + 100;
		int hour = randomNumber/60;
		int min = randomNumber%60;
		System.out.println("The time in minutes: "+randomNumber+"\nThe time in terms of Hours and Minutes: "+hour+":"+min);
	
	}
	public String toString() {
		int hour = randomNumber/60;
		int min = randomNumber%60;
		return("The time in minutes: "+randomNumber+"\nThe time in terms of Hours and Minutes: "+hour+":"+min);
	}
}

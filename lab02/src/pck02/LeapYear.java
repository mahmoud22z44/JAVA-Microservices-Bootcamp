package pck02;

public class LeapYear {
	public int year;
	public LeapYear() {
		year = (int)(Math.random() * ((2022 - 0) + 1)) + 0;
		if( year%4 == 0 && year%100 != 0) {
			System.out.println("this year: "+year+" is leap");
		}else if(year%400 == 0)
			System.out.println("this year: "+year+" is leap");
		else
			System.out.println("this year: "+year+" is't leap");
			
	}
}

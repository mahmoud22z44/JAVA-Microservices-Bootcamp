package pck02;

public class TaxCalculator {
	public int salary;
	public TaxCalculator() {
		salary = (int)(Math.random()*100000);
		int tax = 0;
		System.out.println("The salary before tax is "+salary);
		if(salary>0 && salary<23000)
			tax = (salary*10/100);
		else if(salary<50000 && salary>=23000)
			tax = (salary*20/100);
		else if(salary<100000 && salary>=50000)
			tax = (salary*30/100);
		else
			tax = (salary*40/100);
		System.out.println("The tax calculation is "+tax);
		salary -= tax;
		System.out.println("The salary after tax is "+salary);
		
	}
}

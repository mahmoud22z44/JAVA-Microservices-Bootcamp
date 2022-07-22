package pck02;

public class SalaryRaiser {
	public int salary;
	public SalaryRaiser() {
		salary = (int)(Math.random() * ((6000 - 5000) + 1)) + 5000;
		System.out.println("The current salary: "+salary);
		int updatSalary = salary + (salary*10/100);
		if (updatSalary <= 6000) {
			salary = updatSalary;
			System.out.println("The update salary: "+salary);
		}
		else {
			salary += (salary*5/100);
			System.out.println("The update salary: "+salary);
		}
	}
}

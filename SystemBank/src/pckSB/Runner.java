package pckSB;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a = new Account(101, 100);
		RegularClient rc1 = new RegularClient(111, "mahmoud", 200);
		GoldClient GC1 = new GoldClient(222, "mazen", 50);
		PlatinumClient pc1 = new PlatinumClient(333, "momen", 0);
		Bank jerusalem = new Bank();
		jerusalem.addClient(pc1);
		jerusalem.addClient(GC1);
		System.out.println(jerusalem.getBalance());
		pc1.addAccount(a);
		System.out.println(jerusalem.getBalance());
		System.out.println(GC1.getBalance());
		System.out.println(pc1.getFortune());
		jerusalem.removeClient(333);
		jerusalem.addClient(rc1);
		System.out.println(jerusalem.getBalance());
	}

}

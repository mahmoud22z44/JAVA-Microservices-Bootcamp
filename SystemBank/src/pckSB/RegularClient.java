package pckSB;

public class RegularClient extends Client {

	public RegularClient(int id, String name, float balance) {
		super(id, name, balance);
		this.commissionRate = (3/100);
		this.interestRate = (float) (0.1/100);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Client Regular ID :"+ this.getId();
	}
}

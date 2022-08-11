package pckSB;

public class PlatinumClient extends Client {

	public PlatinumClient(int id, String name, float balance) {
		super(id, name, balance);
		this.commissionRate = (1/100);
		this.interestRate = (float) (0.5/100);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Client Platinum ID :"+ this.getId();
	}
}

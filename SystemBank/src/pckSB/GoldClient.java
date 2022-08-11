package pckSB;

public class GoldClient extends Client {

	public GoldClient(int id, String name, float balance) {
		super(id, name, balance);
		this.commissionRate = (2/100);
		this.interestRate = (float) (0.3/100);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Client Gold ID :"+ this.getId();
	}
}

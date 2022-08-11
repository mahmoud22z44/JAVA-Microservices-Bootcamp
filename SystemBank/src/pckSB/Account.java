package pckSB;

public class Account {
	private int id;
	private float balance;

	public Account(int id, float balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		Logger.log(new Log(0, this.id, "account update – opened", this.balance));
		this.balance = balance;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Account)) {
			return false;
		}
		Account a = (Account) obj;
		if (this.id == a.id) {
			return true;
		}
		return false;
	}
}

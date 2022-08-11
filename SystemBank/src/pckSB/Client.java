package pckSB;

public abstract class Client {
	private int id;
	private String name;
	private float balance;
	private Account[] accounts;
	private Logger logger;
	protected float commissionRate;
	protected float interestRate;

	public Client(int id, String name, float balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.logger = new Logger(null);
		this.accounts = new Account[5];
		this.commissionRate = 0;
		this.interestRate = 0;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	private boolean checkAccountExist(Account account) {
		for (int i = 0; i < this.accounts.length; i++) {
			if(this.accounts[i]!=null)
				if (this.accounts[i].equals(account)) {
					return true;
				}
		}
		return false;
	}
	public void addAccount(Account account) {
		if (!checkAccountExist(account)) {
			for (int i = 0; i < this.accounts.length; i++) {
				if (this.accounts[i] == null) {
					this.accounts[i] = account;
					Logger.log(new Log(0, this.accounts[i].getId(), "account update – opened",
							this.accounts[i].getBalance()));
					return;
				}
			}
		}
	}

	public Account getAccount(int id) {
		for (int i = 0; i < this.accounts.length; i++) {
			if (this.accounts[i].getId() == id)
				return this.accounts[i];
		}
		return null;
	}

//	public void removeAccount(int id) {
//		for (int i = 0; i < this.accounts.length; i++) {
//			if (this.accounts[i].getId() == id) {
//				this.setBalance((this.balance + this.accounts[i].getBalance()));
//				this.logger.log(
//						new Log(0, this.accounts[i].getId(), "account update – cosed", this.accounts[i].getBalance()));
//				this.accounts[i] = null;
//			}
//		}
//	}
	public void removeAccount(Account account) {
		for (int i = 0; i < this.accounts.length; i++) {
			if(this.accounts[i]!= null)
				if (this.accounts[i].equals(account)) {
					this.setBalance((this.balance + this.accounts[i].getBalance()));
					Logger.log(
							new Log(0, this.accounts[i].getId(), "account update – cosed", this.accounts[i].getBalance()));
					this.accounts[i] = null;
					return;
				}
		}
	}

	public void deposit(float number) {// number - commission
		this.setBalance((this.balance + (number - (number * this.commissionRate))));
	}

	public void withdraw(float number) {// number + commission
		this.setBalance((this.balance - (number + (number * this.commissionRate))));
	}

	public void autoUpdateAccounts() {

	}

	public float getFortune() {
		float sum = this.getBalance();
		for (int i = 0; i < this.accounts.length; i++) {
			if(this.accounts[i]!= null) {
			sum += this.accounts[i].getBalance();
			}
		}
		return sum;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Client)) {
			return false;
		}
		Client c = (Client) obj;
		if (this.id == c.id) {
			return true;
		}
		return false;
	}
}

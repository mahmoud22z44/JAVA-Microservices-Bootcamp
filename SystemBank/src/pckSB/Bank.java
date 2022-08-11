package pckSB;

import java.util.Arrays;

public class Bank {

	private Client[] clients;
	private Logger logService;
	private static float totalCommission;

	public Bank() {
		super();
		this.clients = new Client[100];
	}

	public float getBalance() {
		float sum = 0;
		for (int i = 0; i < this.clients.length; i++) {
			if(this.clients[i]!= null)
				sum += this.clients[i].getFortune();
		}
		return sum;
	}
	
	private boolean checkClientExist(Client client) {
		for (int i = 0; i < this.clients.length; i++) {
			if (this.clients[i] != null && this.clients[i].getId() == client.getId()) {
				return true;
			}
		}
		return false;
	}

	public void addClient(Client client) {
		if (!checkClientExist(client)) {
			for (int i = 0; i < this.clients.length; i++) {
				if (this.clients[i] == null) {
					this.clients[i] = client;
					Logger.log(new Log(0, client.getId(), "client added", client.getFortune()));
					return;
				}
			}
		}
	}

	public void removeClient(int id) {
		for (int i = 0; i < this.clients.length; i++) {
			if (this.clients[i]!= null && this.clients[i].getId() == id) {
				Logger.log(new Log(0, this.clients[i].getId(), "client removed", this.clients[i].getFortune()));
				this.clients[i] = null;
				return;
			}
		}
	}

	public Client[] getClients() {
		return this.clients;
	}

	public void viewLogs() {
	}

	public void startAccountUpdater() {
	}

	public static void updateTotalCommission(float number) {
		totalCommission = number;
	}

	public void printClientList() {
		for (int i = 0; i < clients.length; i++) {
			System.out.println(this.clients[i]);
		}
	}

}

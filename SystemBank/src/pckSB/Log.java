package pckSB;

public class Log {
	//describes the time of action occurrence
		private long timestamp;
		//the client-Id owning this action
		private int client_id;
		//short description of the action (messages are detailed in previous section)
		private String description ;
		//the amount of money of this action
		private float amount;
		
		public Log(long timestamp, int client_id, String description, float amount) {
			super();
			this.timestamp = timestamp;
			this.client_id = client_id;
			this.description = description;
			this.amount = amount;
		}
		public String toString() {
			return '"'+this.timestamp+", client-"+this.client_id+", "+this.description+", "+this.amount;
		}
}

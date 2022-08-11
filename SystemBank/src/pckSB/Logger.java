package pckSB;

public class Logger {
	private String driverName;

	public Logger(String driverName) {
		super();
		this.driverName = driverName;
	}
	
	public static void log(Log log) {
//		System.out.println(log.getData());
		System.out.println(log);
	}

	public Log[] getLogs() {
		return null;
	}
}

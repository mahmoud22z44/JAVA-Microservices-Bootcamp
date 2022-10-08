package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ConnectionPool {

	private Set<Connection> connections = new LinkedHashSet<Connection>(10);
	private static ConnectionPool instance = null;
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306";
	private String user = "root";
	private String password = "1234";

	private ConnectionPool() {
		try {
			for (int i = 0; i < 10; i++) {
				Connection conn = null;
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
				connections.add(conn);
				
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public synchronized static ConnectionPool getInstance() {
		if (instance == null) {
			
			instance = new ConnectionPool();
		}

		return instance;
	}

	public synchronized Connection getConnection() {
		Connection conn = null;
		if (connections.isEmpty())
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

		else {
			Iterator<Connection> it = connections.iterator();
			conn = it.next();
			connections.remove(conn);
		}
		return conn;
	}

	public synchronized void restoreConnection(Connection connection) {
		if (connections.size() < 10) {
			if (connection != null) {
				connections.add(connection);
				notify();
			}

			else {
				try {
					Class.forName(driver);
					connection = DriverManager.getConnection(url, user, password);
					connections.add(connection);
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	public void closeAllConnections() {
		for (Connection connection : connections) {
			try {
				connection.close();
			} catch (SQLException e) {
				try {
					connection.close();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
				System.out.println(e.getMessage());
			}
		}
	}
}

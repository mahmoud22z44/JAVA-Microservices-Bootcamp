package couponeSystemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import couponeSystemBeans.Customer;
import database.ConnectionPool;

public class CustomersDBDAO implements CustomersDAO {
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public boolean isCustomerExists(String email, String password) {
		Connection conn = connectionPool.getConnection();
		String query = "SELECT * FROM customers";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				String emailDB = rs.getString("Email");
				String passwordDB = rs.getString("Password");
				if (emailDB.equals(email) && passwordDB.equals(passwordDB)) {
					st.close();
					conn.close();
					return true;
				}
			}
			st.close();
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public void addCustomer(Customer customer) {
		Connection conn = connectionPool.getConnection();
		String query = " insert into customers (ID, FIRST_NAME, LAST_NAME, Email, Password)"
				+ " values (?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, customer.getId());
			preparedStmt.setString(2, customer.getFirstName());
			preparedStmt.setString(3, customer.getLastName());
			preparedStmt.setString(4, customer.getEmail());
			preparedStmt.setString(5, customer.getPassword());
			preparedStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		try {
			Connection conn = connectionPool.getConnection();
			String query = "update customers set FIRST_NAME = ? ,LAST_NAME = ? , Email = ? , Password = ? where ID = ? ";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, customer.getFirstName());
			preparedStmt.setString(2, customer.getLastName());
			preparedStmt.setString(3, customer.getEmail());
			preparedStmt.setString(4, customer.getPassword());
			preparedStmt.setInt(5, customer.getId());
			preparedStmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void deleteCustomer(int customerID) {
		try {
			Connection conn = connectionPool.getConnection();
			String query = "delete customers where ID = ? ";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, customerID);
			preparedStmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public ArrayList<Customer> getAllCustomers() {
		ArrayList<Customer> customers = new ArrayList<>();
		Connection conn = connectionPool.getConnection();
		String query = "SELECT * FROM customers";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				customers.add(new Customer(rs.getInt("ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),
						rs.getString("Email"), rs.getString("Password"), null));
			}
			st.close();
			conn.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return customers;
	}

	@Override
	public Customer getOneCustomer(int customerID) {
		ArrayList<Customer> customers = this.getAllCustomers();
		for (Customer var : customers) {
			if (var.getId() == customerID) {
				return var;
			}
		}
		return null;
	}

}

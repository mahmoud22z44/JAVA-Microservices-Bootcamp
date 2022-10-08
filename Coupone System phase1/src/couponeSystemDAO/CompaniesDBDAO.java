package couponeSystemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import couponeSystemBeans.Company;
import database.ConnectionPool;

public class CompaniesDBDAO implements CompaniesDAO {

	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public boolean isCompanyExists(String email, String password) {
		Connection conn = connectionPool.getConnection();
		String query = "SELECT * FROM companies";
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
	public void addCompany(Company company) {
		Connection conn = connectionPool.getConnection();
		String query = " insert into companies (ID, Name, Email, Password)" + " values (?, ?, ?, ?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, company.getId());
			preparedStmt.setString(2, company.getName());
			preparedStmt.setString(3, company.getEmail());
			preparedStmt.setString(4, company.getPassword());
			preparedStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateCompany(Company company) {
		try {
			Connection conn = connectionPool.getConnection();
			String query = "update companies set Name = ? , Email = ? , Password = ? where ID = ? ";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, company.getName());
			preparedStmt.setString(2, company.getEmail());
			preparedStmt.setString(3, company.getPassword());
			preparedStmt.setInt(4, company.getId());
			preparedStmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public void deleteCompany(int companyID) {
		try {
			Connection conn = connectionPool.getConnection();
			String query = "delete companies where ID = ? ";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, companyID);
			preparedStmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public ArrayList<Company> getAllCompanies() {
		
		ArrayList<Company> companies = new ArrayList<>();
		Connection conn = connectionPool.getConnection();
		
		String query = "SELECT * FROM companies";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				companies.add(new Company(rs.getInt("ID"), rs.getString("Name"), rs.getString("Email"),
						rs.getString("Password"), null));
			}
			st.close();
			conn.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return companies;
	}

	@Override
	public Company getOneCompany(int companyID) {
		ArrayList<Company> companies = this.getAllCompanies();
		for(Company var : companies) {
			if(var.getId() == companyID) {
				return var;
			}
		}
		return null;
	}

}

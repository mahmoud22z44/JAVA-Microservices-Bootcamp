package couponeSystemDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import couponeSystemBeans.Coupon;
import database.ConnectionPool;

public class CouponsDBDAO implements CouponsDAO {

	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public void addCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		Connection conn = connectionPool.getConnection();
		String query = " insert into coupons (ID, COMPANY_ID, CATEGORY_ID, TITLE, DESCRIPTION, START_DATE, END_DATE, AMOUNT, PRICE, IMAGE)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, coupon.getId());
			preparedStmt.setInt(2, coupon.getCompanyID());
//			preparedStmt.setint(3, coupon.getCategory());
			preparedStmt.setString(4, coupon.getTitle());
			preparedStmt.setString(5, coupon.getDescripion());
			preparedStmt.setDate(6, (Date) coupon.getStartDate());
			preparedStmt.setDate(7, (Date) coupon.getEndDate());
			preparedStmt.setInt(8, coupon.getAmount());
			preparedStmt.setDouble(9, coupon.getPrice());
			preparedStmt.setString(10, coupon.getImage());
			preparedStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		try {
			Connection conn = connectionPool.getConnection();
			String query = "update coupons set COMPANY_ID = ? , CATEGORY_ID = ? , TITLE = ? , DESCRIPTION = ? , START_DATE = ? , END_DATE = ? , AMOUNT = ? , PRICE = ? , IMAGE = ? where ID = ? ";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, coupon.getCompanyID());
//			preparedStmt.setint(2, coupon.getCategory());
			preparedStmt.setString(3, coupon.getTitle());
			preparedStmt.setString(4, coupon.getDescripion());
			preparedStmt.setDate(5, (Date) coupon.getStartDate());
			preparedStmt.setDate(6, (Date) coupon.getEndDate());
			preparedStmt.setInt(7, coupon.getAmount());
			preparedStmt.setDouble(8, coupon.getPrice());
			preparedStmt.setString(9, coupon.getImage());
			preparedStmt.setInt(10, coupon.getId());
			preparedStmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void deleteCoupon(int couponID) {
		// TODO Auto-generated method stub
		try {
			Connection conn = connectionPool.getConnection();
			String query = "delete coupons where ID = ? ";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, couponID);
			preparedStmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public ArrayList<Coupon> getAllCoupons() {
		ArrayList<Coupon> coupons = new ArrayList<>();
		Connection conn = connectionPool.getConnection();
		String query = "SELECT * FROM coupons";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				coupons.add(new Coupon(rs.getInt("ID"), rs.getInt("COMPANY_ID"), null, rs.getString("TITLE"),
						rs.getString("DESCRIPTION"), rs.getDate("START_DATE"), rs.getDate("END_DATE"),
						rs.getInt("AMOUNT"), rs.getInt("PRICE"), rs.getString("IMAGE")));
			}
			st.close();
			conn.close();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return coupons;
	}

	@Override
	public Coupon getOneCoupon(int couponID) {
		ArrayList<Coupon> coupons = this.getAllCoupons();
		for (Coupon var : coupons) {
			if (var.getId() == couponID) {
				return var;
			}
		}
		return null;
	}

	@Override
	public void addCouponPurchase(int customerID, int couponID) {
		Connection conn = connectionPool.getConnection();
		String query = " insert into customers_vs_coupons (CUSTOMER_ID , COUPON_ID)" + " values (?, ?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, customerID);
			preparedStmt.setInt(2, couponID);
			preparedStmt.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCouponPurchase(int customerID, int couponID) {
		// TODO Auto-generated method stub
		try {
			Connection conn = connectionPool.getConnection();
			String query = "delete customers_vs_coupons where customerID = ? AND  couponID = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setInt(1, customerID);
			preparedStmt.setInt(2, couponID);
			preparedStmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}

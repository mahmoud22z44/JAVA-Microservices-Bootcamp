package couponSystemFacade;

import java.util.ArrayList;

import couponeSystemBeans.Category;
import couponeSystemBeans.Coupon;
import couponeSystemBeans.Customer;

public class CustomerFacade extends ClientFacade {

	private int customerID;

	@Override
	public boolean login(String email, String password) {
		ArrayList<Customer> customers = this.customersDAO.getAllCustomers();
		for (Customer var : customers) {
			if(var.getEmail().equals(email) && var.getPassword().equals(password)) {
				return this.customersDAO.isCustomerExists(email, password);
			}
		}
		return false;
	}

	public CustomerFacade(int customerID) {
		super();
		this.customerID = customerID;
	}

	public void purchaseCoupon(Coupon coupon) {
		
		this.couponsDAO.addCouponPurchase(customerID, coupon.getId());
	}

	public ArrayList<Coupon> getCustomerCoupons() {
		return null;
	}

	public ArrayList<Coupon> getCustomerCoupons(Category category) {
		return null;
	}

	public ArrayList<Coupon> getCustomerCoupons(double maxPrice) {
		return null;
	}

	public Customer getCustomerDetails() {
		return this.customersDAO.getOneCustomer(customerID);
	}
}

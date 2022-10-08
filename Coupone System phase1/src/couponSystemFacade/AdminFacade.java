package couponSystemFacade;

import java.util.ArrayList;

import couponeSystemBeans.Company;
import couponeSystemBeans.Coupon;
import couponeSystemBeans.Customer;

public class AdminFacade extends ClientFacade {

	@Override
	public boolean login(String email, String password) {
		if (email.equals("admin@admin.com") && password.equals("admin")) {
			return true;
		}
		return false;
	}

	public void addCompany(Company company) {
	
		ArrayList<Company> companies = this.companiesDAO.getAllCompanies();	
		System.out.println("hi");
		for (Company var : companies) {
			if (var.getEmail().equals(company.getEmail()) || var.getName().equals(company.getName())) {
				System.out.println("The company name or email are existing");
				return;
			}
		}
		System.out.println("yes i'm here");
		this.companiesDAO.addCompany(company);
	}

	public void updateCompany(Company company) {
		ArrayList<Company> companies = this.companiesDAO.getAllCompanies();
		for (Company var : companies) {
			if (var.getId() == company.getId() && var.getName().equals(company.getName())) {
				this.companiesDAO.updateCompany(company);
				return;
			}
		}
		System.out.println("Error the company name or code are changed ");
	}

	public void deleteCompany(int companyID) {
		ArrayList<Coupon> coupons = this.couponsDAO.getAllCoupons();
		for (Coupon var : coupons) {
			if (var.getCompanyID() == companyID) {
				this.couponsDAO.deleteCoupon(var.getId());
			}
		}
		this.companiesDAO.deleteCompany(companyID);
	}

	public ArrayList<Company> getAllCompanies() {
		return this.companiesDAO.getAllCompanies();
	}

	public Company getOneCompany(int companyID) {
		return this.companiesDAO.getOneCompany(companyID);
	}

	public void addCustomer(Customer customer) {
		ArrayList<Customer> customers = this.customersDAO.getAllCustomers();
		for (Customer var : customers) {
			if (var.getEmail().equals(customer.getEmail())) {
				System.out.println("The customer email are existing");
				return;
			}
		}
		this.customersDAO.addCustomer(customer);
	}

	public void updateCustomer(Customer customer) {
		ArrayList<Customer> customers = this.customersDAO.getAllCustomers();
		for (Customer var : customers) {
			if (var.getId() == customer.getId()) {
				this.customersDAO.updateCustomer(customer);
			}
		}
		System.out.println("Error the customer code is changed");
	}

	public void deleteCustomer(int customerID) {
		this.customersDAO.deleteCustomer(customerID);
	}

	public ArrayList<Customer> getAllCustomer() {
		return this.customersDAO.getAllCustomers();
	}

	public Customer getOneCustomer(int customerID) {
		return this.customersDAO.getOneCustomer(customerID);
	}
}

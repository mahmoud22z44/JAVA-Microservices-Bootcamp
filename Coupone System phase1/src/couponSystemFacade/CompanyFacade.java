package couponSystemFacade;

import java.util.ArrayList;

import couponeSystemBeans.Category;
import couponeSystemBeans.Company;
import couponeSystemBeans.Coupon;

public class CompanyFacade extends ClientFacade {

	private int companyID;

	public CompanyFacade(int companyID) {
		super();
		this.companyID = companyID;
	}

	@Override
	public boolean login(String email, String password) {
		ArrayList<Company> companies = this.companiesDAO.getAllCompanies();
		for (Company var : companies) {
			if(var.getEmail().equals(email) && var.getPassword().equals(password)) {
				return this.companiesDAO.isCompanyExists(email, password);
			}
		}
		return false;
	}

	public void addCoupon(Coupon coupon) {
		ArrayList<Coupon> coupons = this.couponsDAO.getAllCoupons();
		for (Coupon var : coupons) {
			if(var.getCompanyID() == coupon.getCompanyID()) {
				if(var.getTitle().equals(coupon.getTitle())) {
					System.out.println("Error the coupon is existing");
					return;
				}
			}
		}
		this.couponsDAO.addCoupon(coupon);
	}

	public void updateCoupon(Coupon coupon) {
		ArrayList<Coupon> coupons = this.couponsDAO.getAllCoupons();
		for (Coupon var : coupons) {
			if(var.getCompanyID() == coupon.getCompanyID() && var.getId() == coupon.getId()) {
				this.couponsDAO.updateCoupon(coupon);
				return;
			}
		}
		System.out.println("Error the coupon code and coumpany code are changed ");
	}

	public void deleteCoupon(int couponID) {
		this.couponsDAO.deleteCoupon(couponID);
	}

	public ArrayList<Coupon> getCompanyCoupons() {
		ArrayList<Coupon> coupons = this.couponsDAO.getAllCoupons();
		ArrayList<Coupon> couponsOfCoumpany = new ArrayList<>();
		for (Coupon var : coupons) {
			if(var.getCompanyID() == this.companyID) {
				couponsOfCoumpany.add(var);
			}
		}
		return couponsOfCoumpany;
	}

	public ArrayList<Coupon> getCompanyCoupons(Category category) {
		ArrayList<Coupon> coupons = this.couponsDAO.getAllCoupons();
		ArrayList<Coupon> couponsOfCoumpany = new ArrayList<>();
		for (Coupon var : coupons) {
			if(var.getCompanyID() == this.companyID && var.getCategory().equals(category)) {
				couponsOfCoumpany.add(var);
			}
		}
		return couponsOfCoumpany;
	}

	public ArrayList<Coupon> getCompanyCoupons(double maxPrice) {
		ArrayList<Coupon> coupons = this.couponsDAO.getAllCoupons();
		ArrayList<Coupon> couponsOfCoumpany = new ArrayList<>();
		for (Coupon var : coupons) {
			if(var.getCompanyID() == this.companyID && var.getPrice() >= maxPrice) {
				couponsOfCoumpany.add(var);
			}
		}
		return couponsOfCoumpany;
	}

	public Company getCompanyDetails() {
		return this.companiesDAO.getOneCompany(this.companyID);
	}
}

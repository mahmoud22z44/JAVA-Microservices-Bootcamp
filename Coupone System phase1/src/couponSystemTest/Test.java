package couponSystemTest;

import couponSystemExpiration.CouponExpirationDailyJob;
import couponeSystemDAO.CouponsDBDAO;
import database.ConnectionPool;
import couponSystemFacade.AdminFacade;
import couponSystemFacade.ClientType;
import couponSystemFacade.LoginManager;
import couponeSystemBeans.Company;
import couponeSystemBeans.Customer;
public class Test {

	public void testAll() {
		ConnectionPool.getInstance();
//		CouponsDBDAO couponDB = new CouponsDBDAO();
//		CouponExpirationDailyJob dailyJob =	new CouponExpirationDailyJob(couponDB, true);
//		Thread thread1 = new Thread(dailyJob);
		LoginManager loginAdmin = LoginManager.getInstance();
		AdminFacade admin =  (AdminFacade) loginAdmin.login("admin@admin.com", "admin",ClientType.Administrator);
		Company company1 = new Company(112, "nike", "N@gmail.com", "12345", null);
		admin.addCompany(company1);
		Customer customer1 = new Customer(444, "hani", "asad", "a@gmail.com", "7777", null);
		admin.addCustomer(customer1);
		
	}
}

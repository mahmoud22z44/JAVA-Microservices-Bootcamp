package couponSystemFacade;

import java.util.ArrayList;

import couponeSystemBeans.Company;
import couponeSystemBeans.Customer;

public class LoginManager extends ClientFacade {
	private static LoginManager instance;

	private LoginManager() {

	}

	public synchronized static LoginManager getInstance() {
		if (instance == null) {
			instance = new LoginManager();
		}
		return instance;
	}

	public ClientFacade login(String email, String password, ClientType clientType) {
		if (clientType == ClientType.Administrator) {
			AdminFacade administrator = new AdminFacade();
			if (administrator.login(email, password)) {
				return administrator;
			}
		}
		if (clientType == ClientType.Company) {
			ArrayList<Company> companies = this.companiesDAO.getAllCompanies();
			for (Company var : companies) {
				if (var.getEmail().equals(email) && var.getPassword().equals(password)) {
					CompanyFacade company = new CompanyFacade(var.getId());
					return company;
				}
			}
		}
		if (clientType == ClientType.Customer) {

			ArrayList<Customer> customers = this.customersDAO.getAllCustomers();
			for (Customer var : customers) {
				if (var.getEmail().equals(email) && var.getPassword().equals(password)) {
					CustomerFacade customer = new CustomerFacade(var.getId());
					return customer;
				}
			}
		}
		return null;
	}

	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}

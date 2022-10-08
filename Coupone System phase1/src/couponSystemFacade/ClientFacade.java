package couponSystemFacade;

import couponeSystemDAO.CompaniesDAO;
import couponeSystemDAO.CompaniesDBDAO;
import couponeSystemDAO.CouponsDAO;
import couponeSystemDAO.CouponsDBDAO;
import couponeSystemDAO.CustomersDAO;
import couponeSystemDAO.CustomersDBDAO;

public abstract class ClientFacade{

	protected CompaniesDAO companiesDAO = new CompaniesDBDAO();
	protected CustomersDAO customersDAO = new CustomersDBDAO() ;
	protected CouponsDAO couponsDAO = new CouponsDBDAO();
	
	public abstract boolean login(String email, String password);
	
}

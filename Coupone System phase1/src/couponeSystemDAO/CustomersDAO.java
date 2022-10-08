package couponeSystemDAO;

import java.util.ArrayList;

import couponeSystemBeans.Customer;

public interface CustomersDAO {

	public boolean isCustomerExists(String email , String password);
	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(int customerID);
	public ArrayList<Customer> getAllCustomers();
	public Customer getOneCustomer(int customerID);
}

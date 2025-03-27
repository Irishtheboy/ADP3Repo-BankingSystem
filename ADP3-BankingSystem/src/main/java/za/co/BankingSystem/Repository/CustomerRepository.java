//Naqeebah Khan 219099073
package za.co.BankingSystem.Repository;

import za.co.BankingSystem.Domain.Customer;


import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {


    private static CustomerRepository repository = null;
    private List<Customer> customerList;

    private CustomerRepository() {
        customerList = new ArrayList<>();
    }

    @Override
    public Customer create (Customer customer){
        customerList.add(customer);
        return customer;
    }

    @Override
    public Customer read (String customerID) {
        for (Customer customer : customerList) {
            if (customer.getCustomerID().equals(customerID)) {
                return customer;
            }
        }
        return null;

    }

    @Override
    public Customer update (Customer customer) {
        Customer existing = read(customer.getCustomerID());
        if (existing != null) {
            customerList.remove(existing);
            customerList.add(customer);
            return customer;
        }
            return null;
    }

    @Override
    public boolean delete (String customerID) {
        Customer customer = read(customerID);
        if (customer != null) {
            customerList.remove(customer);
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> findAll(){
        return customerList;
    }
}

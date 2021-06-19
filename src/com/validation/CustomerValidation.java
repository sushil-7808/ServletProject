package com.validation;

import com.dao.CustomerDAO;
import com.model.Customer;

/**
 * @author Suraj Maharjan
 * @version project zero 0.1
 * @quote “ Code is like humor. When you have to explain it, it’s bad.” – Cory House
 * @written_on 6/18/21 Friday
 */
public class CustomerValidation {


    private CustomerDAO customerDAO = new CustomerDAO();

    public CustomerError validateCustomer(Customer customer) {
        try {
            CustomerError customerError = new CustomerError();
            customerError.setHasError(false);
            //start
            if (customer.getMobileNumber().length() != 10) {
                customerError.setHasError(true);
                customerError.setMobileNumberError("Mobile number length should be 10");
            }

            if (customer.getFullName().length() < 5 || customer.getFullName().length() > 100) {
                customerError.setHasError(true);
                customerError.setFullNameError("Name should be greater than 3 characters");
            }
            if (customer.getEmail() == null) {
                customerError.setHasError(true);
                customerError.setEmailError("Email should not be null");
            } else if (customerDAO.findByEmailAddress(customer.getEmail()) != null) {
                customerError.setHasError(true);
                customerError.setEmailError("Email already exists");
            }


            if (customer.getMobileNumber() == null) {
                customerError.setHasError(true);
                customerError.setMobileNumberError("Mobile number should not be null");
            } else if (customerDAO.findByMobileNumber(customer.getMobileNumber()) != null) {
                customerError.setHasError(true);
                customerError.setMobileNumberError("Mobile number already exists");
            }
            return customerError;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}

package com.service.impl;

import com.dao.CustomerDAO;
import com.dto.Response;
import com.model.Customer;
import com.service.CustomerService;
import com.validation.CustomerError;
import com.validation.CustomerValidation;

import java.util.List;

/**
 * @author Suraj Maharjan
 * @version project zero 0.1
 * @quote “ Code is like humor. When you have to explain it, it’s bad.” – Cory House
 * @written_on 6/18/21 Friday
 */
public class CustomerServiceImpl implements CustomerService {

    CustomerDAO customerDAO = new CustomerDAO();
    CustomerValidation validation = new CustomerValidation();
    boolean result;

    @Override
    public Response createCustomer(Customer customer) {
        Response response = new Response();
        try {
            /**
             * Customer email mobile number unique
             * validate
             */

            CustomerError customerError = validation.validateCustomer(customer);
            if (!customerError.isHasError()) {
                result = customerDAO.createCustomer(customer);
                if (result) {
                    response.setStatus(result);
                    response.setMessage("Customer saved successfully");
                } else {
                    response.setStatus(result);
                    response.setMessage("Customer create failed");
                }
            } else {
                response.setError(customerError);
                response.setStatus(false);
                response.setMessage("validation failed");
                return response;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public List<Customer> findAllCustomer() {
        return null;
    }
}

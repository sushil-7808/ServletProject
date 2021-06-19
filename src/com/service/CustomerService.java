package com.service;

import com.dto.Response;
import com.model.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Suraj Maharjan
 * @version project zero 0.1
 * @quote “ Code is like humor. When you have to explain it, it’s bad.” – Cory House
 * @written_on 6/18/21 Friday
 */
public interface CustomerService {

    Response createCustomer(Customer customer);

    void updateCustomer(Customer customer) throws SQLException;

    List<Customer> findAllCustomer() throws SQLException;

    void deleteCustomer(int id);

    Customer findCustomerById(int id) throws SQLException;

}

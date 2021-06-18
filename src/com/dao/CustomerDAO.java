package com.dao;

import com.enums.Gender;
import com.model.Customer;
import com.util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Suraj Maharjan
 * @version project zero 0.1
 * @quote “ Code is like humor. When you have to explain it, it’s bad.” – Cory House
 * @written_on 6/18/21 Friday
 */
public class CustomerDAO {


    public boolean createCustomer(Customer customer) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            String insertSQL = "insert into xyz_customer values (null,?,?,?,?,?)";
            PreparedStatement preparedStatement = databaseConnection.connection.prepareStatement(insertSQL);
            preparedStatement.setString(1, customer.getFullName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getMobileNumber());
            preparedStatement.setInt(5, customer.getGender().ordinal());
            //execute the query
            int res = preparedStatement.executeUpdate();
            if (res > 0) {
                return true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            databaseConnection.connection.close();
        }
        return false;
    }


    public List<Customer> findAllCustomer() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        List<Customer> customers = new ArrayList<>();
        try {
            // database hit => data fetch => add data in list
            String findAllSQL = "select * from xyz_customer";
            PreparedStatement preparedStatement = databaseConnection.connection.prepareStatement(findAllSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), Gender.findByOrdinal(resultSet.getInt(6))));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            databaseConnection.connection.close();
        }
        return customers;
    }

    public Customer findByEmailAddress(String email) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            String findByEmailSQL = "select * from xyz_customer where email = ?";
            PreparedStatement preparedStatement = databaseConnection.connection.prepareStatement(findByEmailSQL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Customer(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), Gender.findByOrdinal(resultSet.getInt(6)));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            databaseConnection.connection.close();
        }
        return null;
    }

    public Customer findByMobileNumber(String mobileNumber) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            String findByMobileNumberSQL = "select * from xyz_customer where mobile_number = ?";
            PreparedStatement preparedStatement = databaseConnection.connection.prepareStatement(findByMobileNumberSQL);
            preparedStatement.setString(1, mobileNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Customer(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), Gender.findByOrdinal(resultSet.getInt(6)));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            databaseConnection.connection.close();
        }
        return null;
    }
}

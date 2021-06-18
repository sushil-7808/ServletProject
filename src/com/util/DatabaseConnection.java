package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Suraj Maharjan
 * @version project zero 0.1
 * @quote “ Code is like humor. When you have to explain it, it’s bad.” – Cory House
 * @written_on 6/18/21 Friday
 */
public class DatabaseConnection {
    public Connection connection = null;

    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String username = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost:3306/servlet";
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

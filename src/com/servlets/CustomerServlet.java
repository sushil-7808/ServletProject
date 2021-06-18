package com.servlets;

import com.dto.Response;
import com.enums.Gender;
import com.model.Customer;
import com.service.CustomerService;
import com.service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Suraj Maharjan
 * @version project zero 0.1
 * @quote “ Code is like humor. When you have to explain it, it’s bad.” – Cory House
 * @written_on 6/17/21 Thursday
 */
public class CustomerServlet extends HttpServlet {

    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("landingPage")) {
            request.setAttribute("colorList", colorList());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/customer.jsp");
            requestDispatcher.forward(request, response);
        } else if (action.equalsIgnoreCase("listPage")) {
            response.sendRedirect("customer/list.jsp");
        } else {
            response.sendRedirect("customer/customer.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("save")) {
            String fullName = request.getParameter("fullName");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String mobileNumber = request.getParameter("mobileNumber");
            String gender = request.getParameter("gender");
            /**
             * I can save this data and send user message
             */
            Customer customer = new Customer(fullName, address, email, mobileNumber, Gender.valueOf(gender));
            Response createResponse = customerService.createCustomer(customer);
            if (createResponse.isStatus()) {
                request.setAttribute("message", createResponse.getMessage());
            } else {
                request.setAttribute("message", createResponse.getMessage());
                request.setAttribute("customerError", createResponse.getError());

            }
            request.setAttribute("colorList", colorList());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/customer.jsp");
            requestDispatcher.forward(request, response);

        } else {
            response.sendRedirect("customer/customer.jsp");
        }
    }

    private List<String> colorList() {
        List<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("orange");
        colors.add("green");
        colors.add("black");
        return colors;
    }

}
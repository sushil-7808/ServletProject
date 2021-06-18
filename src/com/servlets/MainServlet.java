package com.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Suraj Maharjan
 * @version project zero 0.1
 * @quote “ Code is like humor. When you have to explain it, it’s bad.” – Cory House
 * @written_on 6/17/21 Thursday
 */
@WebServlet(name = "MainServlet", urlPatterns = "/")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("main.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("I am in do post");
    }
}

package com.luv2code.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Sending request object to jsp and displaying when calling to servelets
 */
@WebServlet("/MvcDemoServlet")
public class MvcDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //step 0: add data
        String[] students = {"Kasun", "Amila", "Kavi", "Thilina"};
        req.setAttribute("student_list", students);

        //step 1: get Request Dispatcher
        RequestDispatcher dispatcher = req.getRequestDispatcher("/servlets/view_students.jsp");

        //step 2: forward request to JSP
        dispatcher.forward(req, resp);
    }
}
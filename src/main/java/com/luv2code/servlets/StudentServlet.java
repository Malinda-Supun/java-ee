package com.luv2code.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/* Capture and Display data */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // step 1: set content type
        resp.setContentType("text/html");

        // step 2: get print writer
        PrintWriter out = resp.getWriter();

        // step 3: generate the html content

        out.println("<html><body>");

        out.println("Student is confirmed: "
                + req.getParameter("firstName") + " "
                + req.getParameter("lastName"));

        out.println("</body></html>");


    }
}
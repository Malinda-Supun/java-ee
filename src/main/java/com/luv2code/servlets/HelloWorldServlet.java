package com.luv2code.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 *  Servelet to dispaly content only using servelet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // step 1. set the content type
        resp.setContentType("text/html");

        // step 2. get the printwriter
        PrintWriter out = resp.getWriter();

        // step 3. generate HTML code
        out.println("<html><body>");

        out.println("<h2>Hello World</h2>");

        out.println("<hr>");

        out.println("<p>Time on the Server is: "+ new Date() +"</p>");

        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
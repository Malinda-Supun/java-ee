package com.luv2code.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Shows how to get context parameters initialize in web.xml file
 */
@WebServlet("/ContextParamServlet")
public class ContextParamServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // step 1. set content type
        resp.setContentType("text/html");

        // step 2. get printWriter
        PrintWriter out = resp.getWriter();

        // step 3. read configuration params
        ServletContext context = getServletContext(); //inherit from HttpServlet
        String maxCardSize = context.getInitParameter("max-shopping-card-size");
        String teamName = context.getInitParameter("project-team-name");

        // step 4. generate HTML content
        out.println("<html><body>");

        out.println("Max Card: "+ maxCardSize);
        out.println("<br><br>");
        out.println("Team Name: "+ teamName);
        out.println("</body></html>");


    }
}
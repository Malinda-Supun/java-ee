package com.luv2code.jdbc;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

    //define datasource/connection pool for resource injection
    @Resource(name = "jdbc/web_student_tracker")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        //step 1: setup printwriter
        PrintWriter out = resp.getWriter();

        //step 2: get a connection to the database
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();

            //step 3: create a SQL statements
            String sql = "select * from student";
            statement = connection.createStatement();

            //step 4: execute SQL query
            resultSet = statement.executeQuery(sql);

            //step 5: process the result set
            while (resultSet.next()){
                out.println(resultSet.getString("email"));
                out.println("<br><br>");
            }

        }catch (Exception e){
            log(e.getMessage());
        }



    }
}
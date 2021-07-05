package com.luv2code.servlets.mvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MvcStudentDemoServlet")
public class MvcStudentDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //step 1: get student data
        List<Student> studentList = StudentDataUtil.getStudents();

        //step 2: add student to request object
        req.setAttribute("student_list", studentList);

        //step 3: get request dispatcher
        RequestDispatcher dispatcher = req.getRequestDispatcher("/servlets/view_students_data.jsp");

        //step 4: forward to jsp
        dispatcher.forward(req, resp);

    }
}
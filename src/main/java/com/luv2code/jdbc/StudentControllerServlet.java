package com.luv2code.jdbc;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {

    private StudentDbUtil studentDbUtil;

    @Resource(name = "jdbc/web_student_tracker")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        //call at initialization in servlet life cycle
        //passing datasource to db utils.
        try {
            studentDbUtil = new StudentDbUtil(dataSource);
        } catch (Exception e) {
            throw new ServletException(e);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //read the command parameter
            String command = req.getParameter("command");

            //if the command is missing, then default to  to listing students
            if(command == null){
                command = "LIST";
            }

            //route to appropriate method
            switch (command){
                case "LIST":
                    listStudents(req, resp);
                    break;
                case "ADD":
                    addStudent(req, resp);
                    break;
                case "LOAD":
                    loadStudent(req, resp);
                    break;
                case "UPDATE":
                    updateStudent(req, resp);
                    break;
                case "DELETE":
                    deleteStudent(req, resp);
                    break;
                default:
                    listStudents(req, resp);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        //read student fro id
        int studentId = Integer.parseInt(req.getParameter("studentId"));

        //delete student from id
        studentDbUtil.deleteStudent(studentId);

        //send back to  list student page
        listStudents(req, resp);
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //read student from form
        int id = Integer.parseInt(req.getParameter("studentId"));

        //create new student object
        Student student = new Student(id, req.getParameter("firstName"),
                req.getParameter("lastName"),
                req.getParameter("email"));

        //perform update on databse
        studentDbUtil.updateStudent(student);

        //send back to list student page
        listStudents(req, resp);
    }

    private void loadStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //read student id from data
        String studentId = req.getParameter("studentId");

        //get student from database (db util)
        Student student = studentDbUtil.getStudent(studentId);

        //place student in the request attribute
        req.setAttribute("THE_STUDENT", student);

        //send to jsp page: update-student-form.jsp
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jdbc/update-student-form.jsp");
        requestDispatcher.forward(req, resp);

    }

    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws Exception{

        //read student from form data
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");

        //create new student object
        Student student = new Student(firstName, lastName, email);

        //add the student to database
        studentDbUtil.addStudent(student);

        //send back to main page (the student list)
        listStudents(req, resp);
    }

    private void listStudents(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        //get students from db util
        resp.setContentType("text/html");
        List<Student> studentList = studentDbUtil.getStudents();

        //add students to the request
        req.setAttribute("STUDENT_LIST", studentList);

        //send to JSP view
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jdbc/list-students.jsp");
        requestDispatcher.forward(req, resp);

    }
}
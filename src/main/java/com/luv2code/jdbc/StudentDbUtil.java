package com.luv2code.jdbc;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDbUtil {

    private DataSource dataSource;

    public StudentDbUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Student> getStudents() throws Exception {
        List<Student> studentList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            //get Connection
            connection = dataSource.getConnection();

            //create sql statement
            String sql = "select * from student";

            //execute query
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            //process result set
            while (resultSet.next()) {
                studentList.add(new Student(Integer.parseInt(resultSet.getString(1)), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
            }


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            close(connection, statement, resultSet);
        }

        //close jdbc objects


        return studentList;
    }

    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addStudent(Student student) throws Exception {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //get db connection
            connection = dataSource.getConnection();

            //create sql for insert
            String sql = "insert into student"
                    + "(first_name, last_name, email ) "
                    + "values (?, ?, ?)";

            statement = connection.prepareStatement(sql);

            //set the params for student
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getEmail());

            //execute sql
            statement.execute();

        } finally {
            //clean up jdbc objects
            close(connection, statement, null);
        }


    }

    public Student getStudent(String studentId) throws Exception {

        Student student = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int stuId;

        try {
            //convert student id to int
            stuId = Integer.parseInt(studentId);

            //get connection to db
            connection = dataSource.getConnection();

            //create sql to get selected  student
            String sql = "select * from student where id=?";

            //create prepared statement
            preparedStatement = connection.prepareStatement(sql);

            //set params
            preparedStatement.setInt(1, stuId);

            //execute statement
            resultSet = preparedStatement.executeQuery();

            //retrieve data from result set row
            if (resultSet != null && resultSet.next()) {
                student = new Student(stuId, resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"));
            }else {
                throw new Exception("could not find student id: "+ studentId);
            }

            return  student;
        } finally {
            close(connection, preparedStatement, resultSet);
        }

    }

    public void updateStudent(Student student) throws Exception {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{


            //get connection to db
            connection = dataSource.getConnection();

            //create sql update statement
            String sql = "update student "
                    + "set first_name=?, last_name=?, email=?"
                    + "where id=?";

            //prepared statement
            preparedStatement  = connection.prepareStatement(sql);

            //set params
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setInt(4, student.getId());

            //execute statement
            preparedStatement.execute();


        }finally {
            close(connection, preparedStatement, null);
        }
    }

    public void deleteStudent(int studentId) throws Exception {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{


            //get connection to db
            connection = dataSource.getConnection();

            //create sql update statement
            String sql = "delete from student where id=?";

            //prepared statement
            preparedStatement  = connection.prepareStatement(sql);

            //set params
            preparedStatement.setInt(1, studentId);

            //execute statement
            preparedStatement.execute();

        }finally {
            close(connection, preparedStatement, null);
        }
    }
}
package com.example.model;

import com.example.db.DBConnection;
import com.example.dto.StudentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentModel {
    public boolean saveStudent(StudentDTO studentDTO) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student VALUES (?,?,?,?)");

        preparedStatement.setInt(1 ,studentDTO.getId());
        preparedStatement.setString(2,studentDTO.getName());
        preparedStatement.setString(3,studentDTO.getAddress());
        preparedStatement.setInt(4,studentDTO.getAge());
        return preparedStatement.executeUpdate() > 0;
    }

    public List<StudentDTO> getAllStudent() throws SQLException {
        ArrayList <StudentDTO> allStudents = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            StudentDTO studentDTO = new StudentDTO(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)
            );
            allStudents.add(studentDTO);
        }
        return allStudents;
    }

    public boolean updateStudent(StudentDTO studentDTO) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET name = ?, address = ? , age = ? WHERE id = ?");

        preparedStatement.setString(1,studentDTO.getName());
        preparedStatement.setString(2,studentDTO.getAddress());
        preparedStatement.setString(3, String.valueOf(studentDTO.getAge()));
        preparedStatement.setString(4, String.valueOf(studentDTO.getId()));
        return preparedStatement.executeUpdate() > 0;
    }

    public boolean removeStudent(int stuId) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id = ?");

        preparedStatement.setInt(1,stuId);
        return preparedStatement.executeUpdate() > 0;
    }
}

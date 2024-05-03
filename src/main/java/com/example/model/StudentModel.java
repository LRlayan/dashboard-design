package com.example.model;

import com.example.db.DBConnection;
import com.example.dto.StudentDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}

package com.example.model;

import com.example.db.DBConnection;
import com.example.dto.FoodsDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodsModel {

    //item save in database food table
    public boolean save(FoodsDTO foodsDTO) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO foods VALUES (?,?,?,?)");
        preparedStatement.setString(1,foodsDTO.getItemCode());
        preparedStatement.setString(2,foodsDTO.getItemName());
        preparedStatement.setString(3, String.valueOf(foodsDTO.getItemPrice()));
        preparedStatement.setString(4,foodsDTO.getImageURL());

        return preparedStatement.executeUpdate() > 0;
    }

    public ArrayList<FoodsDTO> getAll() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Foods");
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<FoodsDTO> arrayList = new ArrayList<>();
        while (resultSet.next()){
            arrayList.add(
                    new FoodsDTO(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getDouble(3),
                            resultSet.getString(4)
                    )
            );
        }
        return arrayList;
    }
}

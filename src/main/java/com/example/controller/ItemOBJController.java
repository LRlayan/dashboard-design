package com.example.controller;

import com.example.dto.FoodsDTO;
import com.example.model.FoodsModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ItemOBJController implements Initializable {

    @FXML
    private Label itemName;

    @FXML
    private Label itemPrice;

    @FXML
    private ImageView itemImageView;

    public static int index;

    FoodsModel foodModel = new FoodsModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setDataItemObject();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setDataItemObject() throws SQLException {
        List<FoodsDTO> foodsDTOS = foodModel.getAll();

        Image image = new Image(foodsDTOS.get(index).getImageURL());
        ImageView imageView = new ImageView(image);

        itemImageView.setImage(imageView.getImage());
        itemName.setText(foodsDTOS.get(index).getItemName());
        itemPrice.setText(String.valueOf(foodsDTOS.get(index).getItemPrice()));
    }
}

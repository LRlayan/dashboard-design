package com.example.controller;

import com.example.dto.FoodsDTO;
import com.example.model.FoodsModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewItemsFormController implements Initializable {

    @FXML
    private AnchorPane viewItemAnchorPane;

    @FXML
    private GridPane gridPane;

    FoodsModel foodsModel = new FoodsModel();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ArrayList<FoodsDTO> foodsDTOS = foodsModel.getAll();

            int column = 0;
            int row = 1;
            for (int i = 0; i < foodsDTOS.size(); i++) {
                ItemOBJController.index = i;

                Parent parent = FXMLLoader.load(getClass().getResource("/view/itemOBJ.fxml"));
                if (column == 4){
                    column = 0;
                    row++;
                }
                gridPane.add(parent,column++,row);
                GridPane.setMargin(parent,new Insets(10,5,5,5));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

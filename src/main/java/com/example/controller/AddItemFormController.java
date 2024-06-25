package com.example.controller;

import com.example.dto.FoodsDTO;
import com.example.model.FoodsModel;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;

public class AddItemFormController {

    @FXML
    private AnchorPane addItemAnchorpane;

    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtItemName;

    @FXML
    private JFXTextField txtItemPrice;

    @FXML
    private ImageView previewImgView;

    private String imagePath;

    FoodsModel foodsModel = new FoodsModel();

    ReuseMethod reuseMethod = new ReuseMethod();

    @FXML
    void backBtnOnAction(ActionEvent event) throws IOException {
        reuseMethod.changeOnlyAnchorPane("/view/viewItemsForm.fxml",addItemAnchorpane);
    }

    @FXML
    void chooseImageBtnOnAction(ActionEvent event) {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open image file");
        File file = fileChooser.showOpenDialog(stage);
        if (file!= null){
            Image image = new Image(file.toURI().toString());
            imagePath = file.getPath();
            previewImgView.setImage(image);
        }
    }

    @FXML
    void saveBtnOnAction(ActionEvent event) {
        FoodsDTO foodsDTO = new FoodsDTO(txtItemCode.getText(),txtItemName.getText(),Double.parseDouble(txtItemPrice.getText()),imagePath);
        try {
            boolean isSaved = foodsModel.save(foodsDTO);
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Saved Item Successfully.").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"please try aging!").show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

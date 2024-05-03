package com.example.controller;

import com.example.dto.StudentDTO;
import com.example.model.StudentModel;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class CrudOperationController {
    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtAge;

    StudentModel studentModel = new StudentModel();

    @FXML
    void btnNewOnAction(ActionEvent event) {

        var studentDTO = new StudentDTO(0,txtName.getText(),txtAddress.getText(),Integer.parseInt(txtAge.getText()));
        try{
           boolean isSaved = studentModel.saveStudent(studentDTO);
           if (isSaved){
               new Alert(Alert.AlertType.INFORMATION,"Saved Student!").show();
           }else {
               new Alert(Alert.AlertType.ERROR,"Please Try Again").show();
           }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }
}

package com.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    @FXML
    private AnchorPane mainAnchorpane;

    ReuseMethod reuseMethod = new ReuseMethod();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            reuseMethod.changeOnlyAnchorPane("/view/viewItemsForm.fxml",mainAnchorpane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void addItemOnAction(ActionEvent event) throws IOException {
        reuseMethod.changeOnlyAnchorPane("/view/addItemForm.fxml",mainAnchorpane);
    }
}

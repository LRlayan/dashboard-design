package com.example.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ReuseMethod {
    public void changeOnlyAnchorpane(String fxml, AnchorPane mainAnchorpane) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        AnchorPane anchorPane = loader.load();
        mainAnchorpane.getChildren().removeAll();
        mainAnchorpane.getChildren().setAll(anchorPane);
    }

    public void clickChangeButtonBorderColor(JFXButton jfxButton , JFXButton... button){
        jfxButton.setStyle("-fx-border-color: #ABD7FF");

        for (JFXButton buttons : button){
            buttons.setStyle("-fx-border-color: transparent");
        }
    }
}

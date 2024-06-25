package com.example.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ReuseMethod {
    public void changeOnlyAnchorPane(String fxml, AnchorPane anchorPaneId) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        AnchorPane anchorPane = fxmlLoader.load();
        anchorPaneId.getChildren().removeAll();
        anchorPaneId.getChildren().setAll(anchorPane);
    }
}

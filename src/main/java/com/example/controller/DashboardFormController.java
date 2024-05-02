package com.example.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnOrder;

    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnProduct;

    @FXML
    private JFXButton btnSetting;

    @FXML
    private AnchorPane mainAnchorpane;

    ReuseMethod reuseMethod = new ReuseMethod();

    @FXML
    void customerBtnOnAction(ActionEvent event) throws IOException {
        reuseMethod.changeOnlyAnchorpane("/view/customerForm.fxml" , mainAnchorpane);
        reuseMethod.clickChangeButtonBorderColor(btnCustomer , btnSetting,btnDashboard,btnOrder,btnProduct);
    }

    @FXML
    void dashboardBtnOnAction(ActionEvent event) throws IOException {
        reuseMethod.changeOnlyAnchorpane("/view/dashboard-contentForm.fxml" , mainAnchorpane);
        reuseMethod.clickChangeButtonBorderColor(btnDashboard , btnCustomer,btnSetting,btnOrder,btnProduct);
    }

    @FXML
    void orderBtnOnAction(ActionEvent event) throws IOException {
        reuseMethod.changeOnlyAnchorpane("/view/orderForm.fxml" , mainAnchorpane);
        reuseMethod.clickChangeButtonBorderColor(btnOrder , btnCustomer, btnSetting,btnDashboard,btnProduct);
    }

    @FXML
    void productBtnOnAction(ActionEvent event) throws IOException {
        reuseMethod.changeOnlyAnchorpane("/view/productForm.fxml" , mainAnchorpane);
        reuseMethod.clickChangeButtonBorderColor(btnProduct , btnCustomer,btnSetting,btnDashboard,btnOrder);
    }

    @FXML
    void settingBtnOnAction(ActionEvent event) throws IOException {
        reuseMethod.changeOnlyAnchorpane("/view/settingForm.fxml" , mainAnchorpane);
        reuseMethod.clickChangeButtonBorderColor(btnSetting , btnCustomer,btnDashboard,btnOrder,btnProduct);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            reuseMethod.changeOnlyAnchorpane("/view/dashboard-contentForm.fxml" , mainAnchorpane);
            reuseMethod.clickChangeButtonBorderColor(btnDashboard);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

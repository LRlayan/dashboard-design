package com.example.controller;

import com.example.dto.StudentDTO;
import com.example.model.StudentModel;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

public class CrudOperationController implements Initializable {
    public JFXTextField txtSearchBar;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtAge;

    private int stuId;

    StudentModel studentModel = new StudentModel();
    private List<StudentDTO> studentDTOList = studentModel.getAllStudent();
    private Set<String> _studentDTOList = new HashSet<>();

    public CrudOperationController() throws SQLException {
    }

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

        try{
            boolean isSaved = studentModel.removeStudent(stuId);
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Remove Student!").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Please Try Again").show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        var studentDTO = new StudentDTO(stuId,txtName.getText(),txtAddress.getText(),Integer.parseInt(txtAge.getText()));
        try{
            boolean isSaved = studentModel.updateStudent(studentDTO);
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Update Student!").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Please Try Again").show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void searchBarOnAction(ActionEvent event) {
        setSearchBarDetails();
    }

    private void setSearchBarDetails() {
        String studentName = txtSearchBar.getText();
        for (int i =0; i < studentDTOList.size(); i++){
            if (studentName.equals(studentDTOList.get(i).getName())){
                stuId = studentDTOList.get(i).getId();
                txtName.setText(studentDTOList.get(i).getName());
                txtAddress.setText(studentDTOList.get(i).getAddress());
                txtAge.setText(String.valueOf(studentDTOList.get(i).getAge()));
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchBar();
    }

    private void searchBar() {
        studentDTOList.forEach(studentDTO -> {
            _studentDTOList.add(studentDTO.getName());
        });
        TextFields.bindAutoCompletion(txtSearchBar,_studentDTOList);
    }
}

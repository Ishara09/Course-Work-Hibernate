package Controller;

import Entity.RegistrationEntity;
import Utill.HinernateController.HibernateViewStudentController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {
    @FXML
    private TableView<RegistrationEntity> tblView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblView.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("regNo"));
        tblView.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("date"));
        tblView.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("regFee"));
        tblView.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("regNo"));
        tblView.getColumns().get(4).setCellValueFactory(new PropertyValueFactory("regNo"));
//        tblstudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("id"));
        loadAll();
    }

    private void loadAll() {
        List<RegistrationEntity> registrationEntityList = new HibernateViewStudentController().getAll();
        tblView.setItems(FXCollections.observableArrayList(registrationEntityList));



    }
}
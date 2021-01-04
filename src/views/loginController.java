package views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class loginController {
    @FXML
    private BorderPane boarderMain;

    @FXML
    void addStudentForm(ActionEvent event) {


        try {

            AnchorPane root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
//            boarderMain.setBackground(Background.EMPTY);
//            boarderMain.getChildren().setAll(root);
            boarderMain.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void mangeCourses(ActionEvent event) {

        try {

            AnchorPane root = FXMLLoader.load(getClass().getResource("Course.fxml"));
            boarderMain.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void registrion(ActionEvent event) {
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
//            boarderMain.setBackground(Background.EMPTY);
//            boarderMain.getChildren().setAll(root);
            boarderMain.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void dashboard(ActionEvent event) {

    }
}




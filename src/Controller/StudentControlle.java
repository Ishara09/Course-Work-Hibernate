package Controller;

import BO.BOFactory;
import BO.Custom.RegisterBO;
import DTO.StudentDTO;
import Entity.CourseEntity;
import Entity.RegistrationEntity;
import Entity.StudentEntity;
import Utill.HinernateController.HibernateAddStudentController;
import Utill.HinernateController.HibernateCourseController;
import Utill.HinernateController.HibernateViewStudentController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class StudentControlle implements Initializable {

    @FXML
    private TextField txtID;


    @FXML
    private ComboBox<String> ComboCourseID;

    @FXML
    private TextField txtNAME;

    @FXML
    private TextField txtADDRESS;

    @FXML
    private TextField txtCONTACT;

    @FXML
    private TableView<StudentEntity> tblstudent;

    @FXML
    private DatePicker txtBOD;

    @FXML
    private CheckBox male;

    @FXML
    private CheckBox female;

    @FXML
    private TextField RegNo;

    @FXML
    private TextField Regfee;

    @FXML
    private TextField txtCoursename;

    @FXML
    private TextField txtDuration;


    String gender = null;

    RegisterBO bo = (RegisterBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REGISTER);

    @FXML
    void StudentSaveBtn(ActionEvent event) {
        try {

            String id = txtID.getText();
            String name = txtNAME.getText();
            String address = txtADDRESS.getText();
            String contact = txtCONTACT.getText();
            String bod = txtBOD.getValue().toString();
            String txtregno = RegNo.getText();
            String txtregfee = Regfee.getText();
            String datecurrent = new Date().toString();

            StudentEntity studentEntity = new StudentEntity(id, name, address, contact, bod, gender);

            String value = ComboCourseID.getValue();

            CourseEntity courseEntity = new CourseEntity(value);

            RegistrationEntity registrationEntity = new RegistrationEntity(txtregno, datecurrent, txtregfee, courseEntity, studentEntity);

            bo.add(registrationEntity);
            loadStudent();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please Fill The Form");
        }

    }

    @FXML
    void femaleChecked(ActionEvent event) {
        female.setSelected(true);
        gender = "Female";
        male.setSelected(false);

    }

    @FXML
    void maleChecked(ActionEvent event) {
        female.setSelected(false);
        gender = "Male";
        male.setSelected(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblstudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("id"));
        tblstudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("name"));
        tblstudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("address"));
        tblstudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("date"));
        tblstudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory("contact"));


        loadStudent();
        loadIDS();

    }
    private void loadStudent() {

        List<StudentEntity> student = new HibernateViewStudentController().getStudents();
        tblstudent.setItems(FXCollections.observableArrayList(student));


    }
    @FXML
    void clickClear(ActionEvent event) {
        txtID.setText("");
        txtNAME.setText("");
        txtADDRESS.setText("");
        txtCONTACT.setText("");
    }
    @FXML
    void clickDelete(ActionEvent event) throws Exception {

        StudentEntity selectedItem = tblstudent.getSelectionModel().getSelectedItem();
        boolean remove = new HibernateAddStudentController().remove(selectedItem.getId());
        loadStudent();

    }

    @FXML
    void clickUpdate(ActionEvent event) throws Exception {
        String id = txtID.getText();
        String name = txtNAME.getText();
        String address = txtADDRESS.getText();
        String contact = txtCONTACT.getText();
        String bod = txtBOD.getValue().toString();

        System.out.println(id + name + address + contact + bod + gender);

        StudentDTO sto = new StudentDTO(id, name, bod, address, contact, gender);

//        Boolean isTrue = bo.update(sto);
//        loadStudent();
    }
    @FXML
    void GetDataTable(MouseEvent event) {
//        StudentDTO selectedItem = tblstudent.getSelectionModel().getSelectedItem();
//
//
//        txtID.setText(selectedItem.getId());
//        txtNAME.setText(selectedItem.getName());
//        txtADDRESS.setText(selectedItem.getAddress());
//        txtCONTACT.setText(selectedItem.getContact());
    }

    private void loadIDS() {
        List<String> ids = new HibernateCourseController().getIDS();
        for (String course : ids) {
            ComboCourseID.getItems().add(course);
            System.out.println(course);
        }
    }
    @FXML
    void isselected(ActionEvent event) {
//        String value = ComboCourseID.getValue();
//        CourseEntity courseDetails = new HibernateCourseController().getCourseDetails(value);
//
//        System.out.println(courseDetails.getCourseName());
    }
}

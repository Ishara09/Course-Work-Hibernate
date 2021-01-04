package Controller;

import BO.BOFactory;
import BO.Custom.CourseBO;
import Entity.CourseEntity;
import Utill.HinernateController.HibernateCourseController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CourseController implements Initializable {

//    RegisterBO bo = (RegisterBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REGISTER);
        CourseBO courseBO = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.COURSE);
    @FXML
    private TextField courseid;

    @FXML
    private TableView<CourseEntity> coursetbl;

    @FXML
    private TextField coursename;

    @FXML
    private TextField coursefee;

    @FXML
    private TextField coursedurataion;

    @FXML
    private ComboBox<String> comboID;


    @FXML
    private Button btnDelete;

    @FXML
    void CourseSaveBtn(ActionEvent event) throws Exception {

        System.out.println("Coming");
        String id = courseid.getText();
        String name = coursename.getText();
        String fee = coursefee.getText();
        String duration = coursedurataion.getText();

        CourseEntity courseEntity = new CourseEntity(id, name, fee, duration);

        courseBO.add(courseEntity);

        loadCourse();

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        coursetbl.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("code"));
        coursetbl.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("courseName"));
        coursetbl.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("courseType"));
        coursetbl.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("duration"));


        loadCourse();
    }

    private void loadCourse() {
        List<CourseEntity> student = new HibernateCourseController().getCourse();
        coursetbl.setItems(FXCollections.observableArrayList(student));
    }

    @FXML
    void deleteCourse(ActionEvent event) {
//        StudentEntity selectedItem = tblstudent.getSelectionModel().getSelectedItem();
//
//
//        boolean remove = new HibernateAddStudentController().remove(selectedItem.getId());
//
//        loadStudent();

        CourseEntity selectedItem = coursetbl.getSelectionModel().getSelectedItem();
        new HibernateCourseController().remove(selectedItem.getCode());
        loadCourse();
    }


}

package cse213.refugeecampfinalproject.Educator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class EnrollmentController
{
    @javafx.fxml.FXML
    private TableColumn<EnrollmentModel,String> programnameColum;
    @javafx.fxml.FXML
    private TableView<EnrollmentModel> enrollmentTableView;
    @javafx.fxml.FXML
    private TableColumn<EnrollmentModel,Integer> enrolledstudentColum;

    public static ArrayList<EnrollmentModel> enrollmentDataList = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        programnameColum.setCellValueFactory(new PropertyValueFactory<>("programName"));
        enrolledstudentColum.setCellValueFactory(new PropertyValueFactory<>("enrolledStudents"));
        // Load enrollment data
        loadEnrollmentData();
    }
    private void loadEnrollmentData() {
        // Simulated data fetching (in a real application, this would come from a database)
        enrollmentDataList.add(new EnrollmentModel("Literacy Program", 30));
        enrollmentDataList.add(new EnrollmentModel("Language Program", 25));
        enrollmentDataList.add(new EnrollmentModel("Vocational Training", 20));
        // Populate the table with enrollment data
        enrollmentTableView.getItems().clear();
        enrollmentTableView.getItems().addAll(enrollmentDataList);
    }

    @javafx.fxml.FXML
    public void gobacktoeducationpanelOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject/EducationPanel.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Education Panel");
        stage.show();


    }

    @javafx.fxml.FXML
    public void loadOnAction(ActionEvent actionEvent) {
        loadEnrollmentData();
    }

}
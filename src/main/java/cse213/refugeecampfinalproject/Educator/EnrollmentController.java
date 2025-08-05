<<<<<<<< HEAD:src/main/java/cse213/refugeecampfinalproject/DoctorAndEducationCoordinator/EnrollmentController.java
package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
========
package cse213.refugeecampfinalproject.Educator;
>>>>>>>> 3766be206684680eb274de4e03789a2b43595b2f:src/main/java/cse213/refugeecampfinalproject/Educator/EnrollmentController.java

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.Objects;

public class EnrollmentController
{
    @javafx.fxml.FXML
    private TableColumn<EnrollmentModel,String> programnameColum;
    @javafx.fxml.FXML
    private TableView<EnrollmentModel> enrollmentTableView;
    @javafx.fxml.FXML
    private TableColumn<EnrollmentModel,Integer> enrolledstudentColum;

    private ArrayList<EnrollmentModel> enrollmentData = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        // Set up the table columns
        programnameColum.setCellValueFactory(new PropertyValueFactory<>("programName"));
        enrolledstudentColum.setCellValueFactory(new PropertyValueFactory<>("enrolledStudents"));
    }

    @javafx.fxml.FXML
    public void gobacktoeducationpanelOnAction(ActionEvent actionEvent) throws IOException {
<<<<<<<< HEAD:src/main/java/cse213/refugeecampfinalproject/DoctorAndEducationCoordinator/EnrollmentController.java
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/EducationPanel.fxml")));
========
        Parent home = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject/Educator/EducationPanel.fxml"));
>>>>>>>> 3766be206684680eb274de4e03789a2b43595b2f:src/main/java/cse213/refugeecampfinalproject/Educator/EnrollmentController.java
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Education Panel");
        stage.show();
    }

    @javafx.fxml.FXML
    public void loadOnAction(ActionEvent actionEvent) {
        // Fetch enrollment numbers for all active programs
        fetchEnrollmentData();
        // Populate the TableView with the fetched data
        ObservableList<EnrollmentModel> observableList = FXCollections.observableArrayList(enrollmentData);
        enrollmentTableView.setItems(observableList);
    }
    private void fetchEnrollmentData() {
        // Example data (in a real application, this would come from a database)
        enrollmentData.clear(); // Clear previous data
        enrollmentData.add(new EnrollmentModel("Literacy Program", 25));
        enrollmentData.add(new EnrollmentModel("Language Program", 30));
        enrollmentData.add(new EnrollmentModel("Vocational Program", 15));
        // Add more programs as needed
    }
}
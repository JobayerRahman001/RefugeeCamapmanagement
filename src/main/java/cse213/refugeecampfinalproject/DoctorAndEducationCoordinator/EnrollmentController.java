package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

import cse213.refugeecampfinalproject.DoctorAndEducationCoordinator.EnrollmentModel;
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

        programnameColum.setCellValueFactory(new PropertyValueFactory<>("programName"));
        enrolledstudentColum.setCellValueFactory(new PropertyValueFactory<>("enrolledStudents"));
    }

    @javafx.fxml.FXML
    public void gobacktoeducationpanelOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/EducationPanel.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Education Panel");
        stage.show();
    }

    @javafx.fxml.FXML
    public void loadOnAction(ActionEvent actionEvent) {
        fetchEnrollmentData();
        ObservableList<EnrollmentModel> observableList = FXCollections.observableArrayList(enrollmentData);
        enrollmentTableView.setItems(observableList);
    }
    private void fetchEnrollmentData() {
        enrollmentData.clear();
        enrollmentData.add(new EnrollmentModel("Literacy Program", 25));
        enrollmentData.add(new EnrollmentModel("Language Program", 30));
        enrollmentData.add(new EnrollmentModel("Vocational Program", 15));

    }
}
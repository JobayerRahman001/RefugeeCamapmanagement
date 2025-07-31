package cse213.refugeecampfinalproject;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ReviewAppointmentController
{
    @javafx.fxml.FXML
    private TableView patienttableView;
    @javafx.fxml.FXML
    private TableColumn nameColum;
    @javafx.fxml.FXML
    private TableColumn timeColum;
    @javafx.fxml.FXML
    private TextArea patientprofileTextArea;
    @javafx.fxml.FXML
    private TableColumn patientsummaryColum;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void viewHistoryOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void gobacktohealthportalOnAction(ActionEvent actionEvent) {
    }
}
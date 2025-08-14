package cse213.refugeecampfinalproject.Volunteer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class VolunteerHoursAndFeedbackController {


    @FXML private ComboBox<String> timePeriodComboBox;
    @FXML private TableView<VolunteerShiftHours> hoursTable;
    @FXML private TableColumn<VolunteerShiftHours, String> shiftTypeColumn;
    @FXML private TableColumn<VolunteerShiftHours, Double> hoursColumn;
    @FXML private TextField feedbackTextArea;
    @FXML private Label feedbackLabel;


    private final ObservableList<VolunteerShiftHours> volunteerHoursList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        timePeriodComboBox.getItems().addAll("Weekly", "Monthly");


        shiftTypeColumn.setCellValueFactory(new PropertyValueFactory<>("shiftType"));
        hoursColumn.setCellValueFactory(new PropertyValueFactory<>("hours"));


        hoursTable.setItems(volunteerHoursList);
    }


    @FXML
    public void checkHoursButtonOnAction() {
        String period = timePeriodComboBox.getValue();

        if (period == null) {
            feedbackLabel.setText("Please select a time period");
            return;
        }

        volunteerHoursList.clear();

        if (period.equals("Weekly")) {
            volunteerHoursList.addAll(
                    new VolunteerShiftHours("Food Distribution", 8),
                    new VolunteerShiftHours("Teaching", 5)
            );
        } else {
            volunteerHoursList.addAll(
                    new VolunteerShiftHours("Food Distribution", 35),
                    new VolunteerShiftHours("Teaching", 20),
                    new VolunteerShiftHours("Cleaning", 15)
            );
        }

        feedbackLabel.setText("Hours loaded for " + period);
    }


    @FXML
    public void submitFeedbackButtonOnAction() {
        String feedback = feedbackTextArea.getText().trim();

        if (feedback.isEmpty()) {
            feedbackLabel.setText("Please write some feedback");
            return;
        }

        System.out.println("New feedback: " + feedback);
        feedbackLabel.setText("Thank you for your feedback!");
        feedbackTextArea.clear();
    }


    @FXML
    public void backToHomeOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(
                getClass().getResource("/cse213/refugeecampfinalproject/Volunteer/VolunteerDashboard.fxml")
        ));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Volunteer Dashboard");
        stage.show();
    }
}

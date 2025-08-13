package cse213.refugeecampfinalproject.Volunteer;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;

public class VolunteerHoursAndFeedbackController {

    @FXML private ComboBox<String> timePeriodComboBox;
    @FXML private TableView<VolunteerShiftHours> hoursTable;
    @FXML private TextField feedbackTextField;
    @FXML private Label feedbackLabel;

    @FXML
    public void initialize() {

        timePeriodComboBox.getItems().addAll("Weekly", "Monthly");
    }

    @FXML
    public void checkHours() {
        String period = timePeriodComboBox.getValue();

        if (period == null) {
            feedbackLabel.setText("Please select a time period");
            return;
        }


        hoursTable.getItems().clear();


        if (period.equals("Weekly")) {
            hoursTable.getItems().add(new VolunteerShiftHours("Food Distribution", 8));
            hoursTable.getItems().add(new VolunteerShiftHours("Teaching", 5));
        } else {
            hoursTable.getItems().add(new VolunteerShiftHours("Food Distribution", 35));
            hoursTable.getItems().add(new VolunteerShiftHours("Teaching", 20));
            hoursTable.getItems().add(new VolunteerShiftHours("Cleaning", 15));
        }

        feedbackLabel.setText("Hours loaded for " + period);
    }

    @FXML
    public void submitFeedback() {
        String feedback = feedbackTextField.getText().trim();

        if (feedback.isEmpty()) {
            feedbackLabel.setText("Please write some feedback");
            return;
        }


        System.out.println("New feedback: " + feedback);
        feedbackLabel.setText("Thank you for your feedback!");
        feedbackTextField.clear();
    }

    @FXML
    public void goBack() throws IOException {

    }
}
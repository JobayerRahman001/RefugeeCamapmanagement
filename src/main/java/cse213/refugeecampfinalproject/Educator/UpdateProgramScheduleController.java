package cse213.refugeecampfinalproject.Educator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class UpdateProgramScheduleController
{
    @javafx.fxml.FXML
    private TextField enternewtimeTextField;
    @javafx.fxml.FXML
    private ComboBox<String> selectprograamComboBox;
    @javafx.fxml.FXML
    private Label errorlabel;
    @javafx.fxml.FXML
    private TextField enternewdateTextField;

    public static ArrayList<EducationProgramModel> programSchedules = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        EducationProgramModel literacyProgram = new EducationProgramModel("Literacy Program", "Literacy", "Adults", "6 months", 30);
        EducationProgramModel languageProgram = new EducationProgramModel("Language Program", "Language", "Children", "3 months", 25);
        EducationProgramModel vocationalProgram = new EducationProgramModel("Vocational Training", "Vocational", "Teens", "1 year", 20);
        selectprograamComboBox.getItems().addAll("literacyProgram", "languageProgram", "vocationalProgram");
    }

    @javafx.fxml.FXML
    public void gobacktoeducationpanelOnAction(ActionEvent actionEvent) throws IOException {  Parent home = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject/EducationPanel.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Education Panel");
        stage.show();
    }

    @javafx.fxml.FXML
    public void submitupdatescheduleOnAction(ActionEvent actionEvent) {
        String selectedProgram = selectprograamComboBox.getValue();
        String newTime = enternewtimeTextField.getText();
        String newDate = enternewdateTextField.getText();
        // Validate input fields
        if (selectedProgram == null || newTime.isEmpty() || newDate.isEmpty()) {
            errorlabel.setText("Error: Please fill in all fields.");
            return;
        }
        // Validate that the new schedule doesn’t clash with existing sessions
        if (!isScheduleAvailable(selectedProgram, newTime, newDate)) {
            errorlabel.setText("Error: New schedule clashes with existing sessions.");
            return;
        }
        // Create a new ProgramSchedule instance
        UpdateProgramScheduleModel newSchedule = new UpdateProgramScheduleModel(selectedProgram, newTime, newDate);
        programSchedules.add(newSchedule.getProgram()); // Save the new schedule
        // Notify assigned teachers and enrolled students (simulated here)
        notifyParticipants(selectedProgram);
        // Show success message
        errorlabel.setText("Program schedule updated successfully!");
    }
    private boolean isScheduleAvailable(String program, String newTime, String newDate) {
        // Placeholder logic for checking schedule availability
        // In a real application, you would check the database for existing schedules
        return true; // Assume schedule is available for demonstration
    }
    private void notifyParticipants(String program) {
        // Placeholder logic for notifying teachers and students
        // In a real application, you would send notifications through your system
        System.out.println("Notified participants of " + program.getProgramName() + " about the schedule change.");
    }
}
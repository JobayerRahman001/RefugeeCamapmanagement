package cse213.refugeecampfinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AssignTeacherController
{
    @javafx.fxml.FXML
    private ComboBox<TeacherModel> selectTeacherComboBox;
    @javafx.fxml.FXML
    private Label displayMassege;
    @javafx.fxml.FXML
    private ComboBox<EducationProgramModel> selectprogramComboBox;


    public static ArrayList<EducationProgramModel> activePrograms = new ArrayList<>();
    public static ArrayList<TeacherModel> availableTeachers = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        // Populate the program and teacher combo boxes with dummy data
        activePrograms.add(new EducationProgramModel("Literacy Program", "Literacy", "Adults", "6 months", 30));
        activePrograms.add(new EducationProgramModel("Language Program", "Language", "Children", "3 months", 25));
        activePrograms.add(new EducationProgramModel("Vocational Training", "Vocational", "Teens", "1 year", 20));
        availableTeachers.add(new TeacherModel("Ahosan Ullah", "Literacy", true));
        availableTeachers.add(new TeacherModel("Mofij Uddin", "Language", true));
        availableTeachers.add(new TeacherModel("Ashik Billah", "Vocational", true));
        selectprogramComboBox.getItems().addAll(activePrograms);
        selectTeacherComboBox.getItems().addAll(availableTeachers);
    }

    @javafx.fxml.FXML
    public void assignTeacherOnAction(ActionEvent actionEvent) {
        EducationProgramModel selectedProgram = selectprogramComboBox.getValue();
        TeacherModel selectedTeacher = selectTeacherComboBox.getValue();
        // Validate selections
        if (selectedProgram == null || selectedTeacher == null) {
            displayMassege.setText("Error: Please select both a program and a teacher.");
            return;
        }
        // Check for slot availability (this is a placeholder for actual logic)
        if (!isSlotAvailable(selectedProgram, selectedTeacher)) {
            displayMassege.setText("Error: Teacher is already assigned to a conflicting schedule.");
            return;
        }
        // Save the assignment (simulated here)
        saveAssignment(selectedProgram, selectedTeacher);
        // Show confirmation message
        displayMassege.setText("Teacher assigned successfully!");
    }


    private boolean isSlotAvailable(EducationProgramModel program, TeacherModel teacher) {
        // Placeholder logic for checking slot availability
        // In a real application, you would check the database for existing assignments
        return true; // Assume slot is available for demonstration
    }
    private void saveAssignment(EducationProgramModel program, TeacherModel teacher) {
        // Placeholder logic for saving the assignment
        // In a real application, you would save this to the database
        System.out.println("Assigned " + teacher.getName() + " to " + program.getProgramName());
    }

    @javafx.fxml.FXML
    public void gobacktoEducationPanelOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject/EducationPanel.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Education Panel");
        stage.show();
    }
}
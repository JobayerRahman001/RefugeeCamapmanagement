package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

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
import java.util.Objects;

public class AssignTeacherController
{
    @javafx.fxml.FXML
    private ComboBox<String> selectTeacherComboBox;
    @javafx.fxml.FXML
    private Label displayMassege;
    @javafx.fxml.FXML
    private ComboBox<String> selectprogramComboBox;

    private ArrayList<TeacherModel> teacherList = new ArrayList<>();
    private ArrayList<ProgramModel> programList = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        loadTeachers();
        loadPrograms();
    }
    public void loadTeachers(){
        teacherList.add(new TeacherModel("Mr.Ali Akbar", "T001", true));
        teacherList.add(new TeacherModel("Mr.Salam Uddin", "T002", true));
        teacherList.add(new TeacherModel("Mr.AkramUjjaman", "T003", false)); // Not available
        // Populate the combo box
        for (TeacherModel teacherModel : teacherList){
            selectTeacherComboBox.getItems().add(teacherModel.getName());
        }
    }
    public void loadPrograms(){
        // Example programs (in a real application, this would come from a database)
        programList.add(new ProgramModel("Literacy Program", "Literacy", "Monday 10 AM - 12 PM"));
        programList.add(new ProgramModel("Language Program", "Language", "Tuesday 1 PM - 3 PM"));
        // Populate the combo box
        for (ProgramModel programModel:programList){
            selectprogramComboBox.getItems().add(programModel.getProgramName());
        }
    }

    @javafx.fxml.FXML
    public void assignTeacherOnAction(ActionEvent actionEvent) {
        String selectedTeacher = selectTeacherComboBox.getValue();
        String selectedProgram = selectprogramComboBox.getValue();
        // Validate selection
        if (selectedTeacher == null || selectedProgram == null) {
            displayMassege.setText("Please select both a teacher and a program.");
            return;
        }
        // Check if the teacher is available
        if (selectedTeacher.isEmpty()) {
            displayMassege.setText("Selected teacher is not available.");
            return;
        }
        // Check for scheduling conflicts (this is a simplified example)
        if (isTeacherAssignedToConflictingSchedule(selectedTeacher,selectedProgram)) {
            displayMassege.setText("Teacher is already assigned to a conflicting schedule.");
            return;
        }

        // Save assignment (in this example, we just display a message)
        // In a real application, you would save this to a database
        displayMassege.setText("Teacher assigned successfully to " + selectedProgram);
    }
    private boolean isTeacherAssignedToConflictingSchedule(String teacher, String program) {
        // This method should check if the teacher is already assigned to a program with a conflicting schedule
        // For simplicity, we will return false (no conflicts) in this example
        return false;
    }

    @javafx.fxml.FXML
    public void gobacktoEducationPanelOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/EducationPanel.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Education Panel");
        stage.show();
    }
}
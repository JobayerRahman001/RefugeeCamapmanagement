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
        teacherList.add(new TeacherModel("Mr.AkramUjjaman", "T003", false));

        for (TeacherModel teacherModel : teacherList){
            selectTeacherComboBox.getItems().add(teacherModel.getName());
        }
    }
    public void loadPrograms(){
        programList.add(new ProgramModel("Literacy Program", "Literacy", "Monday 10 AM - 12 PM"));
        programList.add(new ProgramModel("Language Program", "Language", "Tuesday 1 PM - 3 PM"));

        for (ProgramModel programModel:programList){
            selectprogramComboBox.getItems().add(programModel.getProgramName());
        }
    }

    @javafx.fxml.FXML
    public void assignTeacherOnAction(ActionEvent actionEvent) {
        String selectedTeacher = selectTeacherComboBox.getValue();
        String selectedProgram = selectprogramComboBox.getValue();

        if (selectedTeacher == null || selectedProgram == null) {
            displayMassege.setText("Please select both a teacher and a program.");
            return;
        }
        if (selectedTeacher.isEmpty()) {
            displayMassege.setText("Selected teacher is not available.");
            return;
        }

        if (isTeacherAssignedToConflictingSchedule(selectedTeacher,selectedProgram)) {
            displayMassege.setText("Teacher is already assigned to a conflicting schedule.");
            return;
        }


        displayMassege.setText("Teacher assigned successfully to " + selectedProgram);
    }
    private boolean isTeacherAssignedToConflictingSchedule(String teacher, String program) {
        return false;
    }

    @javafx.fxml.FXML
    public void gobacktoEducationPanelOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Educator/EducationPanel.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Education Panel");
        stage.show();
    }
}
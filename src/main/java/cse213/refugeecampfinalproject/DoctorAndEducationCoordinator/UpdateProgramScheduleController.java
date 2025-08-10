package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

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
import java.util.Objects;

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

    private ArrayList<ProgramModel> programList = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        loadPrograms();
    }
    private void loadPrograms() {
        // Example programs (in a real application, this would come from a database)
        programList.add(new ProgramModel("Literacy Program", "Literacy", "Monday 10 AM - 12 PM"));
        programList.add(new ProgramModel("Language Program", "Language", "Tuesday 1 PM - 3 PM"));
        // Populate the combo box
        for (ProgramModel pm : programList){
            selectprograamComboBox.getItems().add(pm.getProgramName());
        }
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
    public void submitupdatescheduleOnAction(ActionEvent actionEvent) {
        String selectedProgram = selectprograamComboBox.getValue();
        String newDate = enternewdateTextField.getText();
        String newTime = enternewtimeTextField.getText();
        String newSchedule = newDate + " " + newTime;

        if (selectedProgram == null) {
            errorlabel.setText("Please select a program.");
            return;
        }

        if (isScheduleClashing(selectedProgram, newSchedule)) {
            errorlabel.setText("New schedule clashes with existing sessions.");
            return;
        }

        for (ProgramModel program : programList) {
            if (program.getProgramName().equalsIgnoreCase(selectedProgram)) {
                program.setSchedule(newSchedule);
                break;
            }
        }
        notifyTeachersAndStudents(selectedProgram);
        errorlabel.setText("Program schedule updated successfully.");
    }
    private boolean isScheduleClashing(String program, String newSchedule) {
        return false;
    }
    private void notifyTeachersAndStudents(String program) {
        System.out.println("Notifying teachers and students about the new schedule for " + program);
    }
}

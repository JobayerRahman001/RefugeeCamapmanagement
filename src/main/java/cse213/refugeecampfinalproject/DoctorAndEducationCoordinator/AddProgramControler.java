package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

import cse213.refugeecampfinalproject.DoctorAndEducationCoordinator.EducationProgramModel;
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

public class AddProgramControler
{
    @javafx.fxml.FXML
    private ComboBox<String> programtypecomboBox;
    @javafx.fxml.FXML
    private TextField durationTextField;
    @javafx.fxml.FXML
    private TextField agegroupTextField;
    @javafx.fxml.FXML
    private TextField programNameTextField;
    @javafx.fxml.FXML
    private Label displayMassegeLabel;
    @javafx.fxml.FXML
    private TextField studentcapacityTextField;
    private ArrayList<EducationProgramModel> programList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        programtypecomboBox.getItems().addAll("Literacy", "Language", "Vocational");
    }

    @javafx.fxml.FXML
    public void submitFormOnAction(ActionEvent actionEvent) {
        String programName = programNameTextField.getText();
        String programType = programtypecomboBox.getValue();
        String ageGroup = agegroupTextField.getText();
        String duration = durationTextField.getText();
        int capacity;
        // Validate input fields
        if (programName.isEmpty() || programType == null || ageGroup.isEmpty() || duration.isEmpty() || studentcapacityTextField.getText().isEmpty()) {
            displayMassegeLabel.setText("Please fill in all fields.");
            return;
        }
        try {
            capacity = Integer.parseInt(studentcapacityTextField.getText());
        } catch (NumberFormatException e) {
            displayMassegeLabel.setText("Capacity must be a number.");
            return;
        }
        // Check for existing duplicate program
        for (EducationProgramModel program : programList) {
            if (program.getProgramName().equalsIgnoreCase(programName) && program.getProgramType().equals(programType)) {
                displayMassegeLabel.setText("Program already exists.");
                return;
            }
        }
        // Save new program in system database (in this case, the list)
        EducationProgramModel newProgram = new EducationProgramModel(programName, programType, ageGroup, duration, capacity);
        programList.add(newProgram);
        // Display confirmation message
        displayMassegeLabel.setText("Program added successfully.");
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
package cse213.refugeecampfinalproject;

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

    public static ArrayList<EducationProgramModel> existingPrograms = new ArrayList<>();

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
        String studentCapacity = studentcapacityTextField.getText();
        // Validate input fields
        if (programName.isEmpty() || programType == null || ageGroup.isEmpty() || duration.isEmpty() || studentCapacity.isEmpty()) {
            displayMassegeLabel.setText("Error: Please fill in all fields.");
            return;
        }
        // Check for existing duplicate program
        for (EducationProgramModel programModel:existingPrograms) {
            if (programModel.getProgramName().equalsIgnoreCase(programName) && programModel.getProgramType().equalsIgnoreCase(programType)) {
                displayMassegeLabel.setText("Error: Program already exists.");
                return;
            }
        }
        EducationProgramModel newProgram = new EducationProgramModel(programName, programType, ageGroup, duration, Integer.parseInt(studentCapacity));
        // Save the new program to the database (simulated here by adding to the list)
        existingPrograms.add(newProgram);
        // Display success message
        displayMassegeLabel.setText("Program added successfully!");
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
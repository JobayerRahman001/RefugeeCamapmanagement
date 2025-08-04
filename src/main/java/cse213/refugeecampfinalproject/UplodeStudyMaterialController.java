package cse213.refugeecampfinalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UplodeStudyMaterialController
{
    @javafx.fxml.FXML
    private TextField materialdescriptionTextField;
    @javafx.fxml.FXML
    private Label showselectedfilenamelabel;
    @javafx.fxml.FXML
    private ComboBox<EducationProgramModel> selectprogramComboBox;
    @javafx.fxml.FXML
    private Label errorsuccesslabel;

    private File selectedFile;

    public static ArrayList<EducationProgramModel> activePrograms = new ArrayList<>();
    public static ArrayList<StudyMaterialsModel> uploadedMaterials = new ArrayList<>(); // List to store uploaded materials
    @javafx.fxml.FXML
    public void initialize() {
        // Populate the program combo box with dummy data
        activePrograms.add(new EducationProgramModel("Literacy Program", "Literacy", "Adults", "6 months", 30));
        activePrograms.add(new EducationProgramModel("Language Program", "Language", "Children", "3 months", 25));
        activePrograms.add(new EducationProgramModel("Vocational Training", "Vocational", "Teens", "1 year", 20));
        selectprogramComboBox.getItems().addAll(activePrograms);
    }

    @javafx.fxml.FXML
    public void gobacktoeducationpanelOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject/EducationPanel.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Education Panel");
        stage.show();
    }

    @javafx.fxml.FXML
    public void selectedfileOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF Files", "*.pdf"),
                new FileChooser.ExtensionFilter("Video Files", "*.mp4", "*.avi"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );
        selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            showselectedfilenamelabel.setText(selectedFile.getName());
        } else {
            showselectedfilenamelabel.setText("No file selected.");
        }
    }

    @javafx.fxml.FXML
    public void uplodefileOnAction(ActionEvent actionEvent) {
        EducationProgramModel selectedProgram = selectprogramComboBox.getValue();
        String description = materialdescriptionTextField.getText();
        // Validate input fields
        if (selectedProgram == null || selectedFile == null || description.isEmpty()) {
            errorsuccesslabel.setText("Error: Please fill in all fields and select a file.");
            return;
        }
        // Validate file format and size
        if (!isFileValid(selectedFile)) {
           errorsuccesslabel.setText("Error: Invalid file format or size.");
            return;
        }
        // Create a new StudyMaterial instance and store it
        StudyMaterialsModel newMaterial = new StudyMaterialsModel(selectedProgram, selectedFile, description);
        uploadedMaterials.add(newMaterial); // Store the uploaded material
        // Show success message
        errorsuccesslabel.setText("File uploaded successfully!");
    }
    private boolean isFileValid(File file) {
        // Check file format and size (example: max size 10MB)
        String fileName = file.getName();
        long fileSize = file.length(); // Size in bytes
        // Check file extension
        if (!(fileName.endsWith(".pdf") || fileName.endsWith(".mp4") || fileName.endsWith(".avi"))) {
            return false;
        }
        // Check file size (10MB limit)
        if (fileSize > 10 * 1024 * 1024) {
            return false;
        }
        return true;
    }

}
package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

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
import java.util.Objects;

public class UplodeStudyMaterialController
{
    @javafx.fxml.FXML
    private TextField materialdescriptionTextField;
    @javafx.fxml.FXML
    private Label showselectedfilenamelabel;
    @javafx.fxml.FXML
    private ComboBox<String> selectprogramComboBox;
    @javafx.fxml.FXML
    private Label errorsuccesslabel;

    private ArrayList<StudyMaterialsModel> studyMaterials = new ArrayList<>();
    private File selectedFile;
    @javafx.fxml.FXML
    public void initialize() {
        selectprogramComboBox.getItems().addAll("Literacy Program", "Language Program", "Vocational Program");
    }

    @javafx.fxml.FXML
    public void gobacktoeducationpanelOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Educator/EducationPanel.fxml")));
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
            showselectedfilenamelabel.setText("Selected file: " + selectedFile.getName());
        } else {
            showselectedfilenamelabel.setText("No file selected.");
        }
    }

    @javafx.fxml.FXML
    public void uplodefileOnAction(ActionEvent actionEvent) {
        String description = materialdescriptionTextField.getText();
        String selectedProgram = selectprogramComboBox.getValue();
        // Validate inputs
        if (selectedFile == null) {
            errorsuccesslabel.setText("Please select a file to upload.");
            return;
        }
        if (selectedProgram == null) {
            errorsuccesslabel.setText("Please select a program.");
            return;
        }
        if (!validateFile(selectedFile)) {
            errorsuccesslabel.setText("Invalid file format or size.");
            return;
    }
        StudyMaterialsModel material = new StudyMaterialsModel(selectedFile.getName(), description, selectedProgram);
        studyMaterials.add(material);

        errorsuccesslabel.setText("File uploaded successfully: " + selectedFile.getName());
        materialdescriptionTextField.clear();
        showselectedfilenamelabel.setText("No file selected.");
        selectprogramComboBox.setValue(null);
        selectedFile = null;
    }

    private boolean validateFile(File file) {
        if (file.length() > 10 * 1024 * 1024) {
            return false;
        }
        String fileName = file.getName();
        return fileName.endsWith(".pdf") && fileName.endsWith(".mp4") && fileName.endsWith(".avi");
    }

}
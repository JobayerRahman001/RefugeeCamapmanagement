package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

import cse213.refugeecampfinalproject.Refugee.HealthServicesModel;
import cse213.refugeecampfinalproject.Refugee.HealthcareServicesController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class UplodeTestresultController
{
    @javafx.fxml.FXML
    private ComboBox<String> selectpatientComboBox;
    @javafx.fxml.FXML
    private Label confirmationlabel;
    @javafx.fxml.FXML
    private TextField reportTypeTextField;
    @javafx.fxml.FXML
    private DatePicker datepicker;
    @javafx.fxml.FXML
    private TextField filepathTextField;

    private File selectedFile;
    public static ArrayList<HealthServicesModel> HealthcareServicesList = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        HealthcareServicesList.clear();
        HealthcareServicesList.addAll(HealthcareServicesController.HealthcareServicesList);

        HealthcareServicesList.add(new HealthServicesModel("R01", null, "fever", "Sun 2pm", null, null, null, null, null, "Pending"));
        HealthcareServicesList.add(new HealthServicesModel("R05", null, "sore throat", "Wed 5pm", null, null, null, null, null, "Pending"));
        for (HealthServicesModel healthModel : HealthcareServicesList) {
            selectpatientComboBox.getItems().add(healthModel.getRefugeeID());
        }
    }


    @javafx.fxml.FXML
    public void uplodereportOnAction(ActionEvent actionEvent) {
        String selectPatient = selectpatientComboBox.getValue();
        LocalDate date = datepicker.getValue();
        String reportType = reportTypeTextField.getText();

        if (selectPatient == null && date== null && reportType.isEmpty()){
            showAlert("Error: Please fill in all fields and select a file.");
            return;
        }
        if (!isFileValid(selectedFile)) {
            showAlert("Error: Invalid file format. Please select a PDF or image file.");
            return;
        }

        TestResultModel testResultModel = new TestResultModel(selectPatient,reportType,selectedFile,date);
        showAlert("Success: Report uploaded successfully ");
    }

    @javafx.fxml.FXML
    public void openfilechooserOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("PDF File",".*pdf"),
                new FileChooser.ExtensionFilter("Image File",".*png",".*jpg",".*jpeg"),
                new FileChooser.ExtensionFilter("All File","*.*")
        );
        selectedFile= fileChooser.showOpenDialog(null);
        if (selectedFile!= null){
            filepathTextField.setText(selectedFile.getAbsolutePath());
        }else {
            filepathTextField.setText("No file Selected!");
        }
    }

    @javafx.fxml.FXML
    public void gobacktohealthportalOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Doctor/HealthPortal.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Health Portal");
        stage.show();
    }
    public boolean isFileValid(File file){
        String fileName = file.getName();
        return fileName.endsWith("PDF") && fileName.endsWith(".jpg") && fileName.endsWith(".jpeg") && fileName.endsWith(".png");
    }
    public void showAlert(String massege){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(null);
        alert.setContentText(massege);
        alert.showAndWait();
    }
}
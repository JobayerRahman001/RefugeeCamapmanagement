package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PrescriptionController
{
    @javafx.fxml.FXML
    private TableColumn<MedicineModel,String> medicinenameColum;
    @javafx.fxml.FXML
    private ComboBox<String> selectpatientComboBox;
    @javafx.fxml.FXML
    private TableColumn<MedicineModel,Integer> stockColum;
    @javafx.fxml.FXML
    private TextField durationTextField;
    @javafx.fxml.FXML
    private TableColumn<MedicineModel,String> medicinetypeColum;
    @javafx.fxml.FXML
    private TableView<MedicineModel> medicintableview;
    @javafx.fxml.FXML
    private TextField doseTextField;

    @javafx.fxml.FXML
    private Label confirmationLabel;
    public static ArrayList<MedicineModel> medicineInventory = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        if (medicineInventory.isEmpty()) {
            medicineInventory.add(new MedicineModel("Paracetamol", "Pain Relief", 50));
            medicineInventory.add(new MedicineModel("Ibuprofen", "Anti-inflammatory", 30));
            medicineInventory.add(new MedicineModel("Amoxicillin", "Antibiotic", 40));
            medicinenameColum.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
            medicinetypeColum.setCellValueFactory(new PropertyValueFactory<>("medicineType"));
            stockColum.setCellValueFactory(new PropertyValueFactory<>("stock"));
            // Populate medicine table
            medicintableview.getItems().clear();
            medicintableview.getItems().addAll(medicineInventory);
            // Populate patient combo box (dummy data)
            selectpatientComboBox.getItems().addAll("R001", "R002", "R003", "R004", "R005");
        }
    }
    @javafx.fxml.FXML
    public void creatprecriptionOnAction(ActionEvent actionEvent) {
        MedicineModel selectedMedicine = medicintableview.getSelectionModel().getSelectedItem();
        String selectedPatient = selectpatientComboBox.getValue();
        String dose = doseTextField.getText();
        String duration = durationTextField.getText();
        // Validate all fields are filled
        if (selectedMedicine == null || selectedPatient == null || dose.isEmpty() || duration.isEmpty()) {
            confirmationLabel.setText("Error: Please complete all fields!");
            return;
        }
        // Check medicine availability
        if (selectedMedicine.getStock() <= 0) {
            confirmationLabel.setText("Error: Medicine out of stock!");
            return;
        }
        // Validate dose and duration format (simple validation)
        if (!dose.matches("^[0-9]+(\\.[0-9]+)?$") || !duration.matches("^[0-9]+$")) {
            confirmationLabel.setText("Error: Invalid dose or duration format!");
            return;
        }
        // Create and save prescription (you would connect this to your database)
        // For now we'll just reduce the stock
        selectedMedicine.setStock(selectedMedicine.getStock() - 1);
        medicintableview.refresh();
        // Show success message
        confirmationLabel.setText("Prescription created successfully for " + selectedPatient +
                "\nMedicine: " + selectedMedicine.getMedicineName() +
                "\nDose: " + dose + "\nDuration: " + duration + " days");

    }

    @javafx.fxml.FXML
    public void gobacktohealthportalOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject/Doctor/HealthPortal.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Health Portal");
        stage.show();
    }
}
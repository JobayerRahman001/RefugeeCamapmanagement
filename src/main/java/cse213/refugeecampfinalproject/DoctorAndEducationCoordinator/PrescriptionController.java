package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

import cse213.refugeecampfinalproject.Refugee.HealthServicesModel;
import cse213.refugeecampfinalproject.Refugee.HealthcareServicesController;
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
    public static ArrayList<MedicineModel> medicineList = new ArrayList<>();
    public static ArrayList<HealthServicesModel> HealthcareServicesList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        if (medicineList.isEmpty()) {
            medicineList.add(new MedicineModel("Paracetamol", "Pain Relief", 50));
            medicineList.add(new MedicineModel("Ibuprofen", "Anti-inflammatory", 30));
            medicineList.add(new MedicineModel("Amoxicillin", "Antibiotic", 40));
            medicinenameColum.setCellValueFactory(new PropertyValueFactory<>("medicineName"));
            medicinetypeColum.setCellValueFactory(new PropertyValueFactory<>("medicineType"));
            stockColum.setCellValueFactory(new PropertyValueFactory<>("stock"));

            medicintableview.getItems().clear();
            medicintableview.getItems().addAll(medicineList);

            HealthcareServicesList.clear();
            HealthcareServicesList.addAll(HealthcareServicesController.HealthcareServicesList);

            HealthcareServicesList.add(new HealthServicesModel("R01", null, "fever", "Sun 2pm", null, null, null, null, null, "Pending"));
            HealthcareServicesList.add(new HealthServicesModel("R05", null, "sore throat", "Wed 5pm", null, null, null, null, null, "Pending"));

            for (HealthServicesModel healthModel : HealthcareServicesList) {
                selectpatientComboBox.getItems().add(healthModel.getRefugeeID());
            }
        }
    }
    @javafx.fxml.FXML
    public void creatprecriptionOnAction(ActionEvent actionEvent) {
        MedicineModel selectedMedicine = medicintableview.getSelectionModel().getSelectedItem();
        String selectedPatient = selectpatientComboBox.getValue();
        String dose = doseTextField.getText();
        String duration = durationTextField.getText();

        if (selectedMedicine == null || selectedPatient == null || dose.isBlank() || duration.isBlank()) {
            confirmationLabel.setText("Error: Please complete all fields!");
            return;
        }


        if (selectedMedicine.getStock() <= 0) {
            confirmationLabel.setText("Error: Medicine out of stock!");
            return;
        }


//        if (!dose.replace(".", "").chars().allMatch(Character::isDigit)) {
//            confirmationLabel.setText("Error: Dose must be numeric (e.g., 1.5)!");
//            return;
//        }
//        if (!duration.chars().allMatch(Character::isDigit)) {
//            confirmationLabel.setText("Error: Duration must be a whole number!");
//            return;
//        }

        selectedMedicine.setStock(selectedMedicine.getStock() - 1);
        medicintableview.refresh();


        confirmationLabel.setText(
                "Prescription created successfully!\n" +
                        "Patient ID: " + selectedPatient +
                        "\nMedicine: " + selectedMedicine.getMedicineName() +
                        "\nDose: " + dose +
                        "\nDuration: " + duration + " days\n" +
                        "Prescription sent to pharmacy & patient profile."
        );

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
package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;
import cse213.refugeecampfinalproject.Refugee.HealthServicesModel;
import cse213.refugeecampfinalproject.Refugee.HealthcareServicesController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ReviewAppointmentController
{

    @javafx.fxml.FXML
    private TableColumn<HealthServicesModel, String> symptomsTableCol;
    @javafx.fxml.FXML
    private TableView<HealthServicesModel> patientTableView;
    @javafx.fxml.FXML
    private TableColumn<HealthServicesModel, String> appointmentTimeTableCol;
    @javafx.fxml.FXML
    private TableColumn<HealthServicesModel, String> refugeeIDTableCol;
    @javafx.fxml.FXML
    private TableColumn<HealthServicesModel, String> statusTableCol;

public static ArrayList<HealthServicesModel> HealthcareServicesList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        HealthcareServicesList.clear();
        HealthcareServicesList.addAll(HealthcareServicesController.HealthcareServicesList);
        //dummy data
        HealthcareServicesList.add(new HealthServicesModel("R01", null, "fever", "Sun 2pm", null, null, null, null, null, "Pending"));
        HealthcareServicesList.add(new HealthServicesModel("R05", null, "sore throat", "Wed 5pm", null, null, null, null, null, "Pending"));

        refugeeIDTableCol.setCellValueFactory(new PropertyValueFactory<>("refugeeID"));
        appointmentTimeTableCol.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        symptomsTableCol.setCellValueFactory(new PropertyValueFactory<>("symptoms"));
        statusTableCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        patientTableView.getItems().clear();
        patientTableView.getItems().addAll(HealthcareServicesList);
    }

    @javafx.fxml.FXML
    public void gobacktohealthportalOnAction(ActionEvent actionEvent) throws IOException {
<<<<<<< HEAD
        Parent home = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject//DoctorAndEducationCoordinator/HealthPortal.fxml"));
=======
        Parent home = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject/Doctor/HealthPortal.fxml"));
>>>>>>> 9ddce292a8b807e01d2a07fba9cb8d2b8cf78e45
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Health Portal");
        stage.show();
    }

    @javafx.fxml.FXML
    public void markSeenOnClick(ActionEvent actionEvent) {
        HealthServicesModel selected = patientTableView.getSelectionModel().getSelectedItem();
        if (selected != null && !selected.getStatus().equals("Seen")) {
            selected.setStatus("Seen");
            patientTableView.refresh();
        }
    }

    @javafx.fxml.FXML
    public void markCancelledOnClick(ActionEvent actionEvent) {
        HealthServicesModel selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
        if(selectedPatient != null&& !selectedPatient.getStatus().equals("Cancelled")) {
            selectedPatient.setStatus("Cancelled");
            patientTableView.refresh();
        }
    }

    @javafx.fxml.FXML
    public void scheduleFollowUpOnClick(ActionEvent actionEvent) {
        HealthServicesModel selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
        if(selectedPatient != null&& !selectedPatient.getStatus().equals("Follow-up")) {
            selectedPatient.setStatus("Follow-up");
            patientTableView.refresh();
        }
    }

    @javafx.fxml.FXML
    public void referHospitalOnClcik(ActionEvent actionEvent) {
        HealthServicesModel selectedPatient = patientTableView.getSelectionModel().getSelectedItem();
        if(selectedPatient != null&& !selectedPatient.getStatus().equals("Referred to a Hospital")) {
            selectedPatient.setStatus("Referred to a Hospital");
            patientTableView.refresh();
        }
    }



    @javafx.fxml.FXML
    public void shownasbinOnAction(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File f = new File("appointments.bin");
            if (f.exists()) {
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                HealthcareServicesList = (ArrayList<HealthServicesModel>) ois.readObject();

                patientTableView.getItems().clear();
                patientTableView.getItems().addAll(HealthcareServicesList);
                showAlert("Appointments loaded from binary file successfully!");
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Binary file does not exist!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            showAlert("Error loading appointments from binary: " + e.getMessage());
        } finally {
            try {
                if (ois != null) ois.close();
                if (fis != null) fis.close();
            } catch (Exception e) {
                showAlert("Error closing file: " + e.getMessage());
            }

        }
    }

    @javafx.fxml.FXML
    public void saveasbinOnAction(ActionEvent actionEvent) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            File f = new File("appointments.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(HealthcareServicesList);
                showAlert("Appointments saved as binary file successfully!");
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(HealthcareServicesList);
                showAlert("Binary file created and appointments saved successfully!");
            }
        } catch (Exception e) {
            showAlert("Error saving appointments as binary: " + e.getMessage());
        } finally {
            try {
                if (oos != null) oos.close();
                if (fos != null) fos.close();
            } catch (Exception e) {
                showAlert("Error closing file: " + e.getMessage());
            }
        }
    }

    @javafx.fxml.FXML
    public void shownastxtOnAction(ActionEvent actionEvent) {
        try {
            File f = new File("appointments.txt");
            if (f.exists()) {
                Scanner scanner = new Scanner(f);
                HealthcareServicesList.clear();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Create a simple appointment with the line as refugeeID for display
                    HealthcareServicesList.add(new HealthServicesModel(line, null, null, null, null, null, null, null, null, "Loaded"));
                }

                scanner.close();
                patientTableView.getItems().clear();
                patientTableView.getItems().addAll(HealthcareServicesList);
                showAlert("Appointments loaded from text file successfully!");
            } else {
                showAlert("Text file does not exist!");
            }
        } catch (Exception e) {
            showAlert("Error loading appointments from text: " + e.getMessage());
        }
    }

    @javafx.fxml.FXML
    public void saveastxtOnAction(ActionEvent actionEvent) {
        FileWriter fw = null;
        try {
            File f = new File("appointments.txt");
            if (f.exists()) {
                fw = new FileWriter(f);
            } else {
                fw = new FileWriter(f);
            }

            String str = "";
            for (HealthServicesModel a : HealthcareServicesList) {
                str += a.toString() + "\n";
            }

            fw.write(str);
            fw.close();
            showAlert("Appointments saved as text file successfully!");
        }catch (Exception e) {
            showAlert("Error saving appointments as text: " + e.getMessage());
        } finally {
            try {
                if (fw != null) fw.close();
            } catch (Exception e) {
                showAlert("Error closing file: " + e.getMessage());
            }
        }}
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
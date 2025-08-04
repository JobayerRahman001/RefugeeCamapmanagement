package cse213.refugeecampfinalproject;

import cse213.refugeecampfinalproject.Educator.EducationProgramModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ArchiveProgramController
{
    @javafx.fxml.FXML
    private TableView<EducationProgramModel> archiveprogramTableView;
    @javafx.fxml.FXML
    private TableColumn<EducationProgramModel,String> programtypeColum;
    @javafx.fxml.FXML
    private TableColumn<EducationProgramModel,String> programnameColum;
    @javafx.fxml.FXML
    private Label statusLabel;

    public static ArrayList<EducationProgramModel> completedPrograms = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        // Set up table columns
        programnameColum.setCellValueFactory(new PropertyValueFactory<>("programName"));
        programtypeColum.setCellValueFactory(new PropertyValueFactory<>("programType"));
        // Load completed programs
        loadCompletedPrograms();
    }
    public

    @javafx.fxml.FXML
    public void gobacktoeducationpanelOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/cse213/refugeecampfinalproject/EducationPanel.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Education Panel");
        stage.show();
    }

    @javafx.fxml.FXML
    public void completeprogramOnAction(ActionEvent actionEvent) {
        EducationProgramModel selectedProgram = archiveprogramTableView.getSelectionModel().getSelectedItem();
        if (selectedProgram != null) {
            // Archive the selected program and release associated resources
            archiveProgram(selectedProgram);
            statusLabel.setText("Program " + selectedProgram.getProgramName() + " archived successfully.");
            // Notify stakeholders (simulated here)
            notifyStakeholders(selectedProgram);
        } else {
            statusLabel.setText("Error: Please select a program to archive.");
        }
    }
    private void archiveProgram(EducationProgramModel program) {
        // Placeholder logic for archiving the program
        // In a real application, you would update the database or data structure
        completedPrograms.remove(program); // Remove from completed programs list
        System.out.println("Archived program: " + program.getProgramName());
    }
    }

    @javafx.fxml.FXML
    public void archiveprogramOnAction(ActionEvent actionEvent) {
        EducationProgram selectedProgram = archiveProgramTableView.getSelectionModel().getSelectedItem();
        if (selectedProgram != null) {
            // Archive the selected program and release associated resources
            archiveProgram(selectedProgram);
            statusLabel.setText("Program " + selectedProgram.getProgramName() + " archived successfully.");
            // Notify stakeholders (simulated here)
            notifyStakeholders(selectedProgram);
        } else {
            statusLabel.setText("Error: Please select a program to archive.");
        }
    }
    private void archiveProgram(EducationProgram program) {
    // Placeholder logic for archiving the program
    // In a real application, you would update the database or data structure
    completedPrograms.remove(program); // Remove from completed programs list
    System.out.println("Archived program: " + program.getProgramName());
    }
private void notifyStakeholders(EducationProgram program) {
    // Placeholder logic for notifying stakeholders
    // In a real application, you would send notifications through your system
    System.out.println("Notified stakeholders about the archival of program: " + program.getProgramName());
}
    }


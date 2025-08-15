package cse213.refugeecampfinalproject.DoctorAndEducationCoordinator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.Objects;

public class ArchiveProgramController
{
    @javafx.fxml.FXML
    private TableView<ArchiveModel> archiveprogramTableView;
    @javafx.fxml.FXML
    private TableColumn<ArchiveModel,String> programtypeColum;
    @javafx.fxml.FXML
    private TableColumn<ArchiveModel,String> programnameColum;
    @javafx.fxml.FXML
    private Label statusLabel;

    private ArrayList<ArchiveModel> archiveModellist = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        programnameColum.setCellValueFactory(new PropertyValueFactory<>("programName"));
        programtypeColum.setCellValueFactory(new PropertyValueFactory<>("programType"));
        loadCompletedPrograms();
    }
    private void loadCompletedPrograms() {
        archiveModellist.add(new ArchiveModel("Literacy Program", "Literacy", "Completed",false));
        archiveModellist.add(new ArchiveModel("Language Program", "Language", "Completed",false));
        ObservableList<ArchiveModel> observableList = FXCollections.observableArrayList(archiveModellist);
        archiveprogramTableView.setItems(observableList);
    }
    @javafx.fxml.FXML
    public void gobacktoeducationpanelOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject//DoctorAndEducationCoordinator/EducationPanel.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Education Panel");
        stage.show();
    }

    @javafx.fxml.FXML
    public void completeprogramOnAction(ActionEvent actionEvent) {
        ArchiveModel selectedProgram = archiveprogramTableView.getSelectionModel().getSelectedItem();

        if (selectedProgram != null) {
            selectedProgram.getSchedule();
            statusLabel.setText("Program " + selectedProgram.getProgramName() + " marked as completed.");
            loadCompletedPrograms();
        } else {
            statusLabel.setText("Please select a program to mark as completed.");
        }
    }

    @javafx.fxml.FXML
    public void archiveprogramOnAction(ActionEvent actionEvent) {
        ArchiveModel selectedProgram = archiveprogramTableView.getSelectionModel().getSelectedItem();
        if (selectedProgram != null) {
            selectedProgram.isArchived();
            statusLabel.setText("Program " + selectedProgram.getProgramName() + " has been archived.");
            notifyStakeholders(selectedProgram);
            loadCompletedPrograms();
        } else {
            statusLabel.setText("Please select a program to archive.");
        }
    }
    private void notifyStakeholders(ArchiveModel program) {
        System.out.println("Notifying stakeholders about the archival of " + program.getProgramName());
    }

}
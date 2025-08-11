package cse213.refugeecampfinalproject.Refugee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AssignedResourcesController {
    @javafx.fxml.FXML
    private TableView<AssignedResourcesModel> assignedResourcesTableView;
    @javafx.fxml.FXML
    private TableColumn<AssignedResourcesModel, String> resourcesCategoryTableCol;
    @javafx.fxml.FXML
    private TableColumn<AssignedResourcesModel, String> assignedDateTableCol;
    @javafx.fxml.FXML
    private TableColumn<AssignedResourcesModel, String> resourcesDetailsTableCol;

public static ObservableList<AssignedResourcesModel> assignedList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backtoDashboardOnClick(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/Refugee/RefugeeDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Refugee Dashboard");
        stage.show();
    }

    @javafx.fxml.FXML
    public void viewAssignedResourcesOnClick(ActionEvent actionEvent) {


        // Dummy data
        assignedList.add(new AssignedResourcesModel("Shelter", "Block-C, Unit 12B", "2025-07-20"));
        assignedList.add(new AssignedResourcesModel("Food Ration", "Weekly Package: Rice, Lentils, Oil", "2025-07-21"));
        assignedList.add(new AssignedResourcesModel("Education", "Enrolled in Vocational Program", "2025-07-22"));
        assignedList.add(new AssignedResourcesModel("Aid", "Received Winter Blanket Pack", "2025-07-19"));

        assignedList.addAll(AssignedResourcesModel.assignedList);

        resourcesCategoryTableCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        resourcesDetailsTableCol.setCellValueFactory(new PropertyValueFactory<>("details"));
        assignedDateTableCol.setCellValueFactory(new PropertyValueFactory<>("assignedDate"));

        assignedResourcesTableView.getItems().clear();
        assignedResourcesTableView.getItems().addAll(assignedList);
    }
}

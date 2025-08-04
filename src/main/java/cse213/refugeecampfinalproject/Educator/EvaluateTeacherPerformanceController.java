package cse213.refugeecampfinalproject.Educator;

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

public class EvaluateTeacherPerformanceController
{
    @javafx.fxml.FXML
    private TableColumn<TeacherPerformanceFeddbackDataModel,String> comentsummaryColum;
    @javafx.fxml.FXML
    private TableColumn<TeacherPerformanceFeddbackDataModel,Double> averageratingColum;
    @javafx.fxml.FXML
    private TableColumn<TeacherPerformanceFeddbackDataModel,Integer> attendenceColum;
    @javafx.fxml.FXML
    private TableView<TeacherPerformanceFeddbackDataModel> evulateteachertableview;
    @javafx.fxml.FXML
    private TableColumn<TeacherPerformanceFeddbackDataModel,String> teachernameColum;
    @javafx.fxml.FXML
    private Label statuslabel;

    public static ArrayList<TeacherPerformanceFeddbackDataModel> feedbackDataList = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        // Set up table columns
        teachernameColum.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
        averageratingColum.setCellValueFactory(new PropertyValueFactory<>("averageRating"));
        attendenceColum.setCellValueFactory(new PropertyValueFactory<>("attendance"));
        comentsummaryColum.setCellValueFactory(new PropertyValueFactory<>("commentsSummary"));
        // Load feedback data
        loadAllFeedback();
    }
    private void loadAllFeedback() {
    // Simulated data fetching (in a real application, this would come from a database)
        feedbackDataList.add(new TeacherPerformanceFeddbackDataModel("Jane Smith", 4.0, 85, "Good explanations, but could improve on feedback."));
        feedbackDataList.add(new TeacherPerformanceFeddbackDataModel("John Doe", 4.5, 90, "Great teacher, very engaging."));
        feedbackDataList.add(new TeacherPerformanceFeddbackDataModel("Alice Johnson", 3.5, 80, "Average performance, needs to be more interactive."));
        // Populate the table with feedback data
        evulateteachertableview.getItems().clear();
        evulateteachertableview.getItems().addAll(feedbackDataList);
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
    public void loadallfeedbackOnAction(ActionEvent actionEvent) {
        loadAllFeedback();
        statuslabel.setText("Feedback data loaded successfully.");
    }
}
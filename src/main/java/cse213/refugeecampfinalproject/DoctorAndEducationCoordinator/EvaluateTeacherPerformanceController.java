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

public class EvaluateTeacherPerformanceController
{
    @javafx.fxml.FXML
    private TableColumn<FeedBackModel,String> comentsummaryColum;
    @javafx.fxml.FXML
    private TableColumn<FeedBackModel,Double> averageratingColum;
    @javafx.fxml.FXML
    private TableColumn<FeedBackModel,Integer> attendenceColum;
    @javafx.fxml.FXML
    private TableView<FeedBackModel> evulateteachertableview;
    @javafx.fxml.FXML
    private TableColumn<FeedBackModel,String> teachernameColum;
    @javafx.fxml.FXML
    private Label statuslabel;

    private ArrayList<FeedBackModel> feedbackList = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        // Set up the table columns
        teachernameColum.setCellValueFactory(new PropertyValueFactory<>("teacherName"));
        averageratingColum.setCellValueFactory(new PropertyValueFactory<>("averageRating"));
        attendenceColum.setCellValueFactory(new PropertyValueFactory<>("attendanceCount"));
        comentsummaryColum.setCellValueFactory(new PropertyValueFactory<>("commentsSummary"));
    }

    @javafx.fxml.FXML
    public void gobacktoeducationpanelOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/EducationPanel.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("Education Panel");
        stage.show();
    }

    @javafx.fxml.FXML
    public void loadallfeedbackOnAction(ActionEvent actionEvent) {
        feedbackList.clear(); // Clear previous data
        feedbackList.add(new FeedBackModel("Mr.Ali Akbar", 4.5, 30, "Great teacher, very engaging."));
        feedbackList.add(new FeedBackModel("Mr.Salam Uddin", 3.8, 25, "Good, but needs to improve on attendance."));
        feedbackList.add(new FeedBackModel("Mr.AkramUjjaman", 4.0, 28, "Very knowledgeable and helpful."));

        ObservableList<FeedBackModel> observableList = FXCollections.observableArrayList(feedbackList);
        evulateteachertableview.setItems(observableList);
    }


}
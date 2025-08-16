package cse213.refugeecampfinalproject.UNHCR;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DailyFundBalanceController
{
    @javafx.fxml.FXML
    private Label datafreshnesslabel;
    @javafx.fxml.FXML
    private Label fundheadinglabel;
    @javafx.fxml.FXML
    private TextField avilableBalanceTextField;
    @javafx.fxml.FXML
    private Label statuslabel;
    @javafx.fxml.FXML
    private TextField lastupdatedTextField;

    private dailyFundBalanceModel balanceData;
    @javafx.fxml.FXML
    public void initialize() {
        fundheadinglabel.setText("Today's Fund Balance");

    }

    @javafx.fxml.FXML
    public void viewtodaybalanceOnAction(ActionEvent actionEvent) {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        balanceData = new dailyFundBalanceModel(15000.50, "now", true);

        boolean fresh = LocalDate.parse(balanceData.getLastUpdated().substring(0, 10))
                .isEqual(LocalDate.now());
        balanceData.setFresh(fresh);

        avilableBalanceTextField.setText(String.format("%.2f", balanceData.getAvailableBalance()));
        lastupdatedTextField.setText(balanceData.getLastUpdated());
        datafreshnesslabel.setText(fresh ? "Data is up-to-date" : "Data is outdated");
        statuslabel.setText("Balance data retrieved successfully.");
    }

    @javafx.fxml.FXML
    public void gobacktoundashboardOnAction(ActionEvent actionEvent) throws IOException {
        Parent home = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/cse213/refugeecampfinalproject/UNHCR/UNRepDashboard.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(home));
        stage.setTitle("UNHCR");
        stage.show();
    }
}
module cse213.refugeecampfinalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens cse213.refugeecampfinalproject to javafx.fxml;
    exports cse213.refugeecampfinalproject;
    exports cse213.refugeecampfinalproject.Refugee;
    opens cse213.refugeecampfinalproject.Refugee to javafx.fxml;
    exports cse213.refugeecampfinalproject.Admin;
    opens cse213.refugeecampfinalproject.Admin to javafx.fxml;
}
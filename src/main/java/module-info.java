module cse213.refugeecampmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens cse213.refugeecampmanagement to javafx.fxml;
    exports cse213.refugeecampmanagement;
}
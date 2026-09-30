module com.mycompany.skyscope {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.skyscope to javafx.fxml;
    exports com.mycompany.skyscope;
}

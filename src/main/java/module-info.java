module com.sankdev {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sankdev to javafx.fxml;
    exports com.sankdev;
}

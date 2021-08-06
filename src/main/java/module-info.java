module com.sankdev {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sankdev to javafx.fxml;
    exports com.sankdev;
  exports com.sankdev.locale;
  opens com.sankdev.locale to javafx.fxml;
}

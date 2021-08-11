module com.sankdev {
  exports com.sankdev;
  requires javafx.controls;
  requires javafx.fxml;
  opens com.sankdev to javafx.fxml;
  opens com.sankdev.portfolio to javafx.base;
  opens com.sankdev.dao to javafx.base;
  exports com.sankdev.controller;
  opens com.sankdev.controller to javafx.fxml;
  exports com.sankdev.model;
  opens com.sankdev.model to javafx.fxml;
}

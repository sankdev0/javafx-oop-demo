package com.sankdev;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class PrimaryController {

  // Inject the resource bundle into the controller
  private ResourceBundle theGUIBundle;

  @FXML
  private void switchToSecondary() throws IOException {
    App.setRoot("secondary");
  }
}

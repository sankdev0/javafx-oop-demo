package com.sankdev.controller;

import com.sankdev.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class AddItemController {

  @FXML
  private void switchToPrimary() throws IOException {
    App.setRoot("primary");
  }
}
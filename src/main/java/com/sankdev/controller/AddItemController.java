package com.sankdev.controller;

import com.sankdev.App;
import com.sankdev.portfolio.Item;
import com.sankdev.portfolio.Publication;
import com.sankdev.service.PortfolioService;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller for adding a new portfolio item.
 */
public class AddItemController {

  private static final PortfolioService portfolioService = new PortfolioService();

  @FXML
  public TextField newItemId;

  @FXML
  public TextField newItemName;

  @FXML
  private void switchToPrimary() throws IOException {
    App.setRoot("primary");
  }

  @FXML
  private void saveItem() throws IOException {
    Item newItem = new Publication(this.newItemId.getText(), this.newItemName.getText());
    portfolioService.addItem(newItem);
    App.setRoot("primary");
  }
}
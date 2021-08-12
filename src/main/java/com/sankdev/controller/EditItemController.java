package com.sankdev.controller;

import com.sankdev.App;
import com.sankdev.model.ItemHolder;
import com.sankdev.portfolio.Certificate;
import com.sankdev.portfolio.Item;
import com.sankdev.service.PortfolioService;
import java.io.IOException;
import java.time.Year;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

/**
 * Controller for adding a new portfolio item.
 */
public class EditItemController {

  // Model
  private final ItemHolder itemHolder = ItemHolder.getInstance();
  private static final PortfolioService portfolioService = new PortfolioService();

  @FXML
  private Node root;
  @FXML
  private TextField itemId;
  @FXML
  private TextField itemName;
  @FXML
  private Button okButton;

  // Automatically called by FXML Loader
  // NOTE: Good place to hook onto the model
  public void initialize() {
    if (itemHolder.getItem() != null) {
      this.itemId.setText(itemHolder.getItem().getId());
      this.itemName.setText(itemHolder.getItem().getName());
    }
    setDefaultKeyHandling(root);
    setDefaultKeyHandling(okButton);
  }

  private void setDefaultKeyHandling(Node node) {
    node.setOnKeyPressed(keyEvent -> {
      try {
        if (keyEvent.getCode() == KeyCode.ENTER) {
          saveItem();
        } else if (keyEvent.getCode() == KeyCode.ESCAPE) {
          switchToPrimary();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }

  @FXML
  private void switchToPrimary() throws IOException {
    App.setRoot(App.PRIMARY_VIEW);
  }

  @FXML
  private void saveItem() throws IOException {
    if (itemHolder.getItem() != null) {
      Item editedItem = itemHolder.getItem();
      editedItem.setId(this.itemId.getText());
      editedItem.setName(this.itemName.getText());
    } else {
      Item newItem = new Certificate(this.itemId.getText(), this.itemName.getText(),
          Year.of(2019), "Синергия");
      portfolioService.addPortfolioItem(newItem);
    }
    App.setRoot(App.PRIMARY_VIEW);
  }
}
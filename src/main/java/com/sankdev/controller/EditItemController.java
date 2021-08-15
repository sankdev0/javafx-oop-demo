package com.sankdev.controller;

import com.sankdev.App;
import com.sankdev.model.PortfolioModel;
import com.sankdev.model.PortfolioModelImpl;
import com.sankdev.portfolio.Certificate;
import com.sankdev.portfolio.Item;
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
  private final PortfolioModel portfolioModel = PortfolioModelImpl.getModel();

  @FXML
  private Node editVBox;
  @FXML
  private TextField itemId;
  @FXML
  private TextField itemName;
  @FXML
  private Button okButton;

  // Automatically called by FXML Loader
  // NOTE: Good place to hook onto the model
  public void initialize() {
    if (portfolioModel.getPortfolioItem() != null) {
      this.itemId.setText(portfolioModel.getPortfolioItem().getId());
      this.itemName.setText(portfolioModel.getPortfolioItem().getName());
    }
    setDefaultKeyHandling(editVBox);
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
    if (portfolioModel.getPortfolioItem() != null) {
      Item editedItem = portfolioModel.getPortfolioItem();
      editedItem.setId(this.itemId.getText());
      editedItem.setName(this.itemName.getText());
    } else {
      Item newItem = new Certificate(this.itemId.getText(), this.itemName.getText(),
          Year.of(2019), "Синергия");
      portfolioModel.addItem(newItem);
    }
    App.setRoot(App.PRIMARY_VIEW);
  }
}
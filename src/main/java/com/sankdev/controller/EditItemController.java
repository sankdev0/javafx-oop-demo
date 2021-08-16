package com.sankdev.controller;

import com.sankdev.App;
import com.sankdev.model.PortfolioModel;
import com.sankdev.model.PortfolioModelImpl;
import com.sankdev.portfolio.Certificate;
import com.sankdev.portfolio.Item;
import java.io.IOException;
import java.time.Year;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

/**
 * Controller for adding a new portfolio item.
 */
public class EditItemController {

  // Model
  private final PortfolioModel portfolioModel = PortfolioModelImpl.getModel();
  private static final ResourceBundle guiResourceBundle = ResourceBundle.getBundle(
      "com.sankdev.multilang.GuiResourceBundle", Locale.getDefault());

  @FXML
  public ComboBox itemTypeCBox;

  @FXML
  private Node editVBox;
  @FXML
  private TextField itemIdTxt;
  @FXML
  private TextField itemNameTxt;
  @FXML
  public TextField itemYearTxt;
  @FXML
  public TextField itemDescriptionTxt;

  @FXML
  public VBox itemSpecificDetails;
  @FXML
  public Label itemCertifyingBodyLbl;
  @FXML
  public TextField itemCertifyingBodyTxt;
  @FXML
  public Label itemYearOfExpirationLbl;
  @FXML
  public TextField itemYearOfExpirationTxt;
  @FXML
  public VBox itemDegreeLevelVBox;
  @FXML
  public Label itemDegreeLevelLbl;
  @FXML
  public ComboBox itemDegreeLevelCBox;
  @FXML
  public Label itemEditionLbl;
  @FXML
  public TextField itemEditionTxt;
  @FXML
  public Label itemPrintCountLbl;
  @FXML
  public TextField itemPrintCountTxt;

  @FXML
  private Button okButton;

  // Automatically called by FXML Loader
  // NOTE: Good place to hook onto the model
  public void initialize() {
    if (portfolioModel.getPortfolioItem() != null) {
      this.itemIdTxt.setText(portfolioModel.getPortfolioItem().getId());
      this.itemNameTxt.setText(portfolioModel.getPortfolioItem().getName());
    }

    initItemTypeCBox();
    buildItemSpecificDetailsView();

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
      editedItem.setId(this.itemIdTxt.getText());
      editedItem.setName(this.itemNameTxt.getText());
    } else {
      Item newItem = new Certificate(this.itemIdTxt.getText(), this.itemNameTxt.getText(),
          Year.of(2019), "Синергия");
      portfolioModel.addItem(newItem);
    }
    App.setRoot(App.PRIMARY_VIEW);
  }

  private void initItemTypeCBox() {
    itemTypeCBox.setPromptText(guiResourceBundle.getString("itemTypeCBoxPrompt"));
    itemTypeCBox.getItems().add(guiResourceBundle.getString("CertificateType"));
    itemTypeCBox.getItems().add(guiResourceBundle.getString("DiplomaType"));
    itemTypeCBox.getItems().add(guiResourceBundle.getString("PatentType"));
    itemTypeCBox.getItems().add(guiResourceBundle.getString("PublicationType"));
  }

  private VBox buildItemSpecificDetailsView() {
    if (portfolioModel.getPortfolioItem() == null) {
      itemSpecificDetails.setVisible(false);
    } else {
      String itemTypeName = portfolioModel.getPortfolioItem().getClass().getName();
      VBox redrawnVBox;
    }
    return null;
  }
}
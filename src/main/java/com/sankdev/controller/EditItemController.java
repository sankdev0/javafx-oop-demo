package com.sankdev.controller;

import com.sankdev.App;
import com.sankdev.model.PortfolioModel;
import com.sankdev.model.PortfolioModelImpl;
import com.sankdev.portfolio.Certificate;
import com.sankdev.portfolio.Diploma;
import com.sankdev.portfolio.Diploma.Degree;
import com.sankdev.portfolio.Item;
import com.sankdev.portfolio.Patent;
import com.sankdev.portfolio.Publication;
import java.io.IOException;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
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

  // Helper strings
  private static final ResourceBundle guiResourceBundle = ResourceBundle.getBundle(
      "com.sankdev.multilang.GuiResourceBundle", Locale.getDefault());
  private String certificate = guiResourceBundle.getString("CertificateType");
  private String diploma = guiResourceBundle.getString("DiplomaType");
  private String patent = guiResourceBundle.getString("PatentType");
  private String publication = guiResourceBundle.getString("PublicationType");
  private String high = guiResourceBundle.getString("HIGH");
  private String higher = guiResourceBundle.getString("HIGHER");
  private String masters = guiResourceBundle.getString("MASTERS");
  private String doctor = guiResourceBundle.getString("DOCTOR");

  // Model
  private final PortfolioModel portfolioModel = PortfolioModelImpl.getModel();

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

    String itemType;

    initItemTypeCBox();


    if (portfolioModel.getPortfolioItem() == null) {
      itemType = null;
    } else {
      Item theItem = portfolioModel.getPortfolioItem();
      this.itemIdTxt.setText(theItem.getId());
      this.itemNameTxt.setText(theItem.getName());
      this.itemYearTxt.setText(
          theItem.getYear().toString());
      this.itemDescriptionTxt.setText(theItem.getDescription());
      itemType = theItem.getClass().getSimpleName();
      System.out.println("itemType: " + itemType);
      if (itemType.equals("Certificate")) {
        itemType = certificate;
        this.itemTypeCBox.setValue(certificate);
        this.itemCertifyingBodyTxt.setText(((Certificate) theItem).getCertifyingBody());
      } else if (itemType.equals("Diploma")) {
        itemType = diploma;
        this.itemTypeCBox.setValue(diploma);
        this.itemCertifyingBodyTxt.setText(((Diploma) theItem).getCertifyingBody());
        this.itemDegreeLevelCBox.setValue(retrieveDegreeString(((Diploma) theItem).getDegree()));
      } else if (itemType.equals("Patent")) {
        itemType = patent;
        this.itemTypeCBox.setValue(patent);
        this.itemCertifyingBodyTxt.setText(((Patent) theItem).getCertifyingBody());
        this.itemYearOfExpirationTxt.setText(((Patent)
            theItem).getYear().toString());
      } else if (itemType.equals("Publication")) {
        itemType = publication;
        this.itemTypeCBox.setValue(publication);
        this.itemEditionTxt.setText(((Publication) theItem).getEdition());
        this.itemPrintCountTxt.setText(String.valueOf(((Publication) theItem).getPrintCount()));
      } else {
        itemType = null;
      }
    }

    buildItemSpecificDetailsView(itemType);

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

    String itemType;

    if (portfolioModel.getPortfolioItem() != null) {
      Item editedItem = portfolioModel.getPortfolioItem();
      editedItem.setId(this.itemIdTxt.getText());
      editedItem.setName(this.itemNameTxt.getText());
      editedItem.setDescription(this.itemDescriptionTxt.getText());
    } else {
      itemType = String.valueOf(itemTypeCBox.getValue());
      if (itemType.equals(certificate)) {
        Item newItem = new Certificate(this.itemIdTxt.getText(), this.itemNameTxt.getText(),
            Year.of(Integer.parseInt(this.itemYearTxt.getText())),
            this.itemCertifyingBodyTxt.getText());
        portfolioModel.addItem(newItem);
      } else if (itemType.equals(diploma)) {
        Item newItem = new Diploma(this.itemIdTxt.getText(), this.itemNameTxt.getText(),
            Year.of(Integer.parseInt(this.itemYearTxt.getText())),
            this.itemCertifyingBodyTxt.getText(),
            retrieveDegree(String.valueOf(this.itemDegreeLevelCBox.getValue())));
        portfolioModel.addItem(newItem);
      } else if (itemType.equals(patent)) {
        Item newItem = new Patent(this.itemIdTxt.getText(), this.itemNameTxt.getText(),
            Year.of(Integer.parseInt(this.itemYearTxt.getText())),
            this.itemCertifyingBodyTxt.getText(),
            Year.of(Integer.parseInt(this.itemYearOfExpirationTxt.getText())));
        portfolioModel.addItem(newItem);
      } else if (itemType.equals(publication)) {
        Item newItem = new Publication(this.itemIdTxt.getText(), this.itemNameTxt.getText(),
            Year.of(Integer.parseInt(this.itemYearTxt.getText())), this.itemEditionTxt.getText(),
            Integer.parseInt(this.itemPrintCountTxt.getText()));
        portfolioModel.addItem(newItem);
      }
    }
    App.setRoot(App.PRIMARY_VIEW);
  }

  private void initItemTypeCBox() {
    itemTypeCBox.setPromptText(guiResourceBundle.getString("itemTypeCBoxPrompt"));
    itemTypeCBox.getItems().add(certificate);
    itemTypeCBox.getItems().add(diploma);
    itemTypeCBox.getItems().add(patent);
    itemTypeCBox.getItems().add(publication);
  }

  private void hideItemSpecificDetails() {
    itemCertifyingBodyLbl.setVisible(false);
    itemCertifyingBodyLbl.setManaged(false);
    itemCertifyingBodyTxt.setVisible(false);
    itemCertifyingBodyTxt.setManaged(false);

    itemYearOfExpirationLbl.setVisible(false);
    itemYearOfExpirationLbl.setManaged(false);
    itemYearOfExpirationTxt.setVisible(false);
    itemYearOfExpirationTxt.setManaged(false);

    itemDegreeLevelVBox.setVisible(false);
    itemDegreeLevelVBox.setManaged(false);

    itemEditionLbl.setVisible(false);
    itemEditionLbl.setManaged(false);
    itemEditionTxt.setVisible(false);
    itemEditionTxt.setManaged(false);
    itemPrintCountLbl.setVisible(false);
    itemPrintCountLbl.setManaged(false);
    itemPrintCountTxt.setVisible(false);
    itemPrintCountTxt.setManaged(false);
  }

  private VBox buildItemSpecificDetailsView(String itemType) {
    if (itemType == null) {
      hideItemSpecificDetails();
    } else {
      if (itemType.equals(certificate)) {

        hideItemSpecificDetails();

        itemCertifyingBodyLbl.setVisible(true);
        itemCertifyingBodyLbl.setManaged(true);
        itemCertifyingBodyTxt.setVisible(true);
        itemCertifyingBodyTxt.setManaged(true);

      } else if (itemType.equals(diploma)) {

        hideItemSpecificDetails();

        itemCertifyingBodyLbl.setVisible(true);
        itemCertifyingBodyLbl.setManaged(true);
        itemCertifyingBodyTxt.setVisible(true);
        itemCertifyingBodyTxt.setManaged(true);

        itemDegreeLevelVBox.setVisible(true);
        itemDegreeLevelVBox.setManaged(true);

        itemDegreeLevelCBox.setPromptText(
            guiResourceBundle.getString("itemDegreeLevelCBoxPromptText"));
        itemDegreeLevelCBox.getItems().add(high);
        itemDegreeLevelCBox.getItems().add(higher);
        itemDegreeLevelCBox.getItems().add(masters);
        itemDegreeLevelCBox.getItems().add(doctor);

      } else if (itemType.equals(patent)) {

        hideItemSpecificDetails();

        itemCertifyingBodyLbl.setVisible(true);
        itemCertifyingBodyLbl.setManaged(true);
        itemCertifyingBodyTxt.setVisible(true);
        itemCertifyingBodyTxt.setManaged(true);

        itemYearOfExpirationLbl.setVisible(true);
        itemYearOfExpirationLbl.setManaged(true);
        itemYearOfExpirationTxt.setVisible(true);
        itemYearOfExpirationTxt.setManaged(true);

      } else if (itemType.equals(publication)) {

        hideItemSpecificDetails();

        itemEditionLbl.setVisible(true);
        itemEditionLbl.setManaged(true);
        itemEditionTxt.setVisible(true);
        itemEditionTxt.setManaged(true);
        itemPrintCountLbl.setVisible(true);
        itemPrintCountLbl.setManaged(true);
        itemPrintCountTxt.setVisible(true);
        itemPrintCountTxt.setManaged(true);

      }
    }
    return null;
  }

  @FXML
  private void rebuildItemView() throws IOException {
    String itemType;
    itemType = String.valueOf(itemTypeCBox.getValue());
    System.out.println("Rebuilding view: " + itemType);
    if (itemType.equals(certificate)) {
      buildItemSpecificDetailsView(certificate);
    } else if (itemType.equals(diploma)) {
      buildItemSpecificDetailsView(diploma);
    } else if (itemType.equals(patent)) {
      buildItemSpecificDetailsView(patent);
    } else if (itemType.equals(publication)) {
      buildItemSpecificDetailsView(publication);
    }
  }

  private Diploma.Degree retrieveDegree(String degree) {
    if (degree.equals(high)) {
      return Diploma.Degree.HIGH;
    } else if (degree.equals(higher)) {
      return Diploma.Degree.HIGHER;
    } else if (degree.equals(masters)) {
      return Diploma.Degree.MASTERS;
    } else if (degree.equals(doctor)) {
      return Diploma.Degree.DOCTOR;
    } else {
      return null;
    }
  }

  private String retrieveDegreeString(Diploma.Degree degree) {
    if (degree.equals(Degree.HIGH)) {
      return high;
    } else if (degree.equals(Degree.HIGHER)) {
      return higher;
    } else if (degree.equals(Degree.MASTERS)) {
      return masters;
    } else if (degree.equals(Degree.DOCTOR)) {
      return doctor;
    } else {
      return null;
    }
  }
}
package com.sankdev.controller;

import com.sankdev.App;
import com.sankdev.model.PortfolioModel;
import com.sankdev.model.PortfolioModelImpl;
import com.sankdev.portfolio.Certificate;
import com.sankdev.portfolio.Item;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.util.Callback;

/**
 * The Primary controller for the primary scene, i.e. the Application Main Window layout.
 */
public class PrimarySceneController {

  // Helper strings
  private static final ResourceBundle guiResourceBundle = ResourceBundle.getBundle(
      "com.sankdev.multilang.GuiResourceBundle", Locale.getDefault());
  private String certificate = guiResourceBundle.getString("CertificateType");
  private String diploma = guiResourceBundle.getString("DiplomaType");
  private String patent = guiResourceBundle.getString("PatentType");
  private String publication = guiResourceBundle.getString("PublicationType");

  // Model
  private PortfolioModel portfolioModel = PortfolioModelImpl.getModel();

  // Primary scene control bindings
  @FXML
  private BorderPane primaryBorderPane; // the root node
  @FXML
  private TableView<Item> tableView;
  @FXML
  private TableColumn<Item, String> idCol;
  @FXML
  private TableColumn<Item, String> nameCol;
  @FXML
  private TableColumn<Item, String> yearCol;
  @FXML
  private TableColumn<Item, String> typeCol;

  public PrimarySceneController() {
  }

  // Automatically called by FXML Loader
  public void initialize() {

    idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    yearCol.setCellValueFactory(new PropertyValueFactory<>("year"));

    typeCol.setCellValueFactory(
        new Callback<CellDataFeatures<Item, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(TableColumn.CellDataFeatures<Item, String> theItemHolder) {
            if (theItemHolder.getValue() != null) {
              String itemType = theItemHolder.getValue().getClass().getSimpleName();
              if (itemType.equals("Certificate")) {
                itemType = certificate;
              } else if (itemType.equals("Diploma")) {
                itemType = diploma;
              } else if (itemType.equals("Patent")) {
                itemType = patent;
              } else if (itemType.equals("Publication")) {
                itemType = publication;
              } else {
                itemType = null;
              }
              return new SimpleStringProperty(itemType);
            } else {
              return new SimpleStringProperty("<no type>");
            }
          }
        });

    tableView.setItems(portfolioModel.getPortfolioItems());
  }

  @FXML
  private void onAdd() throws IOException {
    portfolioModel.setPortfolioItem(null);
    App.setRoot(App.EDIT_ITEM_VIEW);
  }

  public void onEdit() throws IOException {
    if (tableView.getSelectionModel().getSelectedItem() != null) {
      Item selectedItem = tableView.getSelectionModel().getSelectedItem();
      portfolioModel.setPortfolioItem(selectedItem);
      App.setRoot(App.EDIT_ITEM_VIEW);
    }
  }

  public void onDelete() {
    if (tableView.getSelectionModel().getSelectedItem() != null) {
      Item selectedItem = tableView.getSelectionModel().getSelectedItem();
      portfolioModel.removeItem(selectedItem);
      tableView.setItems(portfolioModel.getPortfolioItems());
    }
  }

  @FXML
  private void savePortfolioItems() throws IOException {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setInitialFileName("items.ser");
    File selectedFile = fileChooser.showOpenDialog(primaryBorderPane.getScene().getWindow());
    portfolioModel.savePortfolioItems(selectedFile);
  }

  @FXML
  private void loadPortfolioItems() throws IOException, ClassNotFoundException {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setInitialFileName("items.ser");
    File selectedFile = fileChooser.showOpenDialog(primaryBorderPane.getScene().getWindow());
    portfolioModel.loadPortfolioItems(selectedFile);
    System.out.println("===>>> Test observable list");
    System.out.println(portfolioModel.getPortfolioItems());
    System.out.println("===>>> Reading the portfolio");
    List<Item> items = new ArrayList<>(portfolioModel.getPortfolioItems());
    for (Item tempItem :
        items) {
      System.out.println("Item read: " + tempItem.getId() + " " + tempItem.getName());
    }
    // TODO find out why this is necessary. Probably because PortfolioDAO INSTANCE is substituted
    //  when deserialized
    tableView.setItems(portfolioModel.getPortfolioItems());
  }

}

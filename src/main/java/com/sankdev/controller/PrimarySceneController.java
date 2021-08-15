package com.sankdev.controller;

import com.sankdev.App;
import com.sankdev.model.PortfolioModel;
import com.sankdev.model.PortfolioModelImpl;
import com.sankdev.portfolio.Certificate;
import com.sankdev.portfolio.Item;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * The Primary controller for the primary scene, i.e. the Application Main Window layout.
 */
public class PrimarySceneController {

  // Model
  private PortfolioModel portfolioModel = PortfolioModelImpl.getModel();

  // Primary scene control bindings
  @FXML
  private TableView<Item> tableView;
  @FXML
  private TableColumn<Item, String> idCol;
  @FXML
  private TableColumn<Item, String> nameCol;

  public PrimarySceneController() {
  }

  // Automatically called by FXML Loader
  public void initialize() {
    idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

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
    portfolioModel.savePortfolioItems(null);
  }

  @FXML
  private void loadPortfolioItems() throws IOException, ClassNotFoundException {
    portfolioModel.loadPortfolioItems(null);
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

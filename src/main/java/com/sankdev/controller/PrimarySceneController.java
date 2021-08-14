package com.sankdev.controller;

import com.sankdev.App;
import com.sankdev.model.ItemHolder;
import com.sankdev.model.Model;
import com.sankdev.model.PortfolioModel;
import com.sankdev.portfolio.Item;
import com.sankdev.service.PortfolioService;
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
  private Model theModel = PortfolioModel.getModel();
  private final ItemHolder itemHolder = ItemHolder.getInstance();
  private final PortfolioService portfolioService = new PortfolioService();

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

    tableView.setItems(theModel.getPortfolioItems());

  }

  @FXML
  private void onAdd() throws IOException {
    itemHolder.setItem(null);
    App.setRoot(App.EDIT_ITEM_VIEW);
  }

  @FXML
  private void writePortfolio() throws IOException {
    portfolioService.writePortfolio();
  }

  @FXML
  private void readPortfolio() throws IOException, ClassNotFoundException {
    portfolioService.readPortfolio();
    System.out.println("===>>> Test observable list");
    System.out.println(theModel.getPortfolioItems());
    System.out.println("===>>> Reading the portfolio");
    List<Item> items = new ArrayList<>(theModel.getPortfolioItems());
    for (Item tempItem :
        items) {
      System.out.println("Item read: " + tempItem.getId() + " " + tempItem.getName());
    }
    // TODO find out why this is necessary. Probably because PortfolioDAO INSTANCE is substituted
    //  when deserialized
    tableView.setItems(theModel.getPortfolioItems());
  }

  public void onEdit() throws IOException {
    if (tableView.getSelectionModel().getSelectedItem() != null) {
      Item selectedItem = tableView.getSelectionModel().getSelectedItem();
      itemHolder.setItem(selectedItem);
      App.setRoot(App.EDIT_ITEM_VIEW);
    }
  }

  public void onDelete() {
    if (tableView.getSelectionModel().getSelectedItem() != null) {
      Item selectedItem = tableView.getSelectionModel().getSelectedItem();
      portfolioService.deleteItem(selectedItem);
    }
  }
}

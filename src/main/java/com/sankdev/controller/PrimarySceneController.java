package com.sankdev.controller;

import com.sankdev.App;
import com.sankdev.portfolio.Item;
import com.sankdev.service.PortfolioService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * The Primary controller for the primary scene, i.e. the Application Main Window layout.
 */
public class PrimarySceneController {

  private final PortfolioService portfolioService = new PortfolioService();

  @FXML
  private TableView<Item> tableView;
  @FXML
  private TableColumn<Item, String> idCol;
  @FXML
  private TableColumn<Item, String> nameCol;

  public PrimarySceneController() {
  }

  public void initialize() {
    idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

    tableView.setItems(parseUserList());
  }

  /**
   * Returns the default demo portfolio item observable list
   * @return
   */
  private ObservableList<Item> parseUserList() {
    // parse and construct datamodel list by looping your ResultSet rs
    // and return the list
    return portfolioService.getItems();
  }

  @FXML
  private void switchToAddItem() throws IOException {
    App.setRoot("addItem");
  }

  @FXML
  private void writePortfolio() throws IOException {
    portfolioService.writePortfolio();
  }

  @FXML
  private void readPortfolio() throws IOException, ClassNotFoundException {
    portfolioService.readPortfolio();
    System.out.println("===>>> Test observable list");
    System.out.println(portfolioService.getItems());
    System.out.println("===>>> Reading the portfolio");
    List<Item> items = new ArrayList<>(parseUserList());
    for (Item tempItem :
        items) {
      System.out.println("Item read: " + tempItem.getId() + " " + tempItem.getName());
    }
    tableView.setItems(parseUserList());
  }
}

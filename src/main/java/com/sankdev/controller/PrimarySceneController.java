package com.sankdev.controller;

import com.sankdev.App;
import com.sankdev.portfolio.Item;
import com.sankdev.service.PortfolioService;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimarySceneController {

  @FXML
  private TableView<Item> tableView;
  @FXML
  private TableColumn<Item, String> idCol;
  @FXML
  private TableColumn<Item, String> nameCol;

  public PrimarySceneController() {  }

  public void initialize() {
    idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

    tableView.getItems().setAll(parseUserList());
  }

  private List<Item> parseUserList() {
    // parse and construct User datamodel list by looping your ResultSet rs
    // and return the list
    PortfolioService portfolioService = new PortfolioService();
    return portfolioService.getItems();
  }

  @FXML
  private void switchToAddItem() throws IOException {
    App.setRoot("addItem");
  }
}

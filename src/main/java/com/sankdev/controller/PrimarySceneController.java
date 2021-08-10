package com.sankdev.controller;

import com.sankdev.App;
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

    tableView.setItems(portfolioService.getPortfolioItems());
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
    System.out.println(portfolioService.getPortfolioItems());
    System.out.println("===>>> Reading the portfolio");
    List<Item> items = new ArrayList<>(portfolioService.getPortfolioItems());
    for (Item tempItem :
        items) {
      System.out.println("Item read: " + tempItem.getId() + " " + tempItem.getName());
    }
    // TODO find out why this is necessary. Probably because PortfolioDAO INSTANCE is substituted
    //  when deserialized
    tableView.setItems(portfolioService.getPortfolioItems());
  }
}

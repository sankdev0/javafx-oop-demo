package com.sankdev;

import com.sankdev.portfolio.Item;
import com.sankdev.portfolio.Portfolio;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

  @FXML
  private TableView<Item> tableView;
  @FXML
  private TableColumn<Item, String> idCol;
  @FXML
  private TableColumn<Item, String> nameCol;

  public PrimaryController() {
    System.out.println("===>>> Inside Primary Controller constructor");
  }

  public void initialize() {
    System.out.println("===>>> Inside Primary Controller initialize() method");
    idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

    tableView.getItems().setAll(parseUserList());
  }

  private List<Item> parseUserList() {
    // parse and construct User datamodel list by looping your ResultSet rs
    // and return the list
    Portfolio portfolio = new Portfolio();
    return portfolio.getItems();
  }

  @FXML
  private void switchToSecondary() throws IOException {
    App.setRoot("secondary");
  }
}

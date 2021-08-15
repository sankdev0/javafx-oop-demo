package com.sankdev.model;

import com.sankdev.portfolio.Item;
import com.sankdev.service.PortfolioService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This singleton is used to provide app data for controllers. It is eager-loaded and reused.
 * Accessed via getModel() method in an implementing class.
 */
public class PortfolioModelImpl implements PortfolioModel {

  private static final PortfolioModelImpl INSTANCE = new PortfolioModelImpl();

  private PortfolioService portfolioService;

  private Item portfolioItem;

  private PortfolioModelImpl() {
    portfolioService = new PortfolioService();
  }

  public static PortfolioModel getModel() {
    return INSTANCE;
  }

  @Override
  public ObservableList<Item> getPortfolioItems() {
    ObservableList<Item> observableItems = FXCollections.observableArrayList(
        this.portfolioService.getItems());
    return observableItems;
  }

  @Override
  public void setPortfolioItems(ObservableList<Item> portfolioItems) {
    this.portfolioService.setItems(new ArrayList<>(portfolioItems));
  }

  @Override
  public void addItem(Item item) {
    this.portfolioService.addItem(item);
  }

  @Override
  public void removeItem(Item item) {
    this.portfolioService.removeItem(item);
  }

  @Override
  public void setPortfolioItem(Item item) {
    this.portfolioItem = item;
  }

  @Override
  public Item getPortfolioItem() {
    return this.portfolioItem;
  }

  @Override
  public void savePortfolioItems(File file) throws IOException {
    this.portfolioService.saveItems(file);
  }

  @Override
  public void loadPortfolioItems(File file) throws ClassNotFoundException, IOException {
    this.portfolioService.loadItems(file);
  }

}

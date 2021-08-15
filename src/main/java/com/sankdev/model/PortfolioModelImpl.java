package com.sankdev.model;

import com.sankdev.portfolio.Item;
import com.sankdev.service.PortfolioService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This singleton is used to carry portfolio item data between controllers. It is eager-loaded and
 * reused. Accessed via getModel() method in an implementing class.
 */
public class PortfolioModelImpl implements PortfolioModel {

  private static final long serialVersionUID = 545476693155797115L;
  private static final PortfolioModelImpl INSTANCE = new PortfolioModelImpl();

  private PortfolioService portfolioService;

  private Item portfolioItem;
  private Class<? extends Item> itemType;

  private PortfolioModelImpl() {
    portfolioService = new PortfolioService();
  }

  public static PortfolioModel getModel() {
    return INSTANCE;
  }

  @Override
  public ObservableList<Item> getPortfolioItems() {
    ObservableList<Item> observableItems = FXCollections.observableArrayList(
        portfolioService.getItems());
    return observableItems;
  }

  @Override
  public void setPortfolioItems(ObservableList<Item> portfolioItems) {
    portfolioService.setItems(new ArrayList<>(portfolioItems));
  }

  @Override
  public void addItem(Item item) {
    portfolioService.addItem(item);
  }

  @Override
  public void removeItem(Item item) {
    portfolioService.removeItem(item);
  }

  @Override
  public void setPortfolioItem(Item item, Class<? extends Item> type) {
    if (item == null) {
      this.portfolioItem = null;
      this.itemType = null;
      return;
    }
    if (item.getClass().getName() == type.getName()) {
      this.portfolioItem = item;
      this.itemType = type;
    } else {
      throw new ClassCastException("Wrong item class provided!");
    }
  }

  @Override
  public Item getPortfolioItem(Class<? extends Item> type) {
    if (this.portfolioItem == null) {
      return null;
    }
    if (this.portfolioItem.getClass().getName() == type.getName()) {
      return this.portfolioItem;
    } else {
      throw new ClassCastException("Wrong item class provided!");
    }
  }

  @Override
  public void savePortfolioItems(File file) throws IOException {
    portfolioService.saveItems(file);
  }

  @Override
  public void loadPortfolioItems(File file) throws ClassNotFoundException, IOException {
    portfolioService.loadItems(file);
  }

}

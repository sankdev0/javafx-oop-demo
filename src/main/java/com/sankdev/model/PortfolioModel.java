package com.sankdev.model;

import com.sankdev.portfolio.Item;
import com.sankdev.service.PortfolioService;
import javafx.collections.ObservableList;

/**
 * This singleton is used to carry portfolio item data between controllers. It is eager-loaded and
 * reused. Accessed via getModel() method.
 */
public class PortfolioModel implements Model {

  private PortfolioService portfolioService;
  private Class<? extends Item> itemType;
  private Item item;
  private static final PortfolioModel INSTANCE = new PortfolioModel();

  private PortfolioModel() {
    portfolioService = new PortfolioService();
  }

  public static Model getModel() {
    return INSTANCE;
  }

  @Override
  public ObservableList<Item> getPortfolioItems() {
    return portfolioService.getPortfolioItems();
  }

  @Override
  public void setItem(Item item, Class<? extends Item> type) {
    if (item.getClass().getName() == type.getName()) {
      this.item = item;
      this.itemType = type;
    } else {
      throw new ClassCastException("Wrong item class provided!");
    }
  }

  @Override
  public Item getItem(Class<? extends Item> type) {
    if (this.item.getClass().getName() == type.getName()) {
      return this.item;
    }
    else {
      throw new ClassCastException("Wrong item class provided!");
    }
  }

  @Override
  public void addItem(Item item) {
    portfolioService.addPortfolioItem(item);
  }
}

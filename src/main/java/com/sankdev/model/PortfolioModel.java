package com.sankdev.model;

import com.sankdev.portfolio.Item;
import java.io.File;
import java.io.IOException;
import javafx.collections.ObservableList;

/**
 * This interface represents a model.
 */
public interface PortfolioModel {

  ObservableList<Item> getPortfolioItems();

  void setPortfolioItems(ObservableList<Item> portfolioItems);

  void addItem(Item item);

  public void removeItem(Item item);

  void setPortfolioItem(Item item);

  Item getPortfolioItem();

  void savePortfolioItems(File file) throws IOException;

  void loadPortfolioItems(File file) throws ClassNotFoundException, IOException;

}

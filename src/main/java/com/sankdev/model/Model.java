package com.sankdev.model;

import com.sankdev.portfolio.Item;
import javafx.collections.ObservableList;

/**
 * This interface represents a model.
 */
public interface Model {

  ObservableList<Item> getPortfolioItems();

  void addItem(Item item);


  // This is to store item type and catch Class Cast problems early on.
  void setItem(Item item, Class<? extends Item> type) throws ClassCastException;

  Item getItem(Class<? extends Item> type) throws ClassCastException;

}

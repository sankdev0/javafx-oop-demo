package com.sankdev.model;

import com.sankdev.portfolio.Item;

/**
 * This singleton is used to carry portfolio item data between controllers. It is eager-loaded and
 * reused.
 */
public class ItemHolder {

  private Item item;
  private static final ItemHolder INSTANCE = new ItemHolder();

  private ItemHolder() {
  }

  public static ItemHolder getInstance() {
    return INSTANCE;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }
}

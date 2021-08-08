package com.sankdev.portfolio;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {

  private List<Item> items;

  public Portfolio() {
    System.out.println("===>>> Inside Portfolio constructor");
    items = new ArrayList<>();
    items.add(new Certificate("Uni1", "My certificate"));
    items.add(new Diploma("Uni2", "Higher degree"));
    items.add(new Publication("1234", "Nature magazine article"));
    for (Item tempItem :
        items) {
      System.out.println(tempItem);
    }
  }

  public List<Item> getItems() {
    return items;
  }
}

package com.sankdev.dao;

import com.sankdev.portfolio.Certificate;
import com.sankdev.portfolio.Diploma;
import com.sankdev.portfolio.Item;
import com.sankdev.portfolio.Publication;
import java.util.ArrayList;
import java.util.List;

public class PortfolioDAO {

  private List<Item> items;

  public PortfolioDAO() {
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

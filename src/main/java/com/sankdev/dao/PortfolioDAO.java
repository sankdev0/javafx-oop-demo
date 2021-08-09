package com.sankdev.dao;

import com.sankdev.portfolio.Certificate;
import com.sankdev.portfolio.Diploma;
import com.sankdev.portfolio.Item;
import com.sankdev.portfolio.Publication;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * For the demo purposes it is a singleton now. Serves as an in-memory storage foe a list of
 * portfolio items. NOTE: Eager Loaded!
 */
public class PortfolioDAO implements Serializable {

  private static final long serialVersionUID = -760476693155737115L;

  private static final PortfolioDAO INSTANCE = new PortfolioDAO();

  private List<Item> items;

  // this is to ensure the Singleton instance is deserialized properly
  protected Object readResolve() throws ObjectStreamException {
    return INSTANCE;
  }

  private PortfolioDAO() {
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

  public static PortfolioDAO getInstance() {
    return INSTANCE;
  }

  public List<Item> getItems() {
    return items;
  }

  public void addItem(Item item) {
    if (items == null) {
      items = new ArrayList<> ();
    }

    items.add(item);
  }


}

package com.sankdev.dao;

import com.sankdev.portfolio.Certificate;
import com.sankdev.portfolio.Diploma;
import com.sankdev.portfolio.Diploma.Degree;
import com.sankdev.portfolio.Item;
import com.sankdev.portfolio.Publication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO container serves as an in-memory storage for a list of portfolio items.
 */
public class PortfolioDAO implements Serializable {

  private List<Item> items;

  public PortfolioDAO() {
    System.out.println("===>>> Inside PortfolioDAO constructor. Adding sample data.");
    items = new ArrayList<>();
    items.add(new Certificate("x26-1122", "Сертификат по курсу \" Бухгалтерия 1С\"",
        Year.of(2016), "Институт 1С"));
    items.add(new Diploma("ВОУ111222", "Диплом о высшем профессиональном образовании",
        Year.of(2014), "Оренбургский Государственный Университет", Degree.HIGHER));
    items.add(new Publication("ESPN8080009", "Использование 1С в бухгалтерском учете",
        Year.of(2018), "Эксперт", 2_000));
    for (Item tempItem :
        items) {
      System.out.println(tempItem);
    }
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public void addItem(Item item) {
    if (items == null) {
      items = new ArrayList<>();
    }
    items.add(item);
  }

  public void removeItem(Item item) {
    items.remove(item);
  }

  /**
   * Serialize the list of items into file
   */
  public void saveItems(File file) throws IOException {
    ObjectOutput oo = new ObjectOutputStream(new FileOutputStream(file));
    oo.writeObject(items);
    oo.flush();
    oo.close();
  }

  public void loadItems(File file) throws IOException, ClassNotFoundException {
    ObjectInput oi = new ObjectInputStream(new FileInputStream(file));
    List<Item> loadedItems = (List<Item>) oi.readObject();
    items = loadedItems;
    oi.close();
  }

}

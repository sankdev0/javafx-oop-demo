package com.sankdev.dao;

import com.sankdev.portfolio.Certificate;
import com.sankdev.portfolio.Diploma;
import com.sankdev.portfolio.Diploma.Degree;
import com.sankdev.portfolio.Item;
import com.sankdev.portfolio.Publication;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * DAO container serves as an in-memory storage for a list of portfolio items. For the demo
 * purposes it is a singleton now. NOTE: Eager Loaded!
 */
public class PortfolioDAO implements Serializable {

  private static final long serialVersionUID = -760476693155737115L;

  private static volatile PortfolioDAO INSTANCE = new PortfolioDAO();

  // Observable type to track changes in a corresponding GUI view
  private transient ObservableList<Item> observableItems;

  private PortfolioDAO() {
    System.out.println("===>>> Inside Portfolio constructor. Adding sample data.");
    observableItems = FXCollections.observableArrayList();
    observableItems.add(new Certificate("x26-1122", "Сертификат по курсу \" Бухгалтерия 1С\"",
        Year.of(2016), "Институт 1С"));
    observableItems.add(new Diploma("ВОУ111222", "Диплом о высшем профессиональном образовании",
        Year.of(2014), "Оренбургский Государственный Университет", Degree.HIGHER));
    observableItems.add(new Publication("ESPN8080009", "Использование 1С в бухгалтерском учете",
        Year.of(2018), "Эксперт", 2_000));
    for (Item tempItem :
        observableItems) {
      System.out.println(tempItem);
    }
  }

  public static PortfolioDAO getInstance() {
    return INSTANCE;
  }

  public ObservableList<Item> getObservableItems() {
    return observableItems;
  }

  public void setObservableItems(
      ObservableList<Item> observableItems) {
    this.observableItems = observableItems;
  }

  // for Custom Serialization
  private void writeObject(ObjectOutputStream oos)
      throws IOException {
    oos.defaultWriteObject();
    List<Item> items = new ArrayList<>(observableItems);
    oos.writeObject(items);
  }

  // for Custom Serialization
  private void readObject(ObjectInputStream ois)
      throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
    @SuppressWarnings("unchecked")
    List<Item> items = (List<Item>) ois.readObject();
    ObservableList<Item> observableList = FXCollections.observableList(items);
    this.setObservableItems(observableList);
  }


  /* this is to ensure the Singleton instance is deserialized properly
  protected Object readResolve() throws ObjectStreamException {
    return INSTANCE;
  }
   */


  public void addObservableItem(Item item) {
    if (observableItems == null) {
      observableItems = FXCollections.observableArrayList();
    }
    observableItems.add(item);
  }

  public void writePortfolio() throws IOException {
    String fileName = "C:\\repos\\javafx-oop-demo-files\\portfolio.ser";
    ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(fileName));
    objectOutput.writeObject(INSTANCE);
    objectOutput.flush();
    objectOutput.close();
  }

  public void readPortfolio() throws IOException, ClassNotFoundException {
    String fileName = "C:\\repos\\javafx-oop-demo-files\\portfolio.ser";
    ObjectInput objectInput = new ObjectInputStream(new FileInputStream(fileName));
    INSTANCE = (PortfolioDAO) objectInput.readObject();
    objectInput.close();
  }

  public void deleteItem(Item item) {
    observableItems.remove(item);
  }
}

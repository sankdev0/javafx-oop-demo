package com.sankdev.portfolio;

import java.io.Serializable;
import java.util.Objects;

public abstract class Item implements Serializable {

  private String id;

  private String name;

  public Item(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Item)) {
      return false;
    }
    Item item = (Item) o;
    return id.equals(item.id) && name.equals(item.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public String toString() {
    return "Item{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}

package com.sankdev.portfolio;

import java.io.Serializable;
import java.time.Year;
import java.util.Objects;
import java.util.UUID;

public abstract class Item implements Serializable {

  private String id;
  private String name;
  private Year year;
  private String description;

  public Item(String id, String name, Year year, String description) {
    if (id == "" ) {
      this.id = UUID.randomUUID().toString();
    } else {
      this.id = id;
    }
    this.name = name;
    this.year = year;
    this.description = description;
  }

  public Item(String id, String name, Year year) {
    if (id == "" ) {
      this.id = UUID.randomUUID().toString();
    } else {
      this.id = id;
    }
    this.name = name;
    this.year = year;
  }

  public Year getYear() {
    return year;
  }

  public void setYear(Year year) {
    this.year = year;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
    return id.equals(item.id) && name.equals(item.name) && year.equals(item.year)
        && Objects.equals(description, item.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, year, description);
  }
}

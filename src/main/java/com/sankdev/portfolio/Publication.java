package com.sankdev.portfolio;

import java.time.Year;

public class Publication extends Item {

  private String edition;

  private int printCount;

  public Publication(String id, String name, Year year, String description,
      String edition, int printCount) {
    super(id, name, year, description);
    this.edition = edition;
    this.printCount = printCount;
  }

  public Publication(String id, String name, Year year, String edition, int printCount) {
    super(id, name, year);
    this.edition = edition;
    this.printCount = printCount;
  }

  public String getEdition() {
    return edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
  }

  public int getPrintCount() {
    return printCount;
  }

  public void setPrintCount(int printCount) {
    this.printCount = printCount;
  }
}

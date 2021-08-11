package com.sankdev.portfolio;

import java.time.Year;

public class Certificate extends Achievement {

  public Certificate(String id, String name, Year year, String description,
      String certifyingBody) {
    super(id, name, year, description, certifyingBody);
  }

  public Certificate(String id, String name, Year year, String certifyingBody) {
    super(id, name, year, certifyingBody);
  }
}

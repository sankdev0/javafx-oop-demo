package com.sankdev.portfolio;

import java.time.Year;

public class Patent extends Achievement {

  private Year yearOfExpiration;

  public Patent(String id, String name, Year year, String certifyingBody,
      Year yearOfExpiration) {
    super(id, name, year, certifyingBody);
    this.yearOfExpiration = yearOfExpiration;
  }

  public Year getYearOfExpiration() {
    return yearOfExpiration;
  }

  public void setYearOfExpiration(Year yearOfExpiration) {
    this.yearOfExpiration = yearOfExpiration;
  }
}

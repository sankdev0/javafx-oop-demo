package com.sankdev.portfolio;

import java.time.Year;

public class Diploma extends Achievement {

  public enum Degree {
    HIGH,
    HIGHER,
    MASTERS,
    DOCTOR
  }

  private Degree degree;

  public Diploma(String id, String name, Year year, String description,
      String certifyingBody, Degree degree) {
    super(id, name, year, description, certifyingBody);
    this.degree = degree;
  }

  public Diploma(String id, String name, Year year, String certifyingBody,
      Degree degree) {
    super(id, name, year, certifyingBody);
    this.degree = degree;
  }

  public Degree getDegree() {
    return degree;
  }

  public void setDegree(Degree degree) {
    this.degree = degree;
  }
}

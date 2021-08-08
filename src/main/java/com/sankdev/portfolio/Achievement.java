package com.sankdev.portfolio;

public abstract class Achievement extends Item {

  private String issuer;

  public Achievement(String id, String name) {
    super(id, name);
  }

  public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }
}

package com.sankdev.portfolio;

import java.time.Year;

public abstract class Achievement extends Item {

  private String certifyingBody;

  public Achievement(String id, String name, Year year, String description,
      String certifyingBody) {
    super(id, name, year, description);
    this.certifyingBody = certifyingBody;
  }

  public Achievement(String id, String name, Year year, String certifyingBody) {
    super(id, name, year);
    this.certifyingBody = certifyingBody;
  }

  public String getCertifyingBody() {
    return certifyingBody;
  }

  public void setCertifyingBody(String certifyingBody) {
    this.certifyingBody = certifyingBody;
  }
}

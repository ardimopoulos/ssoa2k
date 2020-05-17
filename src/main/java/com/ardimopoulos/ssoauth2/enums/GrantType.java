package com.ardimopoulos.ssoauth2.enums;

import lombok.Getter;

public enum GrantType {

  PASSWORD("password"),
  REFRESH("refresh_token");

  @Getter
  private String value;

  GrantType(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

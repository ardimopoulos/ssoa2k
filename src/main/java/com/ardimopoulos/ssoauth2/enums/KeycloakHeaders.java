package com.ardimopoulos.ssoauth2.enums;

import lombok.Getter;

public enum KeycloakHeaders {

  GRANT_TYPE("grant_type"),
  USERNAME("username"),
  PASSWORD("password"),
  SCOPE("scope"),
  CLIENT_ID("client_id"),
  CLIENT_SECRET("client_secret"),
  REFRESH_TOKEN("refresh_token");

  @Getter
  private String value;

  KeycloakHeaders(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}

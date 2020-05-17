package com.ardimopoulos.ssoauth2.requests;

import lombok.Getter;

import static com.ardimopoulos.ssoauth2.enums.KeycloakHeaders.*;
import static com.ardimopoulos.ssoauth2.enums.KeycloakHeaders.CLIENT_SECRET;

@Getter
public abstract class KeycloakRequest {

  private String clientId;
  private String clientSecret;
  private String grantType;

  public KeycloakRequest(String grantType, String clientId, String clientSecret) {
    this.grantType = grantType;
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }

  public String toFormUrlEncoded() {
    return GRANT_TYPE.getValue() + "=" + getGrantType() + "&" +
        CLIENT_ID.getValue() + "=" + getClientId() + "&" +
        CLIENT_SECRET.getValue() + "=" + getClientSecret();
  }
}

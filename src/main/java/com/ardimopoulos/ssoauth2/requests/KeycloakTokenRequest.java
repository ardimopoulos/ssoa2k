package com.ardimopoulos.ssoauth2.requests;

import lombok.Getter;

import static com.ardimopoulos.ssoauth2.enums.GrantType.PASSWORD;
import static com.ardimopoulos.ssoauth2.enums.KeycloakHeaders.*;

@Getter
public class KeycloakTokenRequest extends KeycloakRequest {

  private String username;
  private String password;

  public KeycloakTokenRequest(String username, String password, String clientId,
      String clientSecret) {
    super(PASSWORD.getValue(), clientId, clientSecret);
    this.username = username;
    this.password = password;
  }

  @Override
  public String toFormUrlEncoded() {
    System.out.println(super.toFormUrlEncoded());
    return super.toFormUrlEncoded() + "&" + USERNAME.getValue() + "=" + username + "&" + PASSWORD
        .getValue() + "=" + password;
  }
}

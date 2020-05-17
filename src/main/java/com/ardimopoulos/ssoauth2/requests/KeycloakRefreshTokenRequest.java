package com.ardimopoulos.ssoauth2.requests;

import lombok.Getter;

import static com.ardimopoulos.ssoauth2.enums.GrantType.REFRESH;
import static com.ardimopoulos.ssoauth2.enums.KeycloakHeaders.*;

@Getter
public class KeycloakRefreshTokenRequest extends KeycloakRequest {

  private String refreshToken;

  public KeycloakRefreshTokenRequest(String refreshToken, String clientId, String clientSecret) {
    super(REFRESH.getValue(), clientId, clientSecret);
    this.refreshToken = refreshToken;
  }

  @Override
  public String toFormUrlEncoded() {
    return super.toFormUrlEncoded() + "&" + REFRESH_TOKEN.getValue() + "=" + refreshToken;
  }
}

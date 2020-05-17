package com.ardimopoulos.ssoauth2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponseDto {

  @JsonProperty("access_token")
  private String accessToken;

  @JsonProperty("expires_in")
  private int expiresIn;

  @JsonProperty("refresh_expires_in")
  private int refreshExpiresIn;

  @JsonProperty("refresh_token")
  private String refreshToken;

  @JsonProperty("token_type")
  private String tokenType;

  @JsonProperty("session_state")
  private String sessionState;
}

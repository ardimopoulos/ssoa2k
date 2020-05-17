package com.ardimopoulos.ssoauth2.services;

import com.ardimopoulos.ssoauth2.dto.LoginResponseDto;
import com.ardimopoulos.ssoauth2.requests.KeycloakRefreshTokenRequest;
import com.ardimopoulos.ssoauth2.requests.KeycloakTokenRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  private final WebClient webClient;

  @Value("${auth2.keycloak.client-id}")
  private String clientId;

  @Value("${auth2.keycloak.client-secret}")
  private String clientSecret;

  public AuthenticationServiceImpl(@Value("${auth2.keycloak.token-uri}") String tokenUri) {
    webClient = WebClient.builder()
        .baseUrl(tokenUri)
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
        .build();
  }

  @Override
  public LoginResponseDto login(String username, String password) {
    return webClient.post()
        .bodyValue(
            new KeycloakTokenRequest(username, password, clientId, clientSecret).toFormUrlEncoded())
        .retrieve()
        .bodyToMono(LoginResponseDto.class)
        .block();
  }

  @Override
  public LoginResponseDto refresh(String refreshToken) {
    return webClient.post()
        .bodyValue(new KeycloakRefreshTokenRequest(refreshToken, clientId, clientSecret)
            .toFormUrlEncoded())
        .retrieve()
        .bodyToMono(LoginResponseDto.class)
        .block();
  }
}

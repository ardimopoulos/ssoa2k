package com.ardimopoulos.ssoauth2.services;

import com.ardimopoulos.ssoauth2.dto.LoginResponseDto;
import com.ardimopoulos.ssoauth2.requests.KeycloakRefreshTokenRequest;
import com.ardimopoulos.ssoauth2.requests.KeycloakTokenRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import static com.ardimopoulos.ssoauth2.constants.Constants.REALM_TOKEN_URI;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final WebClient webClient;

    public AuthenticationServiceImpl() {
        webClient = WebClient.builder()
                .baseUrl(REALM_TOKEN_URI)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .build();
    }

    @Override
    public LoginResponseDto login(String username, String password) {
        return webClient.post()
                .bodyValue(new KeycloakTokenRequest(username, password).toFormUrlEncoded())
                .retrieve()
                .bodyToMono(LoginResponseDto.class)
                .block();
    }

    @Override
    public LoginResponseDto refresh(String refreshToken) {
        return webClient.post()
                .bodyValue(new KeycloakRefreshTokenRequest(refreshToken).toFormUrlEncoded())
                .retrieve()
                .bodyToMono(LoginResponseDto.class)
                .block();
    }
}

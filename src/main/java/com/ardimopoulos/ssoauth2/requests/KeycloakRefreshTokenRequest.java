package com.ardimopoulos.ssoauth2.requests;

import lombok.Getter;

import static com.ardimopoulos.ssoauth2.enums.GrantType.REFRESH;
import static com.ardimopoulos.ssoauth2.enums.KeycloakHeaders.*;

@Getter
public class KeycloakRefreshTokenRequest extends KeycloakRequest{

    private String refreshToken;

    public KeycloakRefreshTokenRequest(String refreshToken) {
        super(REFRESH.getValue());
        this.refreshToken = refreshToken;
    }

    @Override
    public String toFormUrlEncoded() {
        return super.toFormUrlEncoded() + "&" + REFRESH_TOKEN.getValue() + "=" + refreshToken;
    }
}

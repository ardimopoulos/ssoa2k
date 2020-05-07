package com.ardimopoulos.ssoauth2.requests;

import com.ardimopoulos.ssoauth2.constants.Constants;
import lombok.Getter;

import static com.ardimopoulos.ssoauth2.enums.KeycloakHeaders.*;
import static com.ardimopoulos.ssoauth2.enums.KeycloakHeaders.CLIENT_SECRET;

@Getter
public abstract class KeycloakRequest {

    private String clientId;
    private String clientSecret;
    private String grantType;

    public KeycloakRequest(String grantType) {
        this.grantType = grantType;
        clientId = Constants.CLIENT_ID_VALUE;
        clientSecret = Constants.CLIENT_SECRET_VALUE;
    }

    public String toFormUrlEncoded() {
        return GRANT_TYPE.getValue() + "=" + getGrantType() + "&" +
                CLIENT_ID.getValue() + "=" + getClientId() + "&" +
                CLIENT_SECRET.getValue() + "=" + getClientSecret();
    }
}

package com.ardimopoulos.ssoauth2.constants;

public final class Constants {
    public static final String REALM_TOKEN_URI = ""; // add keycloak realm token uri
    public static final String CLIENT_ID_VALUE = ""; // add keycloak client id
    public static final String CLIENT_SECRET_VALUE = ""; // add keycloak client secret

    private Constants() {
        throw new UnsupportedOperationException("Cannot instantiate constant class:" + Constants.class.getSimpleName());
    }
}

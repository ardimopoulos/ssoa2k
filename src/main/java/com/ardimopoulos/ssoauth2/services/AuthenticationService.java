package com.ardimopoulos.ssoauth2.services;

import com.ardimopoulos.ssoauth2.dto.LoginResponseDto;

public interface AuthenticationService {

    LoginResponseDto login(String username, String password);
    LoginResponseDto refresh(String refreshToken);
}

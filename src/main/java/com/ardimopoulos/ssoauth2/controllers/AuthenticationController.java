package com.ardimopoulos.ssoauth2.controllers;

import com.ardimopoulos.ssoauth2.dto.LoginResponseDto;
import com.ardimopoulos.ssoauth2.services.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotBlank;

@Validated
@RestController
@RequestMapping("/api")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(value = "/oauth2/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<LoginResponseDto> login(@RequestParam("username") @NotBlank String username,
                                                  @RequestParam("password") @NotBlank String password) {

        return new ResponseEntity<>(authenticationService.login(username, password), HttpStatus.OK);
    }

    @PostMapping(value = "/oauth2/token/refresh", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<LoginResponseDto> refresh(@RequestParam("refresh_token") @NotBlank String refreshToken) {
        return new ResponseEntity<>(authenticationService.refresh(refreshToken), HttpStatus.OK);
    }
}

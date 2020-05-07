package com.ardimopoulos.ssoauth2.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;;

@RestController
@RequestMapping("/api")
public class SampleController {

    @GetMapping("/hello")
    public String sayHello(@AuthenticationPrincipal Principal auth) {
        return "Hello " + auth.toString();
    }
}

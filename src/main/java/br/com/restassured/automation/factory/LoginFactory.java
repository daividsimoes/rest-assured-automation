package br.com.restassured.automation.factory;

import br.com.restassured.automation.model.request.login.LoginRequest;

public class LoginFactory {

    public LoginRequest buildLoginRequest(String email, String password) {

        return LoginRequest.builder()
                .email(email)
                .password(password)
                .build();
    }

    public LoginRequest buildLoginRequestWithoutUserAccount() {

        return LoginRequest.builder().build();
    }
}

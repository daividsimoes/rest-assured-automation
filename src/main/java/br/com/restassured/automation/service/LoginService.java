package br.com.restassured.automation.service;

import br.com.restassured.automation.model.request.login.LoginRequest;
import br.com.restassured.automation.model.response.login.LoginResponse;

public class LoginService extends AbstractService {

    private final String LOGIN = "/login";

    public LoginResponse login(LoginRequest loginRequest) {

        return requestUtil.post(loginRequest, LoginResponse.class, LOGIN);
    }
}

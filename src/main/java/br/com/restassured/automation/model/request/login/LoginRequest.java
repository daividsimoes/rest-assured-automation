package br.com.restassured.automation.model.request.login;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginRequest {

    private String email;

    private String password;
}

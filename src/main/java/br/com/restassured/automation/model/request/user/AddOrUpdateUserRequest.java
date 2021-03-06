package br.com.restassured.automation.model.request.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddOrUpdateUserRequest {

    private String nome;

    private String email;

    private String password;

    private String administrador;
}

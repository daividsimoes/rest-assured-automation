package br.com.restassured.automation.model.request.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class AddUserRequest {

    private String nome;

    private String email;

    private String password;

    private String administrador;
}

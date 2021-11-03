package br.com.restassured.automation.model.response.user;

import br.com.restassured.automation.model.response.ResponseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserResponse extends ResponseObject implements Serializable {

    private String nome;

    private String email;

    private String password;

    private String administrador;

    @JsonProperty("_id")
    private String id;
}

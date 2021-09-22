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

    @JsonProperty("nome")
    public void setNome(String nome) {

        this.nome = nome;
        super.setNameMessageError(nome);
    }

    @JsonProperty("email")
    public void setEmail(String email) {

        this.email = email;
        super.setEmailMessageError(email);
    }

    @JsonProperty("password")
    public void setPassword(String password) {

        this.password = password;
        super.setPasswordMessageError(password);
    }

    @JsonProperty("administrador")
    public void setAdministrador(String administrador) {

        this.administrador = administrador;
        super.setAdminMessageError(administrador);
    }
}

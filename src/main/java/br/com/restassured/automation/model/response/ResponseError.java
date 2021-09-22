package br.com.restassured.automation.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseError implements Serializable {

    @JsonProperty("administrador")
    private String adminMessageError;

    @JsonProperty("email")
    private String emailMessageError;

    @JsonProperty("nome")
    private String nameMessageError;

    @JsonProperty("password")
    private String passwordMessageError;

    @JsonProperty("message")
    private String messageError;
}

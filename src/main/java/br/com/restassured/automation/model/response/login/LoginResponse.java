package br.com.restassured.automation.model.response.login;

import br.com.restassured.automation.model.response.ResponseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LoginResponse extends ResponseObject implements Serializable {

    private String message;

    private String authorization;

    @JsonProperty("message")
    public void setMessage(String message) {

        this.message = message;
        super.setMessageError(message);
    }
}

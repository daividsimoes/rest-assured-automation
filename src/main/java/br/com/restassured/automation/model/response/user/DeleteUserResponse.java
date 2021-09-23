package br.com.restassured.automation.model.response.user;

import br.com.restassured.automation.model.response.ResponseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class DeleteUserResponse extends ResponseObject implements Serializable {

    private String message;

    @JsonProperty("message")
    public void setMessage(String message) {

        this.message = message;
        super.setMessageError(message);
    }
}

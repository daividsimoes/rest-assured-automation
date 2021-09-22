package br.com.restassured.automation.model.response.user;

import br.com.restassured.automation.model.response.ResponseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AddOrUpdateUserResponse extends ResponseObject implements Serializable {

    private String message;

    @JsonProperty("_id")
    private String id;

    @JsonProperty("message")
    public void setMessage(String message) {

        this.message = message;
        super.setMessageError(message);
    }
}

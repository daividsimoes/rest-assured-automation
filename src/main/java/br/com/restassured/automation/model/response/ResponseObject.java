package br.com.restassured.automation.model.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseObject extends ResponseError implements Serializable {

    private int statusCode;
}

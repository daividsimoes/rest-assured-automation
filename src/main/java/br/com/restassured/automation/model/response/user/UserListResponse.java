package br.com.restassured.automation.model.response.user;

import br.com.restassured.automation.model.response.ResponseObject;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UserListResponse extends ResponseObject implements Serializable {

    private int quantidade;

    private List<UserResponse> usuarios;
}

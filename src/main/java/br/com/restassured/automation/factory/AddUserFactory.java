package br.com.restassured.automation.factory;

import br.com.restassured.automation.model.request.user.AddUserRequest;
import br.com.restassured.automation.util.FakerUtil;

public class AddUserFactory {

    FakerUtil fakerUtil = new FakerUtil();

    public AddUserRequest buildAddUserRequest() {

        return AddUserRequest.builder()
                .nome(fakerUtil.generateRandomName())
                .email(fakerUtil.generateRandomEmail())
                .password(fakerUtil.generateRandomPassword())
                .administrador("false")
                .build();
    }

    public AddUserRequest buildAdminAddUserRequest() {

        return AddUserRequest.builder()
                .nome(fakerUtil.generateRandomName())
                .email(fakerUtil.generateRandomEmail())
                .password(fakerUtil.generateRandomPassword())
                .administrador("true")
                .build();
    }

    public AddUserRequest buildAddUserRequestWithEmailt(String email) {

        return AddUserRequest.builder()
                .nome(fakerUtil.generateRandomName())
                .email(email)
                .password(fakerUtil.generateRandomPassword())
                .administrador("false")
                .build();
    }

    public AddUserRequest buildEmptyUserRequest() {

        return AddUserRequest.builder()
                .nome("")
                .email("")
                .password("")
                .administrador("")
                .build();
    }

    public AddUserRequest buildBlankUserRequest() {

        return AddUserRequest.builder().build();
    }
}

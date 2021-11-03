package br.com.restassured.automation.factory;

import br.com.restassured.automation.model.request.user.AddOrUpdateUserRequest;
import br.com.restassured.automation.util.FakerUtil;

public class AddOrUpdateUserFactory {

    FakerUtil fakerUtil = new FakerUtil();

    public AddOrUpdateUserRequest buildAddUserRequest() {

        return AddOrUpdateUserRequest.builder()
                .nome(fakerUtil.generateRandomName())
                .email(fakerUtil.generateRandomEmail())
                .password(fakerUtil.generateRandomPassword())
                .administrador("false")
                .build();
    }

    public AddOrUpdateUserRequest buildAdminAddUserRequest() {

        return AddOrUpdateUserRequest.builder()
                .nome(fakerUtil.generateRandomName())
                .email(fakerUtil.generateRandomEmail())
                .password(fakerUtil.generateRandomPassword())
                .administrador("true")
                .build();
    }

    public AddOrUpdateUserRequest buildAddUserRequestWithEmail(String email) {

        return AddOrUpdateUserRequest.builder()
                .nome(fakerUtil.generateRandomName())
                .email(email)
                .password(fakerUtil.generateRandomPassword())
                .administrador("false")
                .build();
    }

    public AddOrUpdateUserRequest buildEmptyUserRequest() {

        return AddOrUpdateUserRequest.builder()
                .nome("")
                .email("")
                .password("")
                .administrador("")
                .build();
    }

    public AddOrUpdateUserRequest buildBlankUserRequest() {

        return AddOrUpdateUserRequest.builder().build();
    }
}

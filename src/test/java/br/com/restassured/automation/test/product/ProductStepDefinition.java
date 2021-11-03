package br.com.restassured.automation.test.product;

import br.com.restassured.automation.factory.AddOrUpdateProductFactory;
import br.com.restassured.automation.factory.AddOrUpdateUserFactory;
import br.com.restassured.automation.factory.LoginFactory;
import br.com.restassured.automation.model.request.login.LoginRequest;
import br.com.restassured.automation.model.request.product.AddOrUpdateProductRequest;
import br.com.restassured.automation.model.request.user.AddOrUpdateUserRequest;
import br.com.restassured.automation.model.response.login.LoginResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductStepDefinition {

    private AddOrUpdateUserFactory addOrUpdateUserFactory;

    private LoginFactory loginFactory;

    private AddOrUpdateUserRequest addOrUpdateUserRequest;

    private LoginRequest loginRequest;

    private LoginResponse loginResponse;

    @Given("I have one admin user logged")
    public void i_have_one_admin_user_logged() {

        addOrUpdateUserRequest = addOrUpdateUserFactory.buildAdminAddUserRequest();
        loginRequest = loginFactory.buildLoginRequest(addOrUpdateUserRequest.getEmail(),
                addOrUpdateUserRequest.getPassword());
    }

    @Given("I build one product")
    public void i_build_one_product() {

    }

    @When("I call add product API")
    public void i_call_add_product_API() {

    }

    @Then("should add product successfully")
    public void should_add_product_successfully() {

    }

    @Then("status code should be {int} for add user response")
    public void status_code_should_be_for_add_user_response(Integer code) {

    }
}

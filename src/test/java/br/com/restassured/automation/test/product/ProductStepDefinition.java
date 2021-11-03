package br.com.restassured.automation.test.product;

import br.com.restassured.automation.enums.Message;
import br.com.restassured.automation.factory.AddOrUpdateProductFactory;
import br.com.restassured.automation.factory.AddOrUpdateUserFactory;
import br.com.restassured.automation.factory.LoginFactory;
import br.com.restassured.automation.model.request.login.LoginRequest;
import br.com.restassured.automation.model.request.product.AddOrUpdateProductRequest;
import br.com.restassured.automation.model.request.user.AddOrUpdateUserRequest;
import br.com.restassured.automation.model.response.login.LoginResponse;
import br.com.restassured.automation.model.response.product.AddOrUpdateProductResponse;
import br.com.restassured.automation.model.response.user.AddOrUpdateUserResponse;
import br.com.restassured.automation.service.LoginService;
import br.com.restassured.automation.service.ProductService;
import br.com.restassured.automation.service.UserService;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProductStepDefinition {

    private LoginService loginService;

    private UserService userService;

    private ProductService productService;

    private AddOrUpdateUserFactory addOrUpdateUserFactory;

    private LoginFactory loginFactory;

    private AddOrUpdateProductFactory addOrUpdateProductFactory;

    private AddOrUpdateUserRequest addOrUpdateUserRequest;

    private LoginRequest loginRequest;

    private AddOrUpdateProductRequest addOrUpdateProductRequest;

    private AddOrUpdateProductResponse addOrUpdateProductResponse;

    private LoginResponse loginResponse;

    @Before("@init")
    public void before() {

        addOrUpdateUserFactory = new AddOrUpdateUserFactory();
        loginFactory = new LoginFactory();
        addOrUpdateProductFactory = new AddOrUpdateProductFactory();
        loginService = new LoginService();
        userService = new UserService();
        productService = new ProductService();
    }

    @Given("I have one admin user logged")
    public void i_have_one_admin_user_logged() {

        addOrUpdateUserRequest = addOrUpdateUserFactory.buildAdminAddUserRequest();
        userService.addUser(addOrUpdateUserRequest);

        loginRequest = loginFactory.buildLoginRequest(addOrUpdateUserRequest.getEmail(),
                addOrUpdateUserRequest.getPassword());

        loginResponse = loginService.login(loginRequest);
    }

    @Given("I build one product")
    public void i_build_one_product() {

        addOrUpdateProductRequest = addOrUpdateProductFactory.buildProduct();
    }

    @When("I call add product API")
    public void i_call_add_product_API() {

        addOrUpdateProductResponse = productService.addProduct(addOrUpdateProductRequest,
                loginResponse.getAuthorization());
    }

    @Then("should add product successfully")
    public void should_add_product_successfully() {

        assertNotNull(addOrUpdateProductResponse.getId());
        assertEquals(Message.REGISTRATION_PERFORMED_SUCCESSFULLY.getMessage(), addOrUpdateProductResponse.getMessage());

    }

    @Then("status code should be {int} for add product response")
    public void status_code_should_be_for_add_product_response(int code) {

        assertEquals(code, addOrUpdateProductResponse.getStatusCode());
    }
}

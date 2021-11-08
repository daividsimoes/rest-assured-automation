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
        login(addOrUpdateUserRequest);
    }

    @Given("I have one non admin user logged")
    public void i_have_one_non_admin_user_logged() {

        addOrUpdateUserRequest = addOrUpdateUserFactory.buildAddUserRequest();
        login(addOrUpdateUserRequest);
    }

    @Given("I build one product")
    public void i_build_one_product() {

        addOrUpdateProductRequest = addOrUpdateProductFactory.buildProduct();
    }

    @Given("I add one product")
    public void i_add_one_product() {

        addOrUpdateProductRequest = addOrUpdateProductFactory.buildProduct();
        addOrUpdateProductResponse = productService.addProduct(addOrUpdateProductRequest,
                loginResponse.getAuthorization());
    }

    @When("I call add product API")
    public void i_call_add_product_API() {

        addOrUpdateProductResponse = productService.addProduct(addOrUpdateProductRequest,
                loginResponse.getAuthorization());
    }

    @When("I call add product API with invalid token")
    public void i_call_add_product_API_with_invalid_token() {

        addOrUpdateProductResponse = productService.addProduct(addOrUpdateProductRequest,
                "Bearer invalid token");
    }

    @Then("should add product successfully")
    public void should_add_product_successfully() {

        assertNotNull(addOrUpdateProductResponse.getId());
        assertEquals(Message.REGISTRATION_PERFORMED_SUCCESSFULLY.getMessage(),
                addOrUpdateProductResponse.getMessage());

    }

    @Then("status code should be {int} for add product response")
    public void status_code_should_be_for_add_product_response(int code) {

        assertEquals(code, addOrUpdateProductResponse.getStatusCode());
    }

    @Then("should return add product email already exist message error")
    public void should_return_add_user_email_already_exist_message_error() {

        assertEquals(Message.PRODUCT_NAME_ALREADY_EXIST.getMessage(),
                addOrUpdateProductResponse.getErrors().getMessageError());
    }

    @Then("should return invalid token message error")
    public void should_return_invalid_token_message_error() {

        assertEquals(Message.INVALID_TOKEN.getMessage(),
                addOrUpdateProductResponse.getErrors().getMessageError());
    }

    @Then("should return non admin message error")
    public void should_return_non_admin_message_error() {

        assertEquals(Message.ADMIN_ROUTE.getMessage(),
                addOrUpdateProductResponse.getErrors().getMessageError());
    }

    private void login(AddOrUpdateUserRequest addOrUpdateUserRequest) {

        userService.addUser(addOrUpdateUserRequest);
        loginRequest = loginFactory.buildLoginRequest(addOrUpdateUserRequest.getEmail(),
                addOrUpdateUserRequest.getPassword());

        loginResponse = loginService.login(loginRequest);
    }
}

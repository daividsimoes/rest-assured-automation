package br.com.restassured.automation.test.login;

import br.com.restassured.automation.enums.Message;
import br.com.restassured.automation.factory.AddOrUpdateUserFactory;
import br.com.restassured.automation.factory.LoginFactory;
import br.com.restassured.automation.model.request.login.LoginRequest;
import br.com.restassured.automation.model.request.user.AddOrUpdateUserRequest;
import br.com.restassured.automation.model.response.login.LoginResponse;
import br.com.restassured.automation.service.LoginService;
import br.com.restassured.automation.service.UserService;
import br.com.restassured.automation.util.FakerUtil;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class LoginStepDefinition {

    private LoginService loginService;

    private UserService userService;

    private AddOrUpdateUserFactory addOrUpdateUserFactory;

    private LoginFactory loginFactory;

    private AddOrUpdateUserRequest addOrUpdateUserRequest;

    private LoginRequest loginRequest;

    private LoginResponse loginResponse;

    private static boolean dunit = false;

    @Before("@init")
    public void before() {

        userService = new UserService();
        loginService = new LoginService();
        addOrUpdateUserFactory = new AddOrUpdateUserFactory();
        loginFactory = new LoginFactory();
    }

    @Given("I have one user account")
    public void i_have_one_user_account() {

        addOrUpdateUserRequest = addOrUpdateUserFactory.buildAddUserRequest();
        userService.addUser(addOrUpdateUserRequest);
    }

    @Given("I have one Admin user account")
    public void i_have_one_Admin_user_account() {

        addOrUpdateUserRequest = addOrUpdateUserFactory.buildAdminAddUserRequest();
        userService.addUser(addOrUpdateUserRequest);
    }

    @Given("I perform the login with non existing user account")
    public void i_perform_the_login_with_non_existing_user_account() {

        FakerUtil fakerUtil = new FakerUtil();

        loginRequest = loginFactory.buildLoginRequest(fakerUtil.generateRandomEmail(),
                fakerUtil.generateRandomPassword());

        loginResponse = loginService.login(loginRequest);
    }

    @Given("I perform the login without user account")
    public void i_perform_the_login_without_user_account() {

        loginRequest = loginFactory.buildLoginRequestWithoutUserAccount();
        loginResponse = loginService.login(loginRequest);
    }

    @Given("I perform the login with empty user account")
    public void i_perform_the_login_with_empty_user_account() {

        loginRequest = loginFactory.buildLoginRequestWithEmptyUserAccount();
        loginResponse = loginService.login(loginRequest);
    }

    @When("I perform the login")
    public void i_perform_the_login() {

        loginRequest = loginFactory.buildLoginRequest(addOrUpdateUserRequest.getEmail(),
                addOrUpdateUserRequest.getPassword());

        loginResponse = loginService.login(loginRequest);
    }

    @When("I perform the login with invalid password")
    public void i_perform_the_login_with_invalid_password() {

        loginRequest = loginFactory.buildLoginRequest(addOrUpdateUserRequest.getEmail(),
                new FakerUtil().generateRandomPassword());

        loginResponse = loginService.login(loginRequest);
    }

    @Then("should login successfully")
    public void should_login_successfully() {


        assertEquals(Message.LOGIN_PERFORMED_SUCCESSFULLY.getMessage(), loginResponse.getMessage());
        assertNotNull(loginResponse.getAuthorization());
    }

    @Then("status code should be {int} for login response")
    public void status_code_should_be_for_login_response(int code) {

        assertEquals(code, loginResponse.getStatusCode());
    }

    @Then("should return invalid email or password login error")
    public void should_return_invalid_email_or_password_login_error() {

        assertEquals(Message.INVALID_EMAIL_OR_PASSWORD.getMessage(), loginResponse.getMessage());
    }

    @Then("should return login required fields message error")
    public void should_return_login_required_fields_message_error() {

        assertEquals(Message.REQUIRED_EMAIL.getMessage(), loginResponse.getErros().getEmailMessageError());
        assertEquals(Message.REQUIRED_PASSWORD.getMessage(), loginResponse.getErros().getPasswordMessageError());
    }

    @Then("should return login user empty fields message error")
    public void should_return_login_user_empty_fields_message_error() {

        assertEquals(Message.EMPTY_EMAIL.getMessage(), loginResponse.getErros().getEmailMessageError());
        assertEquals(Message.EMPTY_PASSWORD.getMessage(), loginResponse.getErros().getPasswordMessageError());
    }
}

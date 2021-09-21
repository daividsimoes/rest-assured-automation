package br.com.restassured.automation.test.user;

import br.com.restassured.automation.enums.Message;
import br.com.restassured.automation.factory.AddUserFactory;
import br.com.restassured.automation.model.request.user.AddUserRequest;
import br.com.restassured.automation.model.response.user.AddUserResponse;
import br.com.restassured.automation.model.response.user.UserListResponse;
import br.com.restassured.automation.request.RequestUtil;
import br.com.restassured.automation.util.FakerUtil;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class UserStepDefinition {

    private RequestUtil requestUtil;

    private AddUserRequest addUserRequest;

    private AddUserResponse addUserResponse;

    private UserListResponse userListResponse;

    private final String USER = "/usuarios";

    private final String USER_QUERY_ID = "/usuarios?_id={0}";

    private final String USER_QUERY_ADMIN = "/usuarios?administrador={0}";

    private final String USER_QUERY_NAME = "/usuarios?nome={0}";

    private final String USER_QUERY_EMAIL = "/usuarios?email={0}";

    private final String USER_QUERY_PASSWORD = "/usuarios?password={0}";

    private final String USER_ALL_QUERY = "/usuarios?_id={0}&nome={1}&email={2}&password={3}&administrador={4}";

    @Before("@init")
    public void before() {

        requestUtil = new RequestUtil();
    }

    @Given("I have one user account")
    public void i_have_one_user_account() {

        AddUserFactory addUserFactory = new AddUserFactory();
        addUserRequest = addUserFactory.buildAddUserRequest();

        addUserResponse = requestUtil.post(
                addUserRequest,
                AddUserResponse.class,
                USER
        );
    }

    @Given("I have one Admin user account")
    public void i_have_one_Admin_user_account() {

        AddUserFactory addUserFactory = new AddUserFactory();
        addUserRequest = addUserFactory.buildAdminAddUserRequest();

        addUserResponse = requestUtil.post(
                addUserRequest,
                AddUserResponse.class,
                USER
        );
    }

    @Given("I call find user API using invalid id as query id")
    public void i_call_find_user_API_using_invalid_id_as_query_id() {

        userListResponse = requestUtil.get(
                UserListResponse.class,
                USER_QUERY_ID,
                new FakerUtil().generateRandomUuid()
        );
    }

    @Given("I call find user API using invalid name as query name")
    public void i_call_find_user_API_using_invalid_name_as_query_name() {

        userListResponse = requestUtil.get(
                UserListResponse.class,
                USER_QUERY_NAME,
                new FakerUtil().generateRandomName()
        );
    }

    @Given("I call find user API using non existing email as query email")
    public void i_call_find_user_API_using_non_existing_email_as_query_email() {

        userListResponse = requestUtil.get(
                UserListResponse.class,
                USER_QUERY_EMAIL,
                new FakerUtil().generateRandomEmail()
        );
    }

    @Given("I call find user API using invalid email as query email")
    public void i_call_find_user_API_using_invalid_email_as_query_email() {

        userListResponse = requestUtil.get(
                UserListResponse.class,
                USER_QUERY_EMAIL,
                new FakerUtil().generateInvalidEmail()
        );
    }

    @Given("I call find user API using non existing password as query password")
    public void i_call_find_user_API_using_non_existing_password_as_query_password() {

        userListResponse = requestUtil.get(
                UserListResponse.class,
                USER_QUERY_PASSWORD,
                new FakerUtil().generateRandomPassword()
        );
    }

    @Given("I call find user API using invalid id with all queries")
    public void i_call_find_user_API_using_invalid_id_with_all_queries() {

        FakerUtil fakerUtil = new FakerUtil();

        userListResponse = requestUtil.get(
                UserListResponse.class,
                USER_ALL_QUERY,
                fakerUtil.generateRandomUuid(),
                fakerUtil.generateRandomName(),
                fakerUtil.generateRandomEmail(),
                fakerUtil.generateRandomPassword(),
                "false"
        );
    }

    @When("I call find user API")
    public void i_call_find_user_API() {

        userListResponse = requestUtil.get(
                UserListResponse.class,
                USER
        );
    }

    @When("I call find user API using query id")
    public void i_call_find_user_API_using_query_id() {

        userListResponse = requestUtil.get(
                UserListResponse.class,
                USER_QUERY_ID,
                addUserResponse.getId()
        );
    }

    @When("I call find user API using query admin {string}")
    public void i_call_find_user_API_using_query_admin(String admin) {

        userListResponse = requestUtil.get(
                UserListResponse.class,
                USER_QUERY_ADMIN,
                admin
        );
    }

    @When("I call find user API using query name")
    public void i_call_find_user_API_using_query_name() {

        userListResponse = requestUtil.get(
                UserListResponse.class,
                USER_QUERY_NAME,
                addUserRequest.getNome()
        );
    }

    @When("I call find user API using query email")
    public void i_call_find_user_API_using_query_email() {

        userListResponse = requestUtil.get(
                UserListResponse.class,
                USER_QUERY_EMAIL,
                addUserRequest.getEmail()
        );
    }

    @When("I call find user API using query password")
    public void i_call_find_user_API_using_query_password() {

        userListResponse = requestUtil.get(
                UserListResponse.class,
                USER_QUERY_PASSWORD,
                addUserRequest.getPassword()
        );
    }

    @When("I call find user API using all queries")
    public void i_call_find_user_API_using_all_queries() {

        userListResponse = requestUtil.get(
                UserListResponse.class,
                USER_ALL_QUERY,
                addUserResponse.getId(),
                addUserRequest.getNome(),
                addUserRequest.getEmail(),
                addUserRequest.getPassword(),
                addUserRequest.getAdministrador()
        );
    }

    @Then("status code should be {int}")
    public void status_code_should_be(int code) {

        assertEquals(code, userListResponse.getStatusCode());
    }

    @Then("should return user list")
    public void should_return_user_list() {

        assertEquals(userListResponse.getQuantidade(), userListResponse.getUsuarios().size());
        userListResponse.getUsuarios().forEach(user -> {
            assertNotNull(user.getId());
            assertNotNull(user.getNome());
            assertNotNull(user.getEmail());
            assertNotNull(user.getPassword());
            assertNotNull(user.getAdministrador());
        });
    }

    @Then("should return user")
    public void should_return_user() {

        assertEquals(userListResponse.getQuantidade(), userListResponse.getUsuarios().size());

        userListResponse.getUsuarios().forEach(user -> {
            assertEquals(addUserRequest.getNome(), user.getNome());
            assertEquals(addUserRequest.getEmail(), user.getEmail());
            assertEquals(addUserRequest.getPassword(), user.getPassword());
            assertEquals(addUserRequest.getAdministrador(), user.getAdministrador());

            assertEquals(addUserResponse.getId(), user.getId());
        });
    }

    @Then("should return admin user")
    public void should_return_admin_user() {

        assertEquals(userListResponse.getQuantidade(), userListResponse.getUsuarios().size());
        userListResponse.getUsuarios().forEach(user ->
                assertEquals("true", user.getAdministrador()));
    }

    @Then("should return non admin user")
    public void should_return_non_admin_user() {

        assertEquals(userListResponse.getQuantidade(), userListResponse.getUsuarios().size());
        userListResponse.getUsuarios().forEach(user -> {
            assertEquals("false", user.getAdministrador());
        });
    }

    @Then("should not return users")
    public void should_not_return_users() {

        assertEquals(0, userListResponse.getQuantidade());
        assertTrue(userListResponse.getUsuarios().isEmpty());
    }

    @Then("should return Admin message error")
    public void should_return_admin_message_error() {

        assertEquals(Message.ADMIN_INVALIDO.getMessage(), userListResponse.getAdminMessageError());
    }

    @Then("should return email message error")
    public void should_return_email_message_error() {

        assertEquals(Message.EMAIL_INVALIDO.getMessage(), userListResponse.getEmailMessageError());
    }
}

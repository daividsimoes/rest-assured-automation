package br.com.restassured.automation.test.user;

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

public class UserStepDefinition {

    private RequestUtil requestUtil;

    private AddUserRequest addUserRequest;

    private AddUserResponse addUserResponse;

    private UserListResponse userListResponse;

    private final String USER = "/usuarios";

    private final String USER_QUERY_ID = "/usuarios?_id={0}";

    private final String USER_QUERY_ADMIN = "/usuarios?administrador={0}";

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
        assertEquals(userListResponse.getQuantidade(), userListResponse.getUsuarios().size());

        assertEquals(addUserRequest.getNome(), userListResponse.getUsuarios().get(0).getNome());
        assertEquals(addUserRequest.getEmail(), userListResponse.getUsuarios().get(0).getEmail());
        assertEquals(addUserRequest.getPassword(), userListResponse.getUsuarios().get(0).getPassword());
        assertEquals(addUserRequest.getAdministrador(), userListResponse.getUsuarios().get(0).getAdministrador());

        assertEquals(addUserResponse.getId(), userListResponse.getUsuarios().get(0).getId());
    }

    @Then("should return admin user")
    public void should_return_admin_user() {

        assertEquals(userListResponse.getQuantidade(), userListResponse.getUsuarios().size());
        userListResponse.getUsuarios().forEach(user -> {
            assertEquals("true", user.getAdministrador());
        });
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

    @Then("status code should be {int}")
    public void status_code_should_be(int code) {

        assertEquals(code, userListResponse.getStatusCode());
    }
}

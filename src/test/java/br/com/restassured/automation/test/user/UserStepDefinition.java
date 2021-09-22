package br.com.restassured.automation.test.user;

import br.com.restassured.automation.enums.Message;
import br.com.restassured.automation.factory.AddUserFactory;
import br.com.restassured.automation.model.request.user.AddOrUpdateUserRequest;
import br.com.restassured.automation.model.response.user.AddOrUpdateUserResponse;
import br.com.restassured.automation.model.response.user.UserListResponse;
import br.com.restassured.automation.model.response.user.UserResponse;
import br.com.restassured.automation.service.UserService;
import br.com.restassured.automation.util.FakerUtil;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

public class UserStepDefinition {

    private UserService userService;

    private AddUserFactory addUserFactory;

    private AddOrUpdateUserRequest addOrUpdateUserRequest;

    private AddOrUpdateUserResponse addOrUpdateUserResponse;

    private UserListResponse userListResponse;

    private UserResponse userResponse;

    @Before("@init")
    public void before() {

        userService = new UserService();
        addUserFactory = new AddUserFactory();
    }

    @Given("I have one user account")
    public void i_have_one_user_account() {

        addOrUpdateUserRequest = addUserFactory.buildAddUserRequest();
        addOrUpdateUserResponse = userService.addUser(addOrUpdateUserRequest);
    }

    @Given("I have one Admin user account")
    public void i_have_one_Admin_user_account() {

        addOrUpdateUserRequest = addUserFactory.buildAdminAddUserRequest();
        addOrUpdateUserResponse = userService.addUser(addOrUpdateUserRequest);
    }

    @Given("I call find user list API using invalid id as query id")
    public void i_call_find_user_list_API_using_invalid_id_as_query_id() {

        userListResponse = userService.getUserListById(new FakerUtil().generateRandomUuid());
    }

    @Given("I call find user list API using invalid name as query name")
    public void i_call_find_user_list_API_using_invalid_name_as_query_name() {

        userListResponse = userService.getUserListByName(new FakerUtil().generateRandomName());
    }

    @Given("I call find user list API using non existing email as query email")
    public void i_call_find_user_list_API_using_non_existing_email_as_query_email() {

        userListResponse = userService.getUserListByEmail(new FakerUtil().generateRandomEmail());
    }

    @Given("I call find user list API using invalid email as query email")
    public void i_call_find_user_list_API_using_invalid_email_as_query_email() {

        userListResponse = userService.getUserListByEmail(new FakerUtil().generateInvalidEmail());
    }

    @Given("I call find user list API using non existing password as query password")
    public void i_call_find_user_list_API_using_non_existing_password_as_query_password() {

        userListResponse = userService.getUserListByPassword(new FakerUtil().generateRandomPassword());
    }

    @Given("I call find user list API using invalid id with all queries")
    public void i_call_find_user_list_API_using_invalid_id_with_all_queries() {

        FakerUtil fakerUtil = new FakerUtil();

        userListResponse = userService.getUserListByAllQueries(fakerUtil.generateRandomUuid(),
                fakerUtil.generateRandomName(), fakerUtil.generateRandomEmail(),
                fakerUtil.generateRandomPassword(), "false"
        );
    }

    @Given("I call find user API using invalid id")
    public void i_call_find_user_API_using_invalid_id() {

        userResponse = userService.findUser(new FakerUtil().generateRandomUuid());
    }

    @Given("I build one user account")
    public void i_build_one_user_account() {

        addOrUpdateUserRequest = addUserFactory.buildAddUserRequest();
    }

    @Given("I build one admin user account")
    public void i_build_one_admin_user_account() {

        addOrUpdateUserRequest = addUserFactory.buildAdminAddUserRequest();
    }

    @Given("I build one user account with invalid email")
    public void i_build_one_user_account_with_invalid_email() {

        addOrUpdateUserRequest = addUserFactory.buildAddUserRequestWithEmail(new FakerUtil().generateInvalidEmail());
    }

    @Given("I build one user account with same email")
    public void i_build_one_user_account_with_same_email() {

        addOrUpdateUserRequest = addUserFactory.buildAddUserRequestWithEmail(addOrUpdateUserRequest.getEmail());
    }

    @Given("I build one user account with blank data")
    public void i_build_one_user_account_with_blank_data() {

        addOrUpdateUserRequest = addUserFactory.buildBlankUserRequest();
    }

    @Given("I build one user account with empty data")
    public void i_build_one_user_account_with_empty_data() {

        addOrUpdateUserRequest = addUserFactory.buildEmptyUserRequest();
    }

    @When("I call find user list API")
    public void i_call_find_user_list_API() {

        userListResponse = userService.getUserList();
    }

    @When("I call find user list API using query id")
    public void i_call_find_user_list_API_using_query_id() {

        userListResponse = userService.getUserListById(addOrUpdateUserResponse.getId());
    }

    @When("I call find user list API using query admin {string}")
    public void i_call_find_user_list_API_using_query_admin(String admin) {

        userListResponse = userService.getUserListByAdmin(admin);
    }

    @When("I call find user list API using query name")
    public void i_call_find_user_list_API_using_query_name() {

        userListResponse = userService.getUserListByName(addOrUpdateUserRequest.getNome());
    }

    @When("I call find user list API using query email")
    public void i_call_find_user_list_API_using_query_email() {

        userListResponse = userService.getUserListByEmail(addOrUpdateUserRequest.getEmail());
    }

    @When("I call find user list API using query password")
    public void i_call_find_user_API_using_query_password() {

        userListResponse = userService.getUserListByPassword(addOrUpdateUserRequest.getPassword());
    }

    @When("I call find user list API using all queries")
    public void i_call_find_user_API_using_all_queries() {

        userListResponse = userService.getUserListByAllQueries(addOrUpdateUserResponse.getId(),
                addOrUpdateUserRequest.getNome(), addOrUpdateUserRequest.getEmail(), addOrUpdateUserRequest.getPassword(),
                addOrUpdateUserRequest.getAdministrador());
    }

    @When("I call find user API")
    public void i_call_find_user_API() {

        userResponse = userService.findUser(addOrUpdateUserResponse.getId());
    }

    @When("I call add user API")
    public void i_call_add_user_API() {

        addOrUpdateUserResponse = userService.addUser(addOrUpdateUserRequest);
    }

    @When("I call update user API")
    public void i_call_update_user_API() {

        addOrUpdateUserResponse = userService.updateUser(addOrUpdateUserRequest, addOrUpdateUserResponse.getId());
    }

    @When("I call update user API with non existing id")
    public void i_call_update_user_API_with_non_existing_id() {

        addOrUpdateUserResponse = userService.updateUser(addOrUpdateUserRequest, new FakerUtil().generateRandomUuid());
    }

    @Then("status code should be {int} for user list response")
    public void status_code_should_be_for_user_list_response(int code) {

        assertEquals(code, userListResponse.getStatusCode());
    }

    @Then("status code should be {int} for user response")
    public void status_code_should_be_for_user_response(int code) {

        assertEquals(code, userResponse.getStatusCode());
    }

    @Then("status code should be {int} for add user response")
    public void status_code_should_be_for_add_user_response(int code) {

        assertEquals(code, addOrUpdateUserResponse.getStatusCode());
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

    @Then("should return user list Admin message error")
    public void should_return_user_list_admin_message_error() {

        assertEquals(Message.ADMIN_INVALIDO.getMessage(), userListResponse.getAdminMessageError());
    }

    @Then("should return user list email message error")
    public void should_return_user_list_email_message_error() {

        assertEquals(Message.EMAIL_INVALIDO.getMessage(), userListResponse.getEmailMessageError());
    }

    @Then("should return user")
    public void should_return_user() {

        assertEquals(addOrUpdateUserRequest.getNome(), userResponse.getNome());
        assertEquals(addOrUpdateUserRequest.getEmail(), userResponse.getEmail());
        assertEquals(addOrUpdateUserRequest.getPassword(), userResponse.getPassword());
        assertEquals(addOrUpdateUserRequest.getAdministrador(), userResponse.getAdministrador());
        assertEquals(addOrUpdateUserResponse.getId(), userResponse.getId());
    }

    @Then("should return not found user message error")
    public void should_return_not_found_user_message_error() {

        assertEquals(Message.USUARIO_NAO_ENCONTRADO.getMessage(), userResponse.getMessageError());
    }

    @Then("should add user successfully")
    public void should_add_user_successfully() {

        assertNotNull(addOrUpdateUserResponse.getId());
        assertEquals(Message.CADASTRO_COM_SUCESSO.getMessage(), addOrUpdateUserResponse.getMessage());
    }

    @Then("should return add user email message error")
    public void should_return_add_user_email_message_error() {

        assertEquals(Message.EMAIL_INVALIDO.getMessage(), addOrUpdateUserResponse.getEmailMessageError());
    }

    @Then("should return add user email already exist message error")
    public void should_return_add_user_email_already_exist_message_error() {

        assertEquals(Message.EMAIL_JA_UTILIZADO.getMessage(), addOrUpdateUserResponse.getMessageError());
    }

    @Then("should return add user required filds message error")
    public void should_return_add_user_required_filds_message_error() {

        assertEquals(Message.NOME_OBRIGATORIO.getMessage(), addOrUpdateUserResponse.getNameMessageError());
        assertEquals(Message.EMAIL_OBRIGATORIO.getMessage(), addOrUpdateUserResponse.getEmailMessageError());
        assertEquals(Message.ADMIN_OBRIGATORIO.getMessage(), addOrUpdateUserResponse.getAdminMessageError());
        assertEquals(Message.PASSWORD_OBRIGATORIO.getMessage(), addOrUpdateUserResponse.getPasswordMessageError());
    }

    @Then("should return add user empty fields message error")
    public void should_return_add_user_empty_fields_message_error() {

        assertEquals(Message.NOME_BRANCO.getMessage(), addOrUpdateUserResponse.getNameMessageError());
        assertEquals(Message.EMAIL_BRANCO.getMessage(), addOrUpdateUserResponse.getEmailMessageError());
        assertEquals(Message.ADMIN_INVALIDO.getMessage(), addOrUpdateUserResponse.getAdminMessageError());
        assertEquals(Message.PASSWORD_BRANCO.getMessage(), addOrUpdateUserResponse.getPasswordMessageError());
    }

    @Then("should update user successfully")
    public void should_update_user_successfully() {

        assertEquals(Message.REGISTRO_ALTERADO_COM_SUCESSO.getMessage(), addOrUpdateUserResponse.getMessage());
    }
}

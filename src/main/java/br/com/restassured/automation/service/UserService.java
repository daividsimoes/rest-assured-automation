package br.com.restassured.automation.service;

import br.com.restassured.automation.model.request.user.AddOrUpdateUserRequest;
import br.com.restassured.automation.model.response.user.AddOrUpdateUserResponse;
import br.com.restassured.automation.model.response.user.UserListResponse;
import br.com.restassured.automation.model.response.user.UserResponse;
import br.com.restassured.automation.request.RequestUtil;

public class UserService {

    private RequestUtil requestUtil;

    private final String USER = "/usuarios";

    private final String USER_ID = "/usuarios/{0}";

    private final String USER_QUERY_ID = "/usuarios?_id={0}";

    private final String USER_QUERY_ADMIN = "/usuarios?administrador={0}";

    private final String USER_QUERY_NAME = "/usuarios?nome={0}";

    private final String USER_QUERY_EMAIL = "/usuarios?email={0}";

    private final String USER_QUERY_PASSWORD = "/usuarios?password={0}";

    private final String USER_ALL_QUERY = "/usuarios?_id={0}&nome={1}&email={2}&password={3}&administrador={4}";


    public UserService() {

        requestUtil = new RequestUtil();
    }

    public AddOrUpdateUserResponse addUser(AddOrUpdateUserRequest addOrUpdateUserRequest) {

        return requestUtil.post(addOrUpdateUserRequest, AddOrUpdateUserResponse.class, USER);
    }

    public AddOrUpdateUserResponse updateUser(AddOrUpdateUserRequest addOrUpdateUserRequest, String id) {

        return requestUtil.put(addOrUpdateUserRequest, AddOrUpdateUserResponse.class, USER_ID, id);
    }

    public UserListResponse getUserList() {

        return requestUtil.get(UserListResponse.class, USER);
    }

    public UserListResponse getUserListById(String id) {

        return requestUtil.get(UserListResponse.class, USER_QUERY_ID, id);
    }

    public UserListResponse getUserListByName(String name) {

        return requestUtil.get(UserListResponse.class, USER_QUERY_NAME, name);
    }

    public UserListResponse getUserListByEmail(String email) {

        return requestUtil.get(UserListResponse.class, USER_QUERY_EMAIL, email);
    }

    public UserListResponse getUserListByPassword(String password) {

        return requestUtil.get(UserListResponse.class, USER_QUERY_PASSWORD, password);
    }

    public UserListResponse getUserListByAdmin(String admin) {

        return requestUtil.get(UserListResponse.class, USER_QUERY_ADMIN, admin);
    }

    public UserListResponse getUserListByAllQueries(String id, String nome, String email, String password,
                                                    String administrador) {

        return requestUtil.get(UserListResponse.class, USER_ALL_QUERY, id, nome, email, password,
                administrador
        );
    }

    public UserResponse findUser(String id) {

        return requestUtil.get(UserResponse.class, USER_ID, id);
    }
}

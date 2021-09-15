package br.com.restassured.automation.util;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestUtil {

    private HeaderUtil headerUtil;

    public RequestUtil() {

        headerUtil = new HeaderUtil();
    }

    public Response post(Headers headers, Object body, String endpoint) {

        return given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(body)
                .post(endpoint);
    }

    public Response post(Object body, String endpoint) {

        return post(headerUtil.getHeader(), body, endpoint);
    }

    public Response put(Headers headers, Object body, String endpoint) {

        return given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(body)
                .put(endpoint);
    }

    public Response put(Object body, String endpoint) {

        return put(headerUtil.getHeader(), body, endpoint);
    }

    public Response delete(Headers headers, String endpoint) {

        return given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .delete(endpoint);
    }

    public Response delete(String endpoint) {

        return delete(headerUtil.getHeader(), endpoint);
    }

    public Response get(Headers headers, String endpoint) {

        return given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .get(endpoint);
    }

    public Response get(String endpoint) {

        return get(headerUtil.getHeader(), endpoint);
    }
}

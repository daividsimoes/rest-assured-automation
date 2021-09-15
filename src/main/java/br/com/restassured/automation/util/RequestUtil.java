package br.com.restassured.automation.util;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestUtil {

    public Response post(Headers headers, Object body, String endpoint) {

        return given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(body)
                .post(endpoint);
    }

    public Response put(Headers headers, Object body, String endpoint) {

        return given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(body)
                .put(endpoint);
    }

    public Response delete(Headers headers, String endpoint) {

        return given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .delete(endpoint);
    }

    public Response get(Headers headers, String endpoint) {

        return given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .get(endpoint);
    }
}

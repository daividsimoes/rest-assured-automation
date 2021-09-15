package br.com.restassured.automation.request;

import br.com.restassured.automation.util.UrlUtil;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestUtil {

    private HeaderUtil headerUtil;

    private String url;

    public RequestUtil() {

        headerUtil = new HeaderUtil();
    }

    public Response post(Headers headers, Object body, String endpoint, Object... args) {

        url = UrlUtil.buildUrl(endpoint, args);

        return given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(body)
                .post(url);
    }

    public Response post(Object body, String endpoint, Object... args) {

        return post(headerUtil.getHeader(), body, endpoint, args);
    }

    public Response put(Headers headers, Object body, String endpoint, Object... args) {

        url = UrlUtil.buildUrl(endpoint, args);

        return given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(body)
                .put(url);
    }

    public Response put(Object body, String endpoint, Object... args) {

        return put(headerUtil.getHeader(), body, endpoint, args);
    }

    public Response delete(Headers headers, String endpoint, Object... args) {

        url = UrlUtil.buildUrl(endpoint, args);

        return given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .delete(url);
    }

    public Response delete(String endpoint, Object... args) {

        return delete(headerUtil.getHeader(), endpoint, args);
    }

    public Response get(Headers headers, String endpoint, Object... args) {

        url = UrlUtil.buildUrl(endpoint, args);
        return given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .get(url);
    }

    public Response get(String endpoint, Object... args) {

        return get(headerUtil.getHeader(), endpoint, args);
    }
}

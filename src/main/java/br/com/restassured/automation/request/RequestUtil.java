package br.com.restassured.automation.request;

import br.com.restassured.automation.model.response.ResponseObject;
import br.com.restassured.automation.util.JsonUtil;
import br.com.restassured.automation.util.UrlUtil;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;

import static io.restassured.RestAssured.given;

@Slf4j
public class RequestUtil {

    private HeaderUtil headerUtil;

    private String url;

    public RequestUtil() {

        headerUtil = new HeaderUtil();
    }

    public <T extends ResponseObject> T post(Headers headers, Object body, Class<T> clazz,
                                             String endpoint, Object... args) {

        url = UrlUtil.buildUrl(endpoint, args);

        log.info("REQUEST -> Executing POST on: {}", url);
        log.info("REQUEST -> Headers: {}", JsonUtil.convertToJson(headers.asList()));
        log.info("REQUEST -> BODY: {}", JsonUtil.convertToJson(body));

        Response response = given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(JsonUtil.convertToJson(body))
                .post(url);

        log.info("RESPONSE -> StatusCode: {}", response.getStatusCode());
        log.info("RESPONSE -> Time: {}", response.getTime());
        log.info("RESPONSE -> Body: {}", response.getBody().asString());

        return convertResponseToObject(response, clazz);
    }

    public <T extends ResponseObject> T post(Object body, Class<T> clazz,
                                             String endpoint, Object... args) {

        return post(headerUtil.getHeader(), body, clazz, endpoint, args);
    }

    public <T extends ResponseObject> T put(Headers headers, Object body, Class<T> clazz,
                                            String endpoint, Object... args) {

        url = UrlUtil.buildUrl(endpoint, args);

        log.info("REQUEST -> Executing PUT on: {}", url);
        log.info("REQUEST -> Headers: {}", JsonUtil.convertToJson(headers.asList()));
        log.info("REQUEST -> BODY: {}", JsonUtil.convertToJson(body));

        Response response = given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(JsonUtil.convertToJson(body))
                .put(url);

        log.info("RESPONSE -> StatusCode: {}", response.getStatusCode());
        log.info("RESPONSE -> Time: {}", response.getTime());
        log.info("RESPONSE -> Body: {}", response.getBody().asString());

        return convertResponseToObject(response, clazz);
    }

    public <T extends ResponseObject> T put(Object body, Class<T> clazz, String endpoint,
                                            Object... args) {

        return put(headerUtil.getHeader(), body, clazz, endpoint, args);
    }

    public <T extends ResponseObject> T delete(Headers headers, Class<T> clazz, String endpoint,
                                               Object... args) {

        url = UrlUtil.buildUrl(endpoint, args);

        log.info("REQUEST -> Executing DELETE on: {}", url);
        log.info("REQUEST -> Headers: {}", JsonUtil.convertToJson(headers.asList()));

        Response response = given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .delete(url);

        log.info("RESPONSE -> StatusCode: {}", response.getStatusCode());
        log.info("RESPONSE -> Time: {}", response.getTime());
        log.info("RESPONSE -> Body: {}", response.getBody().asString());

        return convertResponseToObject(response, clazz);
    }

    public <T extends ResponseObject> T delete(Class<T> clazz, String endpoint, Object... args) {

        return delete(headerUtil.getHeader(), clazz, endpoint, args);
    }

    public <T extends ResponseObject> T get(Headers headers, Class<T> clazz, String endpoint,
                                            Object... args) {

        url = UrlUtil.buildUrl(endpoint, args);

        log.info("REQUEST -> Executing GET on: {}", url);
        log.info("REQUEST -> Headers: {}", JsonUtil.convertToJson(headers.asList()));

        Response response = given()
                .contentType(ContentType.JSON)
                .headers(headers)
                .get(url);

        log.info("RESPONSE -> StatusCode: {}", response.getStatusCode());
        log.info("RESPONSE -> Time: {}", response.getTime());
        log.info("RESPONSE -> Body: {}", response.getBody().asString());

        return convertResponseToObject(response, clazz);
    }

    public <T extends ResponseObject> T get(Class<T> clazz, String endpoint, Object... args) {

        return get(headerUtil.getHeader(), clazz, endpoint, args);
    }

    private <T extends ResponseObject> T convertResponseToObject(Response response, Class<T> clazz) {

        T responseConverted = null;

        if (!response.getBody().asString().isEmpty()) {

            try {

                log.info("Converting response to class: {}", clazz);
                responseConverted = response.getBody().as(clazz);
            } catch (Exception e) {

                throw new RuntimeException(
                        MessageFormat.format("Failure to convert response -> {0}\nException Message -> {1}",
                                response.getBody().asString(), e.getMessage())
                );
            }
        }
        responseConverted.setStatusCode(response.getStatusCode());
        return responseConverted;
    }
}

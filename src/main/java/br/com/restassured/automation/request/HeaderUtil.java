package br.com.restassured.automation.request;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class HeaderUtil {

    public Headers getHeader(Header... header) {

        return new Headers(header);
    }
}

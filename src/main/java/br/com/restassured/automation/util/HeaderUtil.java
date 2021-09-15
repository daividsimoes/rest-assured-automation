package br.com.restassured.automation.util;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class HeaderUtil {

    public Headers getHeader(Header... header) {

        return new Headers(header);
    }
}

package br.com.restassured.automation.util;

import java.text.MessageFormat;

public class UrlUtil {

    private static final String HOST = "https://serverest.dev";

    public static String buildUrl(String endpoint, Object... args) {

        return HOST.concat(MessageFormat.format(endpoint, args));
    }
}

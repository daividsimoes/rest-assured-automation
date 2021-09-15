package br.com.restassured.automation.util;

import com.google.gson.GsonBuilder;

public class JsonUtil {

    public static String convertToJson(Object obj) {

        return new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(obj);
    }
}

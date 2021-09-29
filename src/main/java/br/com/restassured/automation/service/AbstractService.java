package br.com.restassured.automation.service;

import br.com.restassured.automation.request.RequestUtil;

public abstract class AbstractService {

    protected RequestUtil requestUtil;

    public AbstractService(){

        requestUtil = new RequestUtil();
    }
}

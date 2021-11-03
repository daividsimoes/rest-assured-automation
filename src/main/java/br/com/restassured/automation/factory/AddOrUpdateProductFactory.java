package br.com.restassured.automation.factory;

import br.com.restassured.automation.model.request.product.AddOrUpdateProductRequest;
import br.com.restassured.automation.util.FakerUtil;

public class AddOrUpdateProductFactory {

    FakerUtil fakerUtil = new FakerUtil();

    public AddOrUpdateProductRequest buildProduct(){

        return AddOrUpdateProductRequest.builder()
                .nome(fakerUtil.generateRadomProduct())
                .preco(fakerUtil.generateRadomPrice())
                .descricao(fakerUtil.generateRadomTextDescription())
                .quantidade(fakerUtil.generateRadomQuantity())
                .build();
    }
}

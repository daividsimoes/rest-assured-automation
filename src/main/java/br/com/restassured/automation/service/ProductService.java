package br.com.restassured.automation.service;

import br.com.restassured.automation.model.request.product.AddOrUpdateProductRequest;
import br.com.restassured.automation.model.response.product.AddOrUpdateProductResponse;

public class ProductService extends AbstractService {

    private static final String PRODUCT = "/produtos";

    public AddOrUpdateProductResponse addProduct(AddOrUpdateProductRequest addOrUpdateProductRequest,
                                                 String authorization) {

        return requestUtil.post(authorization, addOrUpdateProductRequest, AddOrUpdateProductResponse.class, PRODUCT);
    }
}

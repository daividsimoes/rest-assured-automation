package br.com.restassured.automation.model.response.product;

import br.com.restassured.automation.model.response.ResponseObject;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ProductListResponse extends ResponseObject implements Serializable {

    private int quantidade;

    private List<ProductResponse> produtos;
}

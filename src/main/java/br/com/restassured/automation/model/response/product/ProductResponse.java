package br.com.restassured.automation.model.response.product;

import br.com.restassured.automation.model.response.ResponseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductResponse extends ResponseObject implements Serializable {

    private String nome;

    private String descricao;

    private int preco;

    private int quantidade;

    @JsonProperty("_id")
    private String id;
}

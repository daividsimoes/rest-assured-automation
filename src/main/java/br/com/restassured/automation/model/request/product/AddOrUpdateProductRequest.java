package br.com.restassured.automation.model.request.product;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class AddOrUpdateProductRequest {

    private String nome;

    private String descricao;

    private int preco;

    private int quantidade;
}

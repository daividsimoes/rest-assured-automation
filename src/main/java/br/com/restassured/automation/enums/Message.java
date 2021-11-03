package br.com.restassured.automation.enums;

import lombok.Getter;

@Getter
public enum Message {

    EMAIL_ALREADY_USED("Este email já está sendo usado"),
    EMPTY_EMAIL("email não pode ficar em branco"),
    EMPTY_NAME("nome não pode ficar em branco"),
    EMPTY_PASSWORD("password não pode ficar em branco"),
    INVALID_ADMIN("administrador deve ser 'true' ou 'false'"),
    INVALID_EMAIL("email deve ser um email válido"),
    INVALID_EMAIL_OR_PASSWORD("Email e/ou senha inválidos"),
    LOGIN_PERFORMED_SUCCESSFULLY("Login realizado com sucesso"),
    NO_RECORD_DELETED("Nenhum registro excluído"),
    RECORD_UPDATED("Registro alterado com sucesso"),
    RECORD_DELETED("Registro excluído com sucesso"),
    REGISTRATION_PERFORMED_SUCCESSFULLY("Cadastro realizado com sucesso"),
    REQUIRED_ADMIN("administrador é obrigatório"),
    REQUIRED_EMAIL("email é obrigatório"),
    REQUIRED_NAME("nome é obrigatório"),
    REQUIRED_PASSWORD("password é obrigatório"),
    USER_NOT_FOUND("Usuário não encontrado");

    private final String message;

    Message(String message) {

        this.message = message;
    }
}

package br.com.restassured.automation.enums;

import lombok.Getter;

@Getter
public enum Message {

    //USER
    ADMIN_INVALIDO("administrador deve ser 'true' ou 'false'"),
    ADMIN_OBRIGATORIO("administrador é obrigatório"),
    CADASTRO_COM_SUCESSO("Cadastro realizado com sucesso"),
    EMAIL_BRANCO("email não pode ficar em branco"),
    EMAIL_INVALIDO("email deve ser um email válido"),
    EMAIL_JA_UTILIZADO("Este email já está sendo usado"),
    EMAIL_OBRIGATORIO("email é obrigatório"),
    EXISTE_PRODUTO_COM_ESSE_NOME("Já existe produto com esse nome"),
    NAO_E_PERMITIDO_EXCLUIR_USUARIO_COMCARRINHO_CADASTRADO("Não é permitido excluir usuário com carrinho cadastrado"),
    NENHUM_REGISTRO_EXCLUIDO("Nenhum registro excluído"),
    NOME_BRANCO("nome não pode ficar em branco"),
    NOME_OBRIGATORIO("nome é obrigatório"),
    PASSWORD_BRANCO("password não pode ficar em branco"),
    PASSWORD_OBRIGATORIO("password é obrigatório"),
    REGISTRO_ALTERADO_COM_SUCESSO("Registro alterado com sucesso"),
    REGISTRO_EXCLUIDO_COM_SUCESSO("Registro excluído com sucesso"),
    USUARIO_NAO_ENCONTRADO("Usuário não encontrado");

    private final String message;

    Message(String message) {

        this.message = message;
    }

}

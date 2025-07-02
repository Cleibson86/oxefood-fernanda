package br.com.ifpe.oxefood.modelo.funcionario;

import com.fasterxml.jackson.annotation.JsonValue;
// enum é um tipo de arquivo, criado para limitar as opções que o usuário vai lista.
public enum TipoFuncionario {

    ADMINISTRADOR(
            "Administrador"),
    OPERADOR(
            "Operador");

    private String tipo;

    private TipoFuncionario(String tipo) {
        this.tipo = tipo;
    }

    @JsonValue
    public String getTipo() {
        return tipo;
    }

}
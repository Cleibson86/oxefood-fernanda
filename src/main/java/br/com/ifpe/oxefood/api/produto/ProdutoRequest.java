package br.com.ifpe.oxefood.api.produto;

//import java.time.LocalDate;

//import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ProdutoRequest {
    
    //private String nome;

    //@JsonFormat(pattern = "dd/MM/yyyy")
    //private LocalDate dataNascimento;

    private String codigo;

    private String titulo;

    private String descricao;
    
    private Double valorUnitario;

    private Integer tempoEntregaMinimo;

    private Integer tempoEntregaMaxima;

    public Produto build() {

        return Produto.builder()
                //.nome(nome)
                //.dataNascimento(dataNascimento)
                .codigo(codigo)
                .titulo(titulo)
                .descricao(descricao)
                .valorUnitario(valorUnitario)
                .tempoEntregaMinimo(tempoEntregaMinimo)
                .tempoEntregaMaxima(tempoEntregaMaxima)
                .build();
    }

    
}

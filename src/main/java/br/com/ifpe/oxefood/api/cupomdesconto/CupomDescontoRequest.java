package br.com.ifpe.oxefood.api.cupomdesconto;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

//import br.com.ifpe.oxefood.modelo.cupomdesconto.cupomdesconto;
import br.com.ifpe.oxefood.modelo.cupomdesconto.CupomDesconto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CupomDescontoRequest {
    
    private String codigoDesconto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate inicioVigencia;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fimVigencia;

    private Double percentualDesconto;

    private  Double valorDesconto;

    private  Double valorMinimoPedido;

    private  int quantidadeMaximoUso;

    public CupomDesconto build() {

        return CupomDesconto.builder()
                .codigoDesconto(codigoDesconto)
                .inicioVigencia(inicioVigencia)
                .fimVigencia(fimVigencia)
                .percentualDesconto(percentualDesconto)
                .valorDesconto(valorDesconto)
                .valorMinimoPedido(valorMinimoPedido)
                .quantidadeMaximoUso(quantidadeMaximoUso)
                .build();
    }


    
}

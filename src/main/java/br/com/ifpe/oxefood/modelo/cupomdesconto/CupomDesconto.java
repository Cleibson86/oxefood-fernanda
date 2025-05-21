package br.com.ifpe.oxefood.modelo.cupomdesconto;
import java.time.LocalDate;
import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity //Alterar, gravar se em cima da class estiver Entity
@Table(name = "cupomdesconto ")//convertida em uma tabela no banco
@SQLRestriction("habilitado = true")// acrescente em todas as consultas uma clausula where: habilitado = true

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CupomDesconto extends EntidadeAuditavel {
   
    @Column
   private String codigoDesconto;
    
   @Column(name="inicio_vigencia")
    private LocalDate inicioVigencia;

    @Column(name="fim_vigencia")
    private LocalDate fimVigencia;
   
   @Column
  private Double percentualDesconto;
   
   @Column
  private  Double valorDesconto;
  
   @Column
   private  Double valorMinimoPedido;

   @Column
    private  int quantidadeMaximoUso;


}

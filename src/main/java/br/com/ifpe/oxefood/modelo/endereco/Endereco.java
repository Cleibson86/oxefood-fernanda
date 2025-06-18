package br.com.ifpe.oxefood.modelo.endereco;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Endereco")
@SQLRestriction("habilitado = true")

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco extends EntidadeAuditavel {
    
    @Column
    private String bairro;

    @Column
    private String cep;

    @Column
    private String rua;

    @Column
    private Integer numero;

    @Column
    private String estado;

    @ManyToOne
    @JoinColumn(nullable = false)
    public Cliente cliente;
}

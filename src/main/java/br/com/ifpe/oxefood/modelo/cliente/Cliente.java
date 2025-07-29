package br.com.ifpe.oxefood.modelo.cliente;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.modelo.acesso.Usuario;
import br.com.ifpe.oxefood.modelo.endereco.Endereco;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // Alterar, gravar se em cima da class estiver Entity
@Table(name = "Cliente") // convertida em uma tabela no banco
@SQLRestriction("habilitado = true") // acrescente em todas as consultas uma clausula where: habilitado = true

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel {

   @OneToOne
   @JoinColumn(nullable = false)
   private Usuario usuario;

   @OneToMany(mappedBy = "cliente", orphanRemoval = true, fetch = FetchType.EAGER) //armazenar uma lista de endereços do cliente:

   @Fetch(FetchMode.SUBSELECT)
   private List<Endereco> enderecos;


   @Column(nullable = false, length = 100) //O campo nome não poderá ser nulo e não pode pode ter mais que 100 caracteres ao ser salvo no banco de dados.
   private String nome;

   @Column(name = "dt_nasc")
   private LocalDate dataNascimento;

   @Column(unique = true) // O campo cpf é único no banco de dados, ou seja, não poderá ser salvo um cliente com um CPF que já exista em algum outro cliente no banco de dados.

   private String cpf;

   @Column
   private String foneCelular;

   @Column
   private String foneFixo;

}

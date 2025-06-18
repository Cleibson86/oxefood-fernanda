package br.com.ifpe.oxefood.api.endereco;

import org.hibernate.validator.constraints.Length;
import br.com.ifpe.oxefood.modelo.endereco.Endereco;
import jakarta.validation.constraints.NotNull; 
import jakarta.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoRequest {
    
    private long idEndereco;

    @NotNull(message = "O Bairro é de preenchimento obrigatório")
    @NotEmpty(message = "O Bairro é de preenchimento obrigatório")
    @Length(max = 100, message = "O Bairro deverá ter no máximo {max} caracteres")
    
    private String bairro;
    
    private String cep;

    private String rua;

    private Integer numero;

    private String estado;

    @NotNull(message = "O id do cliente é obrigatório")
    private Long idCliente;

    public Endereco build() {
        return Endereco.builder()
                .bairro(bairro)
                .cep(cep)
                .rua(rua)
                .numero(numero)
                .estado(estado)
                .build();
    }
}

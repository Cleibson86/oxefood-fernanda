package br.com.ifpe.oxefood.modelo.endereco;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByClienteId(Long clienteId);
}


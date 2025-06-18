package br.com.ifpe.oxefood.modelo.endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
public class EnderecoService {
    
    @Autowired // instânciar um objeto(repository)
    private EnderecoRepository repository;

    @Transactional
    public Endereco save(Endereco endereco) {

        endereco.setHabilitado(Boolean.TRUE);
        return repository.save(endereco);
    }
    public List<Endereco> listarTodos() {
        return repository.findAll();//SELECT * FROM Endereco
    }
    
    public List<Endereco> ListaTodosEnderecosPorCliente(Long idCliente) {
        return repository.findByClienteId(idCliente);
    }

    public Endereco obterPorID(Long id) {

        return repository.findById(id).get();// SELECT * Cliente where id
    }
    @Transactional
   public void update(Long id, Endereco enderecoAlterado) {

      Endereco endereco = repository.findById(id).get();
      endereco.setBairro(enderecoAlterado.getBairro());
      endereco.setCep(enderecoAlterado.getCep());
      endereco.setRua(enderecoAlterado.getRua());
      endereco.setNumero(enderecoAlterado.getNumero());
      endereco.setEstado(enderecoAlterado.getEstado());
	    
      repository.save(endereco);
  }
  @Transactional
   public void delete(Long id) {

       Endereco endereco = repository.findById(id).get();
       endereco.setHabilitado(Boolean.FALSE);

       repository.save(endereco);
   }

}


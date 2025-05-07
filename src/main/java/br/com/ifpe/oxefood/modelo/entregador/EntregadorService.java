package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import jakarta.transaction.Transactional;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    @Transactional
    public Entregador save(Entregador entregador) {

        entregador.setHabilitado(Boolean.TRUE);
        return repository.save(entregador);
    }
    
    public List<Entregador> listarTodos() {
  
        return repository.findAll();//SELECT * FROM Cliente
    }

    public Entregador obterPorID(Long id) {

        return repository.findById(id).get();// SELECT * Cliente where id
    }
    
    @Transactional
    public void update(Long id, Entregador entregadorAlterado) {

        Entregador entregador = repository.findById(id).get();
        entregador.setNome(entregadorAlterado.getNome());
        entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
        entregador.setCpf(entregadorAlterado.getCpf());
        entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
        entregador.setFoneFixo(entregadorAlterado.getFoneFixo());

        repository.save(entregador);
    }
    @Transactional
    public void delete(Long id) {
 
        Entregador entregador = repository.findById(id).get();
        entregador.setHabilitado(Boolean.FALSE);
 
        repository.save(entregador);
    }
}

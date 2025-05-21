package br.com.ifpe.oxefood.modelo.cupomdesconto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.transaction.Transactional;


@Service

public class CupomDescontoService {

    @Autowired // instânciar um objeto(repository)
    private CupomDescontoRepository repository;

    @Transactional
    public CupomDesconto save(CupomDesconto cupomdesconto) {

        cupomdesconto.setHabilitado(Boolean.TRUE);
        return repository.save(cupomdesconto);
    }
    public List<CupomDesconto> listarTodos() {
  
        return repository.findAll();//SELECT * FROM Cliente
    }

    public CupomDesconto obterPorID(Long id) {

        return repository.findById(id).get();// SELECT * Cliente where id
    }
    @Transactional
public void update(Long id, CupomDesconto cupomdescontoAlterado) {
 CupomDesconto cupomdesconto = repository.findById(id).get();

 cupomdesconto.setCodigoDesconto(cupomdescontoAlterado.getCodigoDesconto());
cupomdesconto.setInicioVigencia(cupomdescontoAlterado.getInicioVigencia());
cupomdesconto.setFimVigencia(cupomdescontoAlterado.getFimVigencia());
cupomdesconto.setPercentualDesconto(cupomdescontoAlterado.getPercentualDesconto());
cupomdesconto.setValorDesconto(cupomdescontoAlterado.getValorDesconto());
cupomdesconto.setValorMinimoPedido(cupomdescontoAlterado.getValorMinimoPedido());
cupomdesconto.setQuantidadeMaximoUso(cupomdescontoAlterado.getQuantidadeMaximoUso());
   
   repository.save(cupomdesconto);
}

@Transactional
   public void delete(Long id) {

    CupomDesconto cupomdesconto = repository.findById(id).get();
    cupomdesconto.setHabilitado(Boolean.FALSE);

       repository.save(cupomdesconto);
   }

}
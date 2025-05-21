package br.com.ifpe.oxefood.api.cupomdesconto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.ifpe.oxefood.modelo.cupomdesconto.CupomDesconto;
import br.com.ifpe.oxefood.modelo.cupomdesconto.CupomDescontoService;


@RestController // O que faz essa class ser controlador é o (@RestController)
@RequestMapping("/api/cupomdesconto") // Indica o endereço do controlador para rodar na tela.
@CrossOrigin 

public class CupomDescontoController {
  @Autowired // estânciar um objeto
  private CupomDescontoService cupomdescontoService;  
  @PostMapping // especificar que vai receber requisições do post
  public ResponseEntity<CupomDesconto> save(@RequestBody CupomDescontoRequest request) {

   CupomDesconto cupomdesconto = cupomdescontoService.save(request.build());
    return new ResponseEntity<CupomDesconto>(cupomdesconto, HttpStatus.CREATED);

  }
  @GetMapping
  public List<CupomDesconto> listarTodos() {
    return cupomdescontoService.listarTodos();
  }
   @GetMapping("/{id}")
  public CupomDesconto obterPorID(@PathVariable Long id) {
    return cupomdescontoService.obterPorID(id);
  }
  @PutMapping("/{id}")
  public ResponseEntity<CupomDesconto> update(@PathVariable("id") Long id, @RequestBody CupomDescontoRequest request) {

    cupomdescontoService.update(id, request.build());
    return ResponseEntity.ok().build();
  }
    @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       cupomdescontoService.delete(id);
       return ResponseEntity.ok().build();
   }
}

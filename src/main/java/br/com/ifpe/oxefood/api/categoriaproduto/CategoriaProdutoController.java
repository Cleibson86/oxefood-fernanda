package br.com.ifpe.oxefood.api.categoriaproduto;

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

import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.categoriaproduto.CategoriaProdutoService;
import jakarta.validation.Valid;


@RestController // O que faz essa class ser controlador é o (@RestController)
@RequestMapping("/api/categoriaproduto") // Indica o endereço do controlador para rodar na tela.
@CrossOrigin // Para receber requisições do react


public class CategoriaProdutoController {
    @Autowired // estânciar um objeto
  private CategoriaProdutoService categoriaprodutoService;

  @PostMapping // especificar que vai receber requisições do post
  public ResponseEntity<CategoriaProduto> save(@RequestBody @Valid CategoriaProdutoRequest request) {

    CategoriaProduto categoriaproduto = categoriaprodutoService.save(request.build());
    return new ResponseEntity<CategoriaProduto>(categoriaproduto, HttpStatus.CREATED);

  }

  @GetMapping
  public List<CategoriaProduto> listarTodos() {
    return categoriaprodutoService.listarTodos();
  }

  @GetMapping("/{id}")
  public CategoriaProduto obterPorID(@PathVariable Long id) {
    return categoriaprodutoService.obterPorID(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CategoriaProduto> update(@PathVariable("id") Long id, @RequestBody @Valid CategoriaProdutoRequest request) {

    categoriaprodutoService.update(id, request.build());
    return ResponseEntity.ok().build();
  }
    @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

      categoriaprodutoService.delete(id);
       return ResponseEntity.ok().build();
   }
    
}

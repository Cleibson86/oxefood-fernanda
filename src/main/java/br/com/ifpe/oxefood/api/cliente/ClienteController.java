package br.com.ifpe.oxefood.api.cliente;

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
import jakarta.validation.Valid;


import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;

@RestController // O que faz essa class ser controlador é o (@RestController)
@RequestMapping("/api/cliente") // Indica o endereço do controlador para rodar na tela.
@CrossOrigin // Para receber requisições do react

public class ClienteController {
  @Autowired // estânciar um objeto
  private ClienteService clienteService;

  @PostMapping // especificar que vai receber requisições do post
  public ResponseEntity<Cliente> save(@RequestBody  @Valid ClienteRequest request) {

    Cliente cliente = clienteService.save(request.build());
    return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);

  }

  @GetMapping
  public List<Cliente> listarTodos() {
    return clienteService.listarTodos();
  }

  @GetMapping("/{id}")
  public Cliente obterPorID(@PathVariable Long id) {
    return clienteService.obterPorID(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody  @Valid ClienteRequest request) {

    clienteService.update(id, request.build());
    return ResponseEntity.ok().build();
  }
    @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       clienteService.delete(id);
       return ResponseEntity.ok().build();
   }

}

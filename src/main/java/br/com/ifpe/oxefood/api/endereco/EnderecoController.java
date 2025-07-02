package br.com.ifpe.oxefood.api.endereco;

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
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import br.com.ifpe.oxefood.modelo.endereco.Endereco;
import br.com.ifpe.oxefood.modelo.endereco.EnderecoService;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController // O que faz essa class ser controlador é o (@RestController)
@RequestMapping("/api/endereco") // Indica o endereço do controlador para rodar na tela.
@CrossOrigin // Para receber requisições do react

public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private ClienteService clienteService;

  @PostMapping// especificar que vai receber requisições do post
  public ResponseEntity<Endereco> save(@RequestBody  @Valid EnderecoRequest request) {
    Endereco enderecoNovo = request.build();
    enderecoNovo.setCliente(clienteService.obterPorID(request.getIdCliente()));
    Endereco endereco = enderecoService.save(enderecoNovo);

    //Endereco endereco = enderecoService.save(request.build());
    return new ResponseEntity<Endereco>(endereco, HttpStatus.CREATED);    
  }

  @GetMapping
  public List<Endereco> listarTodos() {
    return enderecoService.listarTodos();
  }

  @GetMapping("/cliente/{idCliente}")  
  public List<Endereco> listaTodosPorCliente(@PathVariable Long idCliente) {
    return enderecoService.ListaTodosEnderecosPorCliente(idCliente);
  }

  @GetMapping("/{id}")
  public Endereco obterPorID(@PathVariable Long id) {
    return enderecoService.obterPorID(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Endereco> update(@PathVariable("id") Long id, @RequestBody  @Valid EnderecoRequest request) {

    enderecoService.update(id, request.build());
    return ResponseEntity.ok().build();
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {

      enderecoService.delete(id);
      return ResponseEntity.ok().build();
  }

}

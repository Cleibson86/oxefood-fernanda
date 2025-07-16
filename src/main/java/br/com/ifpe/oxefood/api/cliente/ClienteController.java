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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import br.com.ifpe.oxefood.modelo.acesso.UsuarioService;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;

@RestController // O que faz essa class ser controlador é o (@RestController)
@RequestMapping("/api/cliente") // Indica o endereço do controlador para rodar na tela.
@CrossOrigin // Para receber requisições do react
@Tag(// @Tag é usada para agrupar e descrever a API no Swagger UI
    name = "API Cliente",
    description = "API responsável pelos servidos de cliente no sistema"
)



public class ClienteController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired // estânciar um objeto
  private ClienteService clienteService;

    // @Operation descreve o propósito do endpoint abaixo
    @Operation(
       summary = "Serviço responsável por salvar um cliente no sistema.",
       description = "Exemplo de descrição de um endpoint responsável por inserir um cliente no sistema."
   )
  @PostMapping // especificar que vai receber requisições do post
  public ResponseEntity<Cliente> save(@RequestBody  @Valid ClienteRequest clienterequest, HttpServletRequest request) {

    Cliente cliente = clienteService.save(clienterequest.build(), null);
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

   @Operation(
       summary = "Serviço responsável por alterar um cliente no sistema.",
       description = "Exemplo de descrição de um endpoint responsável por inserir um produto no sistema."
   )
  @PutMapping("/{id}")
  public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody  @Valid ClienteRequest clienteRequest, HttpServletRequest request) {

    clienteService.update(id, clienteRequest.build(), null);
    return ResponseEntity.ok().build();
  }

    @Operation(
       summary = "Serviço responsável por deletar um cliente no sistema.",
       description = "Exemplo de descrição de um endpoint responsável por inserir um produto no sistema."
   )
    @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       clienteService.delete(id);
       return ResponseEntity.ok().build();
   }

}

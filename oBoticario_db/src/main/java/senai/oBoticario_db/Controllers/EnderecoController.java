package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Endereco;
import senai.oBoticario_db.service.EnderecoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
@Tag(name = "Endereços", description = "Operações relacionadas aos endereços")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    @Operation(summary = "Listar todos os endereços", description = "Retorna uma lista de todos os endereços cadastrados.")
    public List<Endereco> listarTodos() {
        return enderecoService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar endereço por ID", description = "Retorna as informações de um endereço com base no ID fornecido.")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable long id) {
        Optional<Endereco> endereco = enderecoService.buscarPorId(id);
        return endereco.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar um novo endereço", description = "Cadastra um novo endereço com as informações fornecidas.")
    public Endereco criar(@RequestBody Endereco endereco) {
        return enderecoService.salvar(endereco);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar endereço", description = "Atualiza as informações de um endereço existente com base no ID fornecido.")
    public ResponseEntity<Endereco> atualizar(@PathVariable long id, @RequestBody Endereco endereco) {
        try {
            Endereco atualizado = enderecoService.atualizar(id, endereco);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar endereço", description = "Remove um endereço do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
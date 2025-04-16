package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.oBoticario_db.model.ClienteFisico;
import senai.oBoticario_db.service.ClienteFisicoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes-fisicos")
@Tag(name = "Clientes Físicos", description = "Operações relacionadas aos clientes físicos")
public class ClienteFisicoController {

    @Autowired
    private ClienteFisicoService clienteFisicoService;

    @GetMapping
    @Operation(summary = "Listar todos os clientes físicos", description = "Retorna uma lista de todos os clientes físicos cadastrados.")
    public List<ClienteFisico> listarTodos() {
        return clienteFisicoService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cliente físico por ID", description = "Retorna as informações de um cliente físico com base no ID fornecido.")
    public ResponseEntity<ClienteFisico> buscarPorId(@PathVariable long id) {
        Optional<ClienteFisico> cliente = clienteFisicoService.buscarPorId(id);
        return cliente.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar um novo cliente físico", description = "Cadastra um novo cliente físico com as informações fornecidas.")
    public ResponseEntity<ClienteFisico> criar(@RequestBody ClienteFisico novoCliente) {
        ClienteFisico clienteSalvo = clienteFisicoService.salvar(novoCliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar cliente físico", description = "Atualiza as informações de um cliente físico existente com base no ID fornecido.")
    public ResponseEntity<ClienteFisico> atualizar(@PathVariable long id, @RequestBody ClienteFisico clienteAtualizado) {
        try {
            ClienteFisico atualizado = clienteFisicoService.atualizar(id, clienteAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar cliente físico", description = "Remove um cliente físico do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        clienteFisicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
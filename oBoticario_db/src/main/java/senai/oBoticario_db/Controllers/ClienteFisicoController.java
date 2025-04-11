package senai.oBoticario_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.oBoticario_db.model.ClienteFisico;
import senai.oBoticario_db.service.ClienteFisicoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes-fisicos")
public class ClienteFisicoController {

    @Autowired
    private ClienteFisicoService clienteFisicoService;

    @GetMapping
    public List<ClienteFisico> listarTodos() {
        return clienteFisicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteFisico> buscarPorId(@PathVariable long id) {
        Optional<ClienteFisico> cliente = clienteFisicoService.buscarPorId(id);
        return cliente.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClienteFisico> criar(@RequestBody ClienteFisico novoCliente) {
        ClienteFisico clienteSalvo = clienteFisicoService.salvar(novoCliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteFisico> atualizar(@PathVariable long id, @RequestBody ClienteFisico clienteAtualizado) {
        try {
            ClienteFisico atualizado = clienteFisicoService.atualizar(id, clienteAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        clienteFisicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

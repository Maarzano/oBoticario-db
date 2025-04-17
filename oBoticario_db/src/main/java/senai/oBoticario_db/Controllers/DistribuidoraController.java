package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Distribuidora;
import senai.oBoticario_db.service.DistribuidoraService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/distribuidora")
@Tag(name = "Distribuidoras", description = "Operações relacionadas às distribuidoras")
public class DistribuidoraController {

    @Autowired
    private DistribuidoraService distribuidoraService;

    @GetMapping
    @Operation(summary = "Listar todas as distribuidoras", description = "Retorna uma lista de todas as distribuidoras cadastradas.")
    public List<Distribuidora> listarTodos() {
        return distribuidoraService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar distribuidora por ID", description = "Retorna as informações de uma distribuidora com base no ID fornecido.")
    public ResponseEntity<Distribuidora> buscarPorId(@PathVariable long id) {
        Optional<Distribuidora> distribuidora = distribuidoraService.buscarPorId(id);
        return distribuidora.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar uma nova distribuidora", description = "Cadastra uma nova distribuidora com as informações fornecidas.")
    public Distribuidora salvar(@RequestBody Distribuidora distribuidora) {
        return distribuidoraService.salvar(distribuidora);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar distribuidora", description = "Atualiza as informações de uma distribuidora existente com base no ID fornecido.")
    public ResponseEntity<Distribuidora> atualizar(@PathVariable long id, @RequestBody Distribuidora distribuidoraAtualizado) {
        try {
            Distribuidora distribuidora = distribuidoraService.atualizar(id, distribuidoraAtualizado);
            return ResponseEntity.ok(distribuidora);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar distribuidora", description = "Remove uma distribuidora do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        distribuidoraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
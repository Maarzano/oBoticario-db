package senai.oBoticario_db.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Ausencias;
import senai.oBoticario_db.service.AusenciasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ausencias")
@Tag(name = "Ausências", description = "Operações relacionadas às ausências")
public class AusenciasController {

    @Autowired
    private AusenciasService ausenciasService;

    @GetMapping
    @Operation(summary = "Listar todas as ausências", description = "Retorna uma lista de todas as ausências cadastradas.")
    public List<Ausencias> listarTodos() {
        return ausenciasService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar ausência por ID", description = "Retorna as informações de uma ausência com base no ID fornecido.")
    public ResponseEntity<Ausencias> buscarPorId(@PathVariable long id) {
        Optional<Ausencias> ausencia = ausenciasService.buscarPorId(id);
        return ausencia.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar uma nova ausência", description = "Cadastra uma nova ausência com as informações fornecidas.")
    public ResponseEntity<Ausencias> criar(@RequestBody Ausencias novaAusencia) {
        Ausencias ausenciaSalva = ausenciasService.salvar(novaAusencia);
        return ResponseEntity.ok(ausenciaSalva);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar ausência", description = "Atualiza as informações de uma ausência existente com base no ID fornecido.")
    public ResponseEntity<Ausencias> atualizar(@PathVariable long id, @RequestBody Ausencias ausenciaAtualizada) {
        try {
            Ausencias atualizado = ausenciasService.atualizar(id, ausenciaAtualizada);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar ausência", description = "Remove uma ausência do sistema com base no ID fornecido.")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        ausenciasService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
package senai.oBoticario_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Ausencias;
import senai.oBoticario_db.service.AusenciasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ausencias")
public class AusenciasController {

    @Autowired
    private AusenciasService ausenciasService;

    @GetMapping
    public List<Ausencias> listarTodos() {
        return ausenciasService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ausencias> buscarPorId(@PathVariable long id) {
        Optional<Ausencias> ausencia = ausenciasService.buscarPorId(id);
        return ausencia.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ausencias> criar(@RequestBody Ausencias novaAusencia) {
        Ausencias ausenciaSalva = ausenciasService.salvar(novaAusencia);
        return ResponseEntity.ok(ausenciaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ausencias> atualizar(@PathVariable long id, @RequestBody Ausencias ausenciaAtualizada) {
        try {
            Ausencias atualizado = ausenciasService.atualizar(id, ausenciaAtualizada);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        ausenciasService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

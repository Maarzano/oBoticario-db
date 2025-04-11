package senai.oBoticario_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Ferias;
import senai.oBoticario_db.service.FeriasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ferias")
public class FeriasController {

    @Autowired
    private FeriasService feriasService;

    @GetMapping
    public List<Ferias> listarTodos() {
        return feriasService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ferias> buscarPorId(@PathVariable long id) {
        Optional<Ferias> ferias = feriasService.buscarPorId(id);
        return ferias.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ferias> criar(@RequestBody Ferias novasFerias) {
        Ferias feriasSalvas = feriasService.salvar(novasFerias);
        return ResponseEntity.ok(feriasSalvas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ferias> atualizar(@PathVariable long id, @RequestBody Ferias feriasAtualizadas) {
        try {
            Ferias atualizado = feriasService.atualizar(id, feriasAtualizadas);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        feriasService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

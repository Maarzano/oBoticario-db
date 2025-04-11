package senai.oBoticario_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Lojas;
import senai.oBoticario_db.service.LojasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lojas")
public class LojasController {

    @Autowired
    private LojasService lojasService;

    @GetMapping
    public List<Lojas> listarTodos() {
        return lojasService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lojas> buscarPorId(@PathVariable long id) {
        Optional<Lojas> loja = lojasService.buscarPorId(id);
        return loja.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Lojas> criar(@RequestBody Lojas novaLoja) {
        Lojas lojaSalva = lojasService.salvar(novaLoja);
        return ResponseEntity.ok(lojaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lojas> atualizar(@PathVariable long id, @RequestBody Lojas lojaAtualizada) {
        try {
            Lojas atualizada = lojasService.atualizar(id, lojaAtualizada);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        lojasService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

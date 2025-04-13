package senai.oBoticario_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Revendedores;
import senai.oBoticario_db.service.RevendedoresService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/revendedores")
public class RevendedoresController {
    
    @Autowired
    private RevendedoresService revendedoresService;

    @GetMapping
    public List<Revendedores> listarTodos() {
        return revendedoresService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Revendedores> buscarPorId(@PathVariable long id) {
        Optional<Revendedores> revendedore = revendedoresService.buscarPorId(id);
        return revendedore.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Revendedores> criar(@RequestBody Revendedores novoRevendedor) {
        Revendedores revendedorSalvo = revendedoresService.salvar(novoRevendedor);
        return ResponseEntity.ok(revendedorSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Revendedores> atualizar(@PathVariable long id, @RequestBody Revendedores revendedorAtualizado) {
        try {
            Revendedores atualizada = revendedoresService.atualizar(id, revendedorAtualizado);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        revendedoresService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

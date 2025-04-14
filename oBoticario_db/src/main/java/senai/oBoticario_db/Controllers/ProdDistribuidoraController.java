package senai.oBoticario_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.ProdDistribuidora;
import senai.oBoticario_db.service.ProdDistribuidoraService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdDistribuidoraController {

    @Autowired
    private ProdDistribuidoraService prodDistribuidoraService;

    @GetMapping
    public List<ProdDistribuidora> listarTodos() {
        return prodDistribuidoraService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdDistribuidora> buscarPorId(@PathVariable long id) {
        Optional<ProdDistribuidora> produto = prodDistribuidoraService.buscarPorId(id);
        return produto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProdDistribuidora> criar(@RequestBody ProdDistribuidora novoProduto) {
        ProdDistribuidora produtoSalvo = prodDistribuidoraService.salvar(novoProduto);
        return ResponseEntity.ok(produtoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdDistribuidora> atualizar(@PathVariable long id, @RequestBody ProdDistribuidora produtoAtualizado) {
        try {
            ProdDistribuidora atualizado = prodDistribuidoraService.atualizar(id, produtoAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        prodDistribuidoraService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
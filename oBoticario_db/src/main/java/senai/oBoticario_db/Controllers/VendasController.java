package senai.oBoticario_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.Vendas;
import senai.oBoticario_db.service.VendasService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    private VendasService vendasService;

    @GetMapping
    public List<Vendas> listarTodos() {
        return vendasService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendas> buscarPorId(@PathVariable long id) {
        Optional<Vendas> venda = vendasService.buscarPorId(id);
        return venda.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vendas> criar(@RequestBody Vendas novaVenda) {
        Vendas vendaSalva = vendasService.salvar(novaVenda);
        return ResponseEntity.ok(vendaSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendas> atualizar(@PathVariable long id, @RequestBody Vendas vendaAtualizada) {
        try {
            Vendas atualizada = vendasService.atualizar(id, vendaAtualizada);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        vendasService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

package senai.oBoticario_db.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import senai.oBoticario_db.model.PedidosRevendedor;
import senai.oBoticario_db.service.Pedidos_RevendedorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos_revendedor ")
public class PedidosRevendedorController {
    
    @Autowired
    private Pedidos_RevendedorService pedidos_RevendedorService;

    @GetMapping
    public List<PedidosRevendedor> listarTodos() {
        return pedidos_RevendedorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidosRevendedor> buscarPorId(@PathVariable long id) {
        Optional<PedidosRevendedor> Pedidos_Revendedo = pedidos_RevendedorService.buscarPorId(id);
        return Pedidos_Revendedo.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PedidosRevendedor> criar(@RequestBody PedidosRevendedor Pedidos_RevendedorNova) {
        PedidosRevendedor Pedidos_RevendedorSalva = pedidos_RevendedorService.salvar(Pedidos_RevendedorNova);
        return ResponseEntity.ok(Pedidos_RevendedorSalva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidosRevendedor> atualizar(@PathVariable long id, @RequestBody PedidosRevendedor pedidos_RevendedorAtualizado) {
        try {
            PedidosRevendedor atualizada = pedidos_RevendedorService.atualizar(id, pedidos_RevendedorAtualizado);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        pedidos_RevendedorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
